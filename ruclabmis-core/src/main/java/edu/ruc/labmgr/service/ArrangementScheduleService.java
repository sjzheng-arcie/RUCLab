package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ArrangementSchedule;
import edu.ruc.labmgr.domain.ArrangementScheduleCriteria;
import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.domain.TermYearCriteria;
import edu.ruc.labmgr.mapper.ArrangementScheduleMapper;
import edu.ruc.labmgr.mapper.TermYearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("ALL")
@Service
public class ArrangementScheduleService {

    @Autowired
    private ArrangementScheduleMapper mapper;

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

    public Integer getSecheduleIdByArrangementId(Integer arrangementId){
        ArrangementScheduleCriteria arrangementScheduleCriteria = new ArrangementScheduleCriteria();
        ArrangementScheduleCriteria.Criteria criteria = arrangementScheduleCriteria.createCriteria();
        criteria.andArrangementIdEqualTo(arrangementId);

        List<ArrangementSchedule> asList = mapper.selectByCriteria(arrangementScheduleCriteria);
        return asList.get(0).getCurriculumsheduleId();
    }
}
