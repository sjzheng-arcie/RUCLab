package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.MessageMapper;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-10-18
 * Time: 下午2:52
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserService serviceUser;
    @Autowired
    private ApplyWithEquipmentService serviceApply;

    public ObjectListPage<Message> selectListPage(int currentPage, MessageCriteria criteria){


        ObjectListPage<Message> retList = null;
        try {
            String count = SysUtil.getConfigValue("showCount", "10");

            int limit = Integer.valueOf(count);
            int currentResult = (currentPage - 1) * limit;
            int totalCount = messageMapper.countByCriteria(criteria);
            int pageCount = (totalCount % limit == 0) ? (totalCount / limit) : (1 + totalCount / limit);

            PageInfo pageInfo = new PageInfo();
            pageInfo.setTotalResult(totalCount);
            pageInfo.setTotalPage(pageCount);
            pageInfo.setCurrentPage(currentPage);

            RowBounds bounds = new RowBounds(currentResult, limit);
            List<Message> messageList= messageMapper.selectByCriteriaWithRowbounds(criteria, bounds);

            retList = new ObjectListPage(pageInfo, messageList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;
    }

    public  int getCount(MessageCriteria criteria){

        int count = messageMapper.countByCriteria(criteria);

        return count;
    }
    public int insert(Message message) {
        int result = 0;
        try {
            result = messageMapper.insert(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int deleteById(int id) {
        int result = 0;
        try {
            result = messageMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public void updateByMessage(Message message){
        try {
            messageMapper.updateByPrimaryKey(message);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public Message selectById(int id) {
        Message message = null;
        try {
            message = messageMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
    public List<Message> getMessageListByCriteia(MessageCriteria messageCriteria){
        List<Message> messageList= null;
        try{
            RowBounds bounds = new RowBounds(0, 6);
            messageList= messageMapper.selectByCriteriaWithRowbounds(messageCriteria,bounds);
            for (int i=0;i<messageList.size();i++){
                String content="空";
                if(messageList.get(i).getContent().length()>30){
                    content=messageList.get(i).getContent().substring(0,30)+"......";

                }else{
                    content=messageList.get(i).getContent();
                }
                messageList.get(i).setContent(content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  messageList;
    }

    //提交申请时，向设备管理员和领导发送消息
    public void sendUpdateApplyMessage(ApplicationForm applicationForm,  Types.ApplyType type, String path){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Message message = new Message();
        message.setIfread(false);
        message.setSendtime(new Date());
        message.setSenderId(0);

        User applicant = serviceUser.selectByPrimaryKey(applicationForm.getApplicantId());

        List<User> leaders = serviceUser.getRoleUserList(Types.Role.LEADER);
        for(User leader : leaders){
            if(leader.getId() == applicant.getId())
                continue;
            message.setReceiverId(leader.getId());
            String content = "";
            content +=  applicant.getName()+" 于"+format.format(applicationForm.getApplyTime())+" 提出 "+ type.getTitle() +" 申请: ";

            String listPath = path.substring(0, path.lastIndexOf("/"));
            listPath += "/applyList?formType=review";

            content += " <a href='"+listPath+"'>查看申请</a>" ;
            message.setContent(content);
            insert(message);
        }

        List<User> equpiAdmins = serviceUser.getRoleUserList(Types.Role.EQUIPMENT_ADMIN);
        for(User equpiAdmin : equpiAdmins){
            if(equpiAdmin.getId() == applicant.getId())
                continue;
            message.setReceiverId(equpiAdmin.getId());
            String content = "";
            content +=  applicant.getName()+" 于"+format.format(applicationForm.getApplyTime())+" 提出 "+ type.getTitle() +" 申请: ";

            String listPath = path.substring(0, path.lastIndexOf("/"));
            listPath += "/applyList?formType=process";
            content += " <a href='"+path+"'>查看申请</a>" ;

            message.setContent(content);
            insert(message);
        }
    }

    //审批 通过/拒绝 申请时，向申请提交人和设备管理员发送消息
    public void sendApproveApplyMessage(int appId,  Types.ApplyType type, String path, boolean isPassed) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Message message = new Message();
        message.setIfread(false);
        message.setSendtime(new Date());

        ApplyWithEquipment apply = serviceApply.selectApplyById(appId);
        message.setSenderId(0);

        User applicant = serviceUser.selectByPrimaryKey(apply.getApplicantId());
        message.setReceiverId(applicant.getId());
        String content = "";
        content +=  apply.getApproverName()+" 于"+format.format(apply.getApproveTime());
        content += isPassed ? " 批准 " : "拒绝";
        content += "了您的 "+ type.getTitle() +" 申请: ";

        String listPath = path.substring(0, path.lastIndexOf("/"));
        listPath += "/applyList?formType=apply";
        content += " <a href='"+path+"'>查看申请</a>" ;

        message.setContent(content);
        insert(message);

        List<User> equpiAdmins = serviceUser.getRoleUserList(Types.Role.EQUIPMENT_ADMIN);
        for(User equpiAdmin : equpiAdmins){
            if(equpiAdmin.getId() == applicant.getId())
                continue;

            message.setReceiverId(equpiAdmin.getId());
            String adminContent = "";
            adminContent +=  apply.getApproverName()+" 于"+format.format(apply.getApproveTime());
            adminContent += isPassed ? " 批准 " : "拒绝";
            adminContent += "了 " + apply.getApplicantName() + " 的 "+ type.getTitle() +" 申请: ";

            String listAdminPath = path.substring(0, path.lastIndexOf("/"));
            listAdminPath += "/applyList?formType=process";
            adminContent += " <a href='"+listAdminPath+"'>查看申请</a>" ;

            message.setContent(adminContent);
            insert(message);
        }
    }

    //处理表单申请时，向申请提交人和领导发送消息
    public void sendProcessApplyMessage(int appId,  Types.ApplyType type, String path){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Message message = new Message();
        message.setIfread(false);
        message.setSendtime(new Date());

        ApplyWithEquipment apply = serviceApply.selectApplyById(appId);
        message.setSenderId(0);

        User applicant = serviceUser.selectByPrimaryKey(apply.getApplicantId());
        message.setReceiverId(applicant.getId());
        String content = "";
        content +=  apply.getOperatorName()+" 于"+format.format(apply.getApproveTime());
        content += "处理了您的 "+ type.getTitle() +" 申请: ";

        String listPath = path.substring(0, path.lastIndexOf("/"));
        listPath += "/applyList?formType=history";
        content += " <a href='"+listPath+"'>查看申请</a>" ;

        message.setContent(content);
        insert(message);

        List<User> equpiAdmins = serviceUser.getRoleUserList(Types.Role.LEADER);
        for(User equpiAdmin : equpiAdmins){
            if(equpiAdmin.getId() == applicant.getId())
                continue;

            message.setReceiverId(equpiAdmin.getId());
            String adminContent = "";
            adminContent +=  apply.getApproverName()+" 于"+format.format(apply.getApproveTime());
            adminContent += "处理了 " + apply.getApplicantName() + " 的 "+ type.getTitle() +" 申请: ";
            content += " <a href='"+listPath+"'>查看申请</a>" ;
            message.setContent(adminContent);
            insert(message);
        }
    }

}
