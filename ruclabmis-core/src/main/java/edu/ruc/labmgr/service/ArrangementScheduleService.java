package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ArrangementScheduleMapper;
import edu.ruc.labmgr.mapper.CurriculumScheduleMapper;
import edu.ruc.labmgr.mapper.TermYearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@Service
public class ArrangementScheduleService {

    @Autowired
    private ArrangementScheduleMapper mapper;

	@Autowired
	private CurriculumScheduleMapper curriculumScheduleMapper;

    public int insert(ArrangementSchedule arrangementSchedule){
        return mapper.insert(arrangementSchedule);
    }

    public int delete(int arrangementId, int scheduleId){
        ArrangementScheduleCriteria arrangementScheduleCriteria = new ArrangementScheduleCriteria();
        ArrangementScheduleCriteria.Criteria criteria = arrangementScheduleCriteria.createCriteria();
        criteria.andArrangementIdEqualTo(arrangementId);
        criteria.andCurriculumsheduleIdEqualTo(scheduleId);
        return mapper.deleteByCriteria(arrangementScheduleCriteria);
    }
	public int delete(int arrangementId){
		ArrangementScheduleCriteria arrangementScheduleCriteria = new ArrangementScheduleCriteria();
		ArrangementScheduleCriteria.Criteria criteria = arrangementScheduleCriteria.createCriteria();
		criteria.andArrangementIdEqualTo(arrangementId);
		return mapper.deleteByCriteria(arrangementScheduleCriteria);
	}
    public Integer getSecheduleIdByArrangementId(Integer arrangementId){
        ArrangementScheduleCriteria arrangementScheduleCriteria = new ArrangementScheduleCriteria();
        ArrangementScheduleCriteria.Criteria criteria = arrangementScheduleCriteria.createCriteria();
        criteria.andArrangementIdEqualTo(arrangementId);

        List<ArrangementSchedule> asList = mapper.selectByCriteria(arrangementScheduleCriteria);
        return asList.get(0).getCurriculumsheduleId();
    }
	public List<Integer> getSecheduleIdListByArrangementId(Integer arrangementId){
		ArrangementScheduleCriteria arrangementScheduleCriteria = new ArrangementScheduleCriteria();
		ArrangementScheduleCriteria.Criteria criteria = arrangementScheduleCriteria.createCriteria();
		criteria.andArrangementIdEqualTo(arrangementId);

		List<ArrangementSchedule> asList = mapper.selectByCriteria(arrangementScheduleCriteria);
		List<Integer> scheduleIdList= new ArrayList<>();
		for(ArrangementSchedule arrangementSchedule:asList){
			scheduleIdList.add(arrangementSchedule.getCurriculumsheduleId());
		}
		return scheduleIdList;
	}
	public CurriculumSchedule getSecheduleInfoByArrangementId(Integer arrangementId){
		ArrangementScheduleCriteria arrangementScheduleCriteria = new ArrangementScheduleCriteria();
		ArrangementScheduleCriteria.Criteria criteria = arrangementScheduleCriteria.createCriteria();
		criteria.andArrangementIdEqualTo(arrangementId);

		List<ArrangementSchedule> asList = mapper.selectByCriteria(arrangementScheduleCriteria);
		return curriculumScheduleMapper.selectByPrimaryKey(asList.get(0).getCurriculumsheduleId());
	}
}
