package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Arrangement;
import edu.ruc.labmgr.domain.ArrangementCriteria;
import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.mapper.ArrangementMapper;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ArrangementService {

    @Autowired
    ArrangementMapper arrangementMapper;

	@Autowired
	ArrangementScheduleService arrangementScheduleService;
    public int insert(Arrangement arrangement) {
        int result = 0;
        result = arrangementMapper.insert(arrangement);
        return result;
    }

    public int update(Arrangement arrangement) {
        int result = 0;
        result = arrangementMapper.updateByPrimaryKey(arrangement);
        return result;
    }

    public Arrangement selectByPrimaryKey(int id) {
        Arrangement Arrangement = null;
        Arrangement = arrangementMapper.selectByPrimaryKey(id);
        return Arrangement;
    }

    public List<Arrangement> selectAllArrangements() {
        return arrangementMapper.selectByCriteria(null);
    }


    public  PageInfo<Arrangement> pageAllCurrArrangements(int pageNum) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetSTimeIsNull().andMeetETimeIsNull();
        arrangementCriteria.setOrderByClause("id desc");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }

    public  PageInfo<Arrangement> pageCurrArrangementsByUser(int pageNum, Integer userId) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetSTimeIsNull().andMeetETimeIsNull();
        arrangementCriteria.setOrderByClause("id desc");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }


    public  PageInfo<Arrangement> pageAllCurrArrangMeetings(int pageNum) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull();
        arrangementCriteria.setOrderByClause("id desc");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }
	//multi
	public  PageInfo<Arrangement> multiAllCurrArrangMeetings(int pageNum) {
		ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
		ArrangementCriteria.Criteria criteria01 = arrangementCriteria.createCriteria();
		ArrangementCriteria.Criteria criteria02 = arrangementCriteria.createCriteria();
		criteria01.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次实验室预约");
		criteria02.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次会议室预约");
		arrangementCriteria.or(criteria02);

		return getMulttiPageArrangementByCriteria(pageNum, arrangementCriteria);
	}

    public  PageInfo<Arrangement> pageCurrArrangMeetingsByUser(int pageNum, Integer userId) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull();
        arrangementCriteria.setOrderByClause("id desc");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }
	//multi
	public  PageInfo<Arrangement> multiCurrArrangMeetingsByUser(int pageNum, Integer userId) {
		ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
		ArrangementCriteria.Criteria criteria01 = arrangementCriteria.createCriteria();
		ArrangementCriteria.Criteria criteria02 = arrangementCriteria.createCriteria();

		criteria01.andUserIdEqualTo(userId).andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次实验室预约");
		criteria02.andUserIdEqualTo(userId).andStateEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次会议室预约");
		arrangementCriteria.or(criteria02);

		return getMulttiPageArrangementByCriteria(pageNum, arrangementCriteria);
	}

    public  PageInfo<Arrangement> pageAllHistoryArrangements(int pageNum) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetSTimeIsNull().andMeetETimeIsNull();
        arrangementCriteria.setOrderByClause("id desc");
        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }


    public  PageInfo<Arrangement> pageHistoryArrangementsByUser(int pageNum, Integer userId) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetSTimeIsNull().andMeetETimeIsNull();
        arrangementCriteria.setOrderByClause("id desc");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }

    public  PageInfo<Arrangement> pageAllHistoryArrangMeetings(int pageNum) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull();
        arrangementCriteria.setOrderByClause("id desc");
        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }
	//multi
	public  PageInfo<Arrangement> multiAllHistoryArrangMeetings(int pageNum) {
		ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
		ArrangementCriteria.Criteria criteria01 = arrangementCriteria.createCriteria();
		ArrangementCriteria.Criteria criteria02 = arrangementCriteria.createCriteria();
		criteria01.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次实验室预约");
		criteria02.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次会议室预约");
		arrangementCriteria.or(criteria02);

		arrangementCriteria.setOrderByClause("id desc");


		return getMulttiPageArrangementByCriteria(pageNum, arrangementCriteria);
	}

    public  PageInfo<Arrangement> pageHistoryArrangMeetingsByUser(int pageNum, Integer userId) {
        ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
        ArrangementCriteria.Criteria criteria = arrangementCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull();
        arrangementCriteria.setOrderByClause("id desc");

        return getPageArrangementByCriteria(pageNum, arrangementCriteria);
    }
	//multi
	public  PageInfo<Arrangement> multiHistoryArrangMeetingsByUser(int pageNum, Integer userId) {
		ArrangementCriteria arrangementCriteria = new ArrangementCriteria();
		ArrangementCriteria.Criteria criteria01 = arrangementCriteria.createCriteria();
		ArrangementCriteria.Criteria criteria02 = arrangementCriteria.createCriteria();
		criteria01.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次实验室预约");
		criteria02.andStateNotEqualTo((byte) Types.ApplyState.WAITING.getValue()).andMeetETimeIsNotNull().andMeetSTimeIsNotNull().andTypeEqualTo("多次会议室预约");
		arrangementCriteria.or(criteria02);

		return getMulttiPageArrangementByCriteria(pageNum, arrangementCriteria);
	}

    private PageInfo<Arrangement> getPageArrangementByCriteria(int pageNum, ArrangementCriteria criteria) {
        int totalCount = arrangementMapper.countByCriteria(criteria);
        PageInfo<Arrangement> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Arrangement> data = arrangementMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

	private PageInfo<Arrangement> getMulttiPageArrangementByCriteria(int pageNum, ArrangementCriteria criteria) {
		int totalCount = arrangementMapper.countByCriteria(criteria);
		PageInfo<Arrangement> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Arrangement> data = arrangementMapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));

		List<Arrangement> newData= new ArrayList<>();

		for(Arrangement arrangement:data){
			CurriculumSchedule curriculumSchedule= arrangementScheduleService.getSecheduleInfoByArrangementId(arrangement.getId());
			arrangement.setBeginWeek(curriculumSchedule.getSectionBegin());
			arrangement.setEndWeek(curriculumSchedule.getSectionEnd());
			arrangement.setWeekDay(curriculumSchedule.getWeekdays());
			newData.add(arrangement);
		}
		page.setData(newData);
		return page;
	}
    public void delete(Integer id) {
        arrangementMapper.deleteByPrimaryKey(id);
    }
}
