package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.Message;
import edu.ruc.labmgr.domain.MessageCriteria;
import edu.ruc.labmgr.mapper.MessageMapper;
import edu.ruc.labmgr.utils.SysUtil;
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
    public ObjectListPage<Message> selectListPage(int currentPage, MessageCriteria criteria){


		ObjectListPage<Message> retList = null;
		try {
			String count = SysUtil.getConfigValue("", "6");

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

	public boolean sendApplicationStateMessage(ApplicationForm applicationForm,String messageType){

		Message message = new Message();
		message.setIfread(false);
		message.setSendtime(new Date());
		if (messageType.equals("request")){
			message.setReceiverId(applicationForm.getApproverId());
			message.setSenderId(applicationForm.getApplicantId());
			message.setContent(applicationForm.getApplicant().getName() + "于" + applicationForm.getApplyTime() + "向您提出" + applicationForm.getFormType());
			insert(message);
		}else if(messageType.equals("response")){
			message.setReceiverId(applicationForm.getApplicantId());
			message.setSenderId(applicationForm.getApproverId());
			message.setContent(applicationForm.getApprover().getName()+"于"+applicationForm.getProcessTime()+"批准了您的"+applicationForm.getFormType());
			insert(message);

			message.setContent(applicationForm.getApprover().getName()+"于"+applicationForm.getProcessTime()+"批准了"+applicationForm.getApplicant().getName()+"的"+
				applicationForm.getFormType()	+"，请准备好设备。");
			message.setReceiverId(applicationForm.getOperatorId());
			message.setSenderId(applicationForm.getApproverId());
			insert(message);
		}
		return true;
	}
	public void sendMessageToLeader(ApplicationForm applicationForm){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Message message = new Message();
		message.setIfread(false);
		message.setSendtime(new Date());
		message.setReceiverId(applicationForm.getApproverId());
		message.setSenderId(applicationForm.getApplicantId());
		message.setContent(applicationForm.getApplicant().getName()+"于"+format.format(applicationForm.getApplyTime())+"向您提出"+applicationForm.getFormType());
		insert(message);
	}
	public void sendMessageToTeacher(ApplicationForm applicationForm){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Message message = new Message();
		message.setIfread(false);
		message.setSendtime(new Date());
		message.setReceiverId(applicationForm.getApplicantId());
		message.setSenderId(applicationForm.getApproverId());
		message.setContent("您好，" + applicationForm.getApprover().getName() + "已于" + format.format(applicationForm.getProcessTime()) + "批准了您的" + applicationForm.getFormType());
		insert(message);

	}
	public void sendMessageToEquipmentAdmin(ApplicationForm applicationForm){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Message message = new Message();
		message.setIfread(false);
		message.setSendtime(new Date());
		message.setContent(applicationForm.getApprover().getName()+"于"+ format.format(applicationForm.getProcessTime())+"批准了"+applicationForm.getApplicant().getName()+"的"+
				applicationForm.getFormType()	+"，请准备好设备。");
		message.setReceiverId(applicationForm.getOperatorId());
		message.setSenderId(applicationForm.getApproverId());
		insert(message);
	}
}
