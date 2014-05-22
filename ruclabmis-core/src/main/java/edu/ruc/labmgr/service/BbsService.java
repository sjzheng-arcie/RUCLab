package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.BbsReplyMapper;
import edu.ruc.labmgr.mapper.BbsSessionMapper;
import edu.ruc.labmgr.mapper.BbsTopicMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: sjzheng
 * Date: 13-12-16
 * Time: 下午3:02
 * Des:
 */
@Service
public class BbsService {
	@Autowired
	BbsTopicMapper bbsTopicMapper;
	@Autowired
	BbsSessionMapper bbsSessionMapper;
	@Autowired
	BbsReplyMapper bbsReplyMapper;
	@Autowired
	UserService userService;


	public PageInfo<BbsTopic> getPageTopicbyCouseId(int courseId,int pageNum){
		BbsTopicCriteria bbsTopicCriteria = new BbsTopicCriteria();
		BbsTopicCriteria.Criteria c = bbsTopicCriteria.or();
		c.andJoinPostUser();
		c.andSessionidEqualTo(courseId);
		bbsTopicCriteria.setOrderByClause("bt.creatTime desc");
		return getPageTopic(pageNum,bbsTopicCriteria);



	}
	public PageInfo<BbsReply> getPageReplyByTopicId(int topicId ,int pageNum){
		BbsReplyCriteria criteria = new BbsReplyCriteria();
		BbsReplyCriteria.Criteria c = criteria.or();
		c.andJoinReplierUser();
		c.andTopicidEqualTo(topicId);
		criteria.setOrderByClause("br.replyTime asc");
		return getPageReplyByCriteria(pageNum,criteria);

	}
	public List<BbsReply> getReplysByTopicId(int topicId){
		BbsReplyCriteria criteria = new BbsReplyCriteria();
		BbsReplyCriteria.Criteria c = criteria.or();
		c.andJoinReplierUser();
		c.andTopicidEqualTo(topicId);
		List<BbsReply> bbsTopicList = new ArrayList<BbsReply>();
		 bbsTopicList = bbsReplyMapper.selectByCriteria(criteria);
		return bbsTopicList;
	}



	private PageInfo<BbsReply> getPageReplyByCriteria(int pageNum,BbsReplyCriteria criteria){
		//数量还要加上一条主贴
		int totalCount = bbsReplyMapper.countByCriteria(criteria)+1;
		PageInfo<BbsReply> p = new PageInfo<BbsReply>(totalCount,5,pageNum);
		List<BbsReply> bbsReplyList = new ArrayList<BbsReply>();
		bbsReplyList = bbsReplyMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(p.getCurrentResult(),p.getPageSize()));
		for (BbsReply br: bbsReplyList){
			User usr = userService.getUserbyId(br.getReplyuserid());
			br.setReplyUserRole(usr.getRole().getName());
		}
		p.setData(bbsReplyList);
		return  p;

	}
	public List<BbsTopic> getTodayHotList(List<Integer> sids){
		BbsTopicCriteria criteria = new BbsTopicCriteria();
		BbsTopicCriteria.Criteria c = criteria.or();
		c.andTodayTopic();
		c.andJoinPostUser();
		c.andSessionidIn(sids);
		criteria.setOrderByClause("bt.replycount desc");
//		List<BbsTopic> bbsTopicList =null;
		List<BbsTopic> bbsTopicList = bbsTopicMapper.selectByCriteriaWithRowbounds(criteria,new RowBounds(0,8));
		return  bbsTopicList;

	}
	public List<BbsTopic> getWeekHotList(List<Integer> sids){
		BbsTopicCriteria criteria = new BbsTopicCriteria();
		BbsTopicCriteria.Criteria c = criteria.or();
		c.andWeekTopic();
		c.andJoinPostUser();
		c.andSessionidIn(sids);
		criteria.setOrderByClause("bt.replycount desc");
		List<BbsTopic> bbsTopicList = new ArrayList<BbsTopic>();
		bbsTopicList = bbsTopicMapper.selectByCriteriaWithRowbounds(criteria,new RowBounds(0,8));
		return  bbsTopicList;

	}
	public List<BbsTopic> getNewestCreatList(List<Integer> sids){
		BbsTopicCriteria criteria = new BbsTopicCriteria();
		BbsTopicCriteria.Criteria c = criteria.or();
		criteria.setOrderByClause("bt.creatTime  desc");
		c.andJoinPostUser();
		c.andSessionidIn(sids);
		List<BbsTopic> bbsTopicList = new ArrayList<BbsTopic>();
		bbsTopicList = bbsTopicMapper.selectByCriteriaWithRowbounds(criteria,new RowBounds(0,8));
		return  bbsTopicList;

	}
	public List<BbsTopic> getNewestReplyList(List<Integer> sids){
		BbsTopicCriteria criteria = new BbsTopicCriteria();
		BbsTopicCriteria.Criteria c = criteria.or();
		c.andJoinPostUser();
		criteria.setOrderByClause("bt.lastRepliedTime desc");
		c.andSessionidIn(sids);
		List<BbsTopic> bbsTopicList = new ArrayList<BbsTopic>();
		bbsTopicList = bbsTopicMapper.selectByCriteriaWithRowbounds(criteria,new RowBounds(0,8));
		return  bbsTopicList;

	}
	private PageInfo<BbsTopic> getPageTopic(int pageNum,BbsTopicCriteria criteria){
		int totalCount = bbsTopicMapper.countByCriteria(criteria);
		PageInfo<BbsTopic> p = new PageInfo<>(totalCount,10,pageNum);
		 List<BbsTopic> bbsTopicList = new ArrayList<BbsTopic>();
		bbsTopicList = bbsTopicMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(p.getCurrentResult(),p.getPageSize()));
		p.setData(bbsTopicList);
		return  p;
	}
	public String getSessionTitleByCouseId (int couseId){
		BbsSession bbsSession = bbsSessionMapper.selectByPrimaryKey(couseId);
		return bbsSession.getDescription();
	}
	public int insertTopic(BbsTopic bbsTopic){
		int result = 0;
		bbsTopic.setClickcount(0);
		bbsTopic.setReplycount(0);
		bbsTopic.setCreattime(new Date());
		bbsTopic.setIsclosed(true);
		result = bbsTopicMapper.insert(bbsTopic);
		return result;
	}

    public int insertSession(BbsSession session){
        int result = 0;
        result = bbsSessionMapper.insert(session);
        return result;
    }
	public int insertReply(BbsReply reply,int topicId,int ReplyUserId){
		int result = 0 ;
		reply.setReplytime(new Date());
		reply.setReplyuserid(ReplyUserId);
		reply.setTopicid(topicId);
		result = bbsReplyMapper.insert(reply);
		//修改topic 表
		BbsTopic bbsTopic = bbsTopicMapper.selectByPrimaryKey(topicId);
		int replyCount = bbsTopic.getReplycount();
		bbsTopic.setReplycount(replyCount+1);
		bbsTopic.setLastrepliedtime(reply.getReplytime());
		bbsTopic.setLastreplieduser(ReplyUserId);
		bbsTopicMapper.updateByPrimaryKey(bbsTopic);
		return  result;

	}
	public BbsTopic selectTopicByPrimaryKey(int topicId){
		BbsTopic bbsTopic = null;
		bbsTopic = bbsTopicMapper.selectByPrimaryKey(topicId);
		return  bbsTopic;
	}
	public int updateTopicByPrimarySelective(BbsTopic bbsTopic){
		int result = 0;
		result = bbsTopicMapper.updateByPrimaryKeySelective(bbsTopic);
		return  result;
	}
	public BbsReply selectReplyByPrimaryKey(int replyId){
		BbsReply bbsReply= null;
		bbsReply = bbsReplyMapper.selectByPrimaryKey(replyId);
		return bbsReply;
	}
	public int updateReplyByPrimarySelective(BbsReply bbsReply){
		int result =0;
		result = bbsReplyMapper.updateByPrimaryKeySelective(bbsReply);
		return result;
	}
	public int deleteTopicAndReplyByPrimaryKey(int topicId){
		int result =0;
		List<BbsReply> bbsReplyList = getReplysByTopicId(topicId);
/*		for(BbsReply reply : bbsReplyList){
			bbsReplyMapper.deleteByPrimaryKey(reply.getId());
		}*/
 		result = bbsTopicMapper.deleteByPrimaryKey(topicId);
		return result;

	}
	public  int deleteReplyByPrimaryKey(int replyId){
		int result =0;
		BbsReply bbsReply = bbsReplyMapper.selectByPrimaryKey(replyId);
		int topicId = bbsReply.getTopicid();
		BbsTopic bbsTopic = bbsTopicMapper.selectByPrimaryKey(topicId);
		int replyCount= bbsTopic.getReplycount();
		if(replyCount>0){
			bbsTopic.setReplycount(replyCount-1);
		}
		bbsTopicMapper.updateByPrimaryKeySelective(bbsTopic);
		result = bbsReplyMapper.deleteByPrimaryKey(replyId);

		return result;
	}


    public void saveOrUpdateBbsSessions(List<BbsSession> bbsSessions) {
        if (bbsSessions != null) {
            for (BbsSession bbsSession : bbsSessions) {

                BbsSession session = bbsSessionMapper.selectByPrimaryKey(bbsSession.getId());

                if (session != null && session.getId() != null) {
                    bbsSessionMapper.updateByPrimaryKey(bbsSession);
                } else {
                    bbsSessionMapper.insert(bbsSession);
                }
            }
        }
    }
}
