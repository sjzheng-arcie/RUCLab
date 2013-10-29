package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Message;
import edu.ruc.labmgr.domain.MessageCriteria;
import edu.ruc.labmgr.mapper.MessageMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			RowBounds bounds = new RowBounds(1, 8);
			messageList= messageMapper.selectByCriteriaWithRowbounds(messageCriteria,bounds);
		}catch (Exception e){
			e.printStackTrace();
		}

		return  messageList;
	}
}
