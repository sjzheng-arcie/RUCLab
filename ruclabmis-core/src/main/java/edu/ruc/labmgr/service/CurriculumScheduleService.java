package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import edu.ruc.labmgr.mapper.ClassStudentMapper;
import edu.ruc.labmgr.mapper.CurriculumScheduleMapper;
import edu.ruc.labmgr.mapper.TermYearMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@SuppressWarnings("ALL")
@Service
public class CurriculumScheduleService {
    @Autowired
    CurriculumScheduleMapper curriculumScheduleMapper;
    @Autowired
    ClassStudentMapper classStudentMapper;
    @Autowired
    TermYearService yearService;

    public void deleteById(int id){
        curriculumScheduleMapper.deleteByPrimaryKey(id);
    }

    public void add(CurriculumSchedule curriculumSchedule){
        curriculumScheduleMapper.insert(curriculumSchedule);
    }

    public CurriculumSchedule getCurriculumScheduleById(int id){
        return  curriculumScheduleMapper.selectByPrimaryKey(id);
    }

    public void update(CurriculumSchedule curriculumSchedule){
        curriculumScheduleMapper.updateByPrimaryKey(curriculumSchedule);
    }

    public boolean ifCurriculumScheduleExistd (CurriculumSchedule curriculumSchedule){
        CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
        CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
        CurriculumScheduleCriteria.Criteria criteria1 = curriculumScheduleCriteria.createCriteria();

        criteria.andAmPmEqualTo(curriculumSchedule.getAmPm());
        criteria.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
        criteria.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
        criteria.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
        criteria.andClassIdEqualTo(curriculumSchedule.getClassId());

        criteria1.andAmPmEqualTo(curriculumSchedule.getAmPm());
        criteria1.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
        criteria1.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
        criteria1.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
        criteria1.andTeacheridEqualTo(curriculumSchedule.getTeacherid());

        curriculumScheduleCriteria.or(criteria);
        curriculumScheduleCriteria.or(criteria1);

        boolean flag=false;
        if(curriculumScheduleMapper.selectByCriteria(curriculumScheduleCriteria).size()>0){
            flag=true;
        }
        return flag;
    }

    public PageInfo<CurriculumSchedule> selectListPage(CurriculumScheduleCriteria criteria, int pageNum) {
        int totalCount = curriculumScheduleMapper.countByCriteria(criteria);
        PageInfo<CurriculumSchedule> page = new PageInfo<>(totalCount, -1, pageNum);
        List<CurriculumSchedule> data = curriculumScheduleMapper.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public List<CurriculumSchedule> getCurriculumScheduleList(){
        return curriculumScheduleMapper.selectByCriteria(null);
    }
    public List<CurriculumSchedule> getCurriculumScheduleListGroupByWeek(CurriculumScheduleCriteria criteria){
        return curriculumScheduleMapper.getAllCurriculumNameList(criteria);
    }
    public List<Integer> getRoomListIdList(CurriculumScheduleCriteria criteria){
        List<CurriculumSchedule> curriculumScheduleList=curriculumScheduleMapper.selectByCriteria(criteria);
        List<Integer> roomIdList=new ArrayList<>();
        for(int i=0;i<curriculumScheduleList.size();i++){
            if(curriculumScheduleList.get(i).getRoomId()!=null){
                roomIdList.add(curriculumScheduleList.get(i).getRoomId());
            }
        }
        return roomIdList;
    }
    public List<CurriculumSchedule> getCurriculumScheduleList(CurriculumScheduleCriteria criteria){
        List<CurriculumSchedule> curriculumScheduleList=curriculumScheduleMapper.selectByCriteria(criteria);
        return curriculumScheduleList;
    }

    public List<Integer> getClassIdListByStudentId(int id){
        List<Integer> classList=new ArrayList<>();
        ClassStudentCriteria classStudentCriteria = new ClassStudentCriteria();
        ClassStudentCriteria.Criteria criteria= classStudentCriteria.createCriteria();
        criteria.andStudentIdEqualTo(id);
        List<ClassStudent> classStudentList=classStudentMapper.selectByCriteria(classStudentCriteria);

        for(int i=0;i<classStudentList.size();i++){
            classList.add(i,classStudentList.get(i).getClassId());
        }
        return classList;
    }

    public  List<CurriculumSchedule>  selectSchedulesByTime(int year, Byte week, Byte wDay, Byte section){
        CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
        CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
        criteria.andTermYearidEqualTo(year);
        criteria.andWeeknumEqualTo(week);
        criteria.andWeekdaysEqualTo(wDay);
        criteria.andAmPmEqualTo(section);

        List<CurriculumSchedule> schedules = curriculumScheduleMapper.selectByCriteria(curriculumScheduleCriteria);
        return schedules;
    }

    public  List<CurriculumSchedule>  selectSchedulesByTime(Date startTime, Date endTime){

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);

        Integer year = cal.get(java.util.Calendar.YEAR);
        List<Integer> yearIds = yearService.getIdByYear(year);


        CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
        CurriculumScheduleCriteria.Criteria criteriaLab = curriculumScheduleCriteria.createCriteria();
        List<Byte> sections = getSectionByTime(startTime, endTime);
        if(sections.size() > 0)
        {
            criteriaLab.andAmPmIn(sections).andTermYearidIn(yearIds).
                andWeeknumEqualTo((byte) calendar.get(java.util.Calendar.WEEK_OF_YEAR)).
                andWeekdaysEqualTo((byte) calendar.get(java.util.Calendar.DAY_OF_WEEK));
        }

        curriculumScheduleCriteria.or().andMeetSTimeBetween(startTime, endTime);
        curriculumScheduleCriteria.or().andMeetETimeBetween(startTime, endTime);
        curriculumScheduleCriteria.or().andMeetETimeGreaterThan(endTime).andMeetSTimeLessThan(startTime);


        List<CurriculumSchedule> schedules = curriculumScheduleMapper.selectByCriteria(curriculumScheduleCriteria);
        return schedules;
    }

    private List<Byte> getSectionByTime(Date startTime, Date endTime){
        List<Byte> sections = new ArrayList<Byte>();
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(startTime);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endTime);

        int startHour = calStart.get(Calendar.HOUR_OF_DAY);
        int endHour =  calEnd.get(Calendar.HOUR_OF_DAY);
        if( 7 <= startHour &&  startHour  < 9){
            if(endHour > 7)
                sections.add((byte)1);
            if(  endHour > 9)
                sections.add((byte)2);
            if(endHour > 13)
                sections.add((byte)3);
            if(endHour > 17)
                sections.add((byte)2);
            if(endHour > 19)
                sections.add((byte)5);
        }
        else if( 9 <= startHour &&  startHour  < 11){
            if(  endHour > 9)
                sections.add((byte)2);
            if(endHour > 13)
                sections.add((byte)3);
            if(endHour > 17)
                sections.add((byte)2);
            if(endHour > 19)
                sections.add((byte)5);
        }
        else if( 13 <= startHour &&  startHour  < 15){
            if(endHour > 14)
                sections.add((byte)3);
            if(endHour > 17)
                sections.add((byte)2);
            if(endHour > 19)
                sections.add((byte)5);
        }
        else if( 15 <= startHour &&  startHour  < 17){
            if(endHour > 17)
                sections.add((byte)2);
            if(endHour > 19)
                sections.add((byte)5);
        }
        else if( 19 <= startHour &&  startHour  < 21){
            if(endHour > 19)
                sections.add((byte)5);
        }
        return sections;
    }

    //按时间查询已占用房间编号
    public  List<Integer> selectOccupiedRoomIds(int year, Byte week, Byte wDay, Byte section){
        List<CurriculumSchedule> schedules =selectSchedulesByTime(year, week, wDay, section);

        List<Integer> retIds = new ArrayList<>();
        for(int i=0;i<schedules.size();i++){
            retIds.add(i,schedules.get(i).getRoomId());
        }
        return retIds;
    }


    //按时间查询已占用房间编号
    public  List<Integer> selectOccupiedRoomIds(Date startTime, Date endTime){
        List<CurriculumSchedule> schedules =selectSchedulesByTime(startTime, endTime);

        List<Integer> retIds = new ArrayList<>();
        for(int i=0;i<schedules.size();i++){
            retIds.add(i,schedules.get(i).getRoomId());
        }
        return retIds;
    }

    //按时间查询课程
    public  List<Curriculum> selectCurriculums(int year, Byte week, Byte wDay, Byte section){
        List<CurriculumSchedule> schedules =selectSchedulesByTime(year, week, wDay, section);

        List<Curriculum> retIds = new ArrayList<>();
        for(int i=0;i<schedules.size();i++){
            retIds.add(i,schedules.get(i).getCurriculum());
        }
        return retIds;
    }

    public String getCurriculumScheduleBy(){
        return null;
    }
}
