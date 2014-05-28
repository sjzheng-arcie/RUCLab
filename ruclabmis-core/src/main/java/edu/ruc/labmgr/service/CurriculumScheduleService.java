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

	public void deleteByCriteria(CurriculumScheduleCriteria curriculumScheduleCriteria){
		curriculumScheduleMapper.deleteByCriteria(curriculumScheduleCriteria);
	}

    public void add(CurriculumSchedule curriculumSchedule){
        curriculumScheduleMapper.insert(curriculumSchedule);
    }

    public CurriculumSchedule getCurriculumScheduleById(int id){
        return  curriculumScheduleMapper.selectByPrimaryKey(id);
    }

    public void update(CurriculumSchedule curriculumSchedule){
        curriculumScheduleMapper.updateByPrimaryKeySelective(curriculumSchedule);
    }

    public boolean ifCurriculumScheduleExistd (CurriculumSchedule curriculumSchedule){
        CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
        CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
        CurriculumScheduleCriteria.Criteria criteria1 = curriculumScheduleCriteria.createCriteria();
        CurriculumScheduleCriteria.Criteria criteria2 = curriculumScheduleCriteria.createCriteria();

        //  criteria.andAmPmEqualTo(curriculumSchedule.getAmPm());
        criteria.andSectionBeginGreaterThan(curriculumSchedule.getSectionBegin());
        criteria.andSectionBeginLessThanOrEqualTo(curriculumSchedule.getSectionEnd());
        criteria.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
        criteria.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
        criteria.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
        criteria.andClassIdEqualTo(curriculumSchedule.getClassId());

        // criteria1.andAmPmEqualTo(curriculumSchedule.getAmPm());
        criteria1.andSectionEndGreaterThan(curriculumSchedule.getSectionBegin());
        criteria1.andSectionEndLessThanOrEqualTo(curriculumSchedule.getSectionEnd());
        criteria1.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
        criteria1.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
        criteria1.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
        criteria1.andTeacheridEqualTo(curriculumSchedule.getTeacherid());

        criteria2.andSectionBeginLessThanOrEqualTo(curriculumSchedule.getSectionBegin());
        criteria2.andSectionEndGreaterThanOrEqualTo(curriculumSchedule.getSectionEnd());
        criteria2.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
        criteria2.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
        criteria2.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
        criteria2.andTeacheridEqualTo(curriculumSchedule.getTeacherid());

        curriculumScheduleCriteria.or(criteria);
        curriculumScheduleCriteria.or(criteria1);
        curriculumScheduleCriteria.or(criteria2);

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
        if(curriculumScheduleList!=null){
            for(int i=0;i<curriculumScheduleList.size();i++){
                if(curriculumScheduleList.get(i).getRoomId()!=null){
                    roomIdList.add(curriculumScheduleList.get(i).getRoomId());
                }
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

    public  List<CurriculumSchedule>  selectSchedulesByTime(int year, Byte week, Byte wDay, int sectionBegin,int sectionEnd){
        CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
        CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
        criteria.andTermYearidEqualTo(year);
        criteria.andWeeknumEqualTo(week);
        criteria.andWeekdaysEqualTo(wDay);
        //criteria.andAmPmEqualTo(section);
        criteria.andSectionBeginGreaterThanOrEqualTo(sectionBegin);
        criteria.andSectionBeginLessThanOrEqualTo(sectionEnd);

        List<CurriculumSchedule> schedules = curriculumScheduleMapper.selectByCriteria(curriculumScheduleCriteria);
        return schedules;
    }

    public  List<CurriculumSchedule>  selectSchedulesByTime(Date startTime, Date endTime){

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);

        int week = cal.get(Calendar.WEEK_OF_YEAR);
        Integer year = cal.get(Calendar.YEAR);

        TermYear termYear = yearService.getTermYearByTime(endTime);

        CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
        CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
        List<Integer> sections = getSectionByTime(startTime, endTime);
        if(sections.size() > 0)
        {
            Calendar calStartDate = Calendar.getInstance();
            calStartDate.setTime(termYear.getBegindate());
            int startWeek = calStartDate.get(Calendar.WEEK_OF_YEAR);

            byte deltWeek = (byte)(week-startWeek);

            int startWeekDay = cal.get(cal.DAY_OF_WEEK);
            if(startWeekDay==1)
                startWeekDay=7;
            else if(startWeekDay>1 && startWeekDay<=7)
                startWeekDay=startWeekDay-1;


            curriculumScheduleCriteria.or().andTermYearidEqualTo(termYear.getId()).
                    andWeeknumEqualTo(deltWeek).andWeekdaysEqualTo((byte) startWeekDay).andSectionBeginBetween(sections.get(0), sections.get(1));
            curriculumScheduleCriteria.or().andTermYearidEqualTo(termYear.getId()).
                    andWeeknumEqualTo(deltWeek).andWeekdaysEqualTo((byte) startWeekDay).andSectionEndBetween(sections.get(0), sections.get(1));
            curriculumScheduleCriteria.or().andTermYearidEqualTo(termYear.getId()).
                    andWeeknumEqualTo(deltWeek).andWeekdaysEqualTo((byte) startWeekDay).andSectionBeginLessThanOrEqualTo(sections.get(0)).andSectionEndGreaterThanOrEqualTo(sections.get(1));
        }

        curriculumScheduleCriteria.or().andMeetStimeBetween(startTime, endTime);
        curriculumScheduleCriteria.or().andMeetEtimeBetween(startTime, endTime);
        curriculumScheduleCriteria.or().andMeetEtimeGreaterThanOrEqualTo(endTime).andMeetStimeLessThanOrEqualTo(startTime);


        List<CurriculumSchedule> schedules = curriculumScheduleMapper.selectByCriteria(curriculumScheduleCriteria);
        return schedules;
    }

    private List<Integer> getSectionByTime(Date startTime, Date endTime){
        List<Integer> sections = new ArrayList<Integer>();
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(startTime);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endTime);

        int startSection=0;
        int endSection=0;
        int startHour = calStart.get(Calendar.HOUR_OF_DAY);
        int endHour =  calEnd.get(Calendar.HOUR_OF_DAY);
        int startMinute = calStart.get(Calendar.MINUTE);
        int endMinute =  calEnd.get(Calendar.MINUTE);
        if( startHour < 8)
            startSection = 1;
        if( 8 == startHour && startMinute < 45)
            startSection = 1;
        else if( 8 == startHour && startMinute >= 45)
            startSection = 2;
        else if( 9 == startHour && startMinute < 30)
            startSection = 2;
        else if( 9 == startHour && startMinute >= 30)
            startSection = 3;
        else if( 10 == startHour&& startMinute < 45)
            startSection = 3;
        else if( 10 == startHour&& startMinute >= 45)
            startSection = 4;
        else if( 11 == startHour&& startMinute < 30)
            startSection = 4;
        else if( 11 == startHour&& startMinute >= 30)
            startSection = 5;
        else if( 12 == startHour&& startMinute < 45)
            startSection = 5;
        else if( 12 == startHour&& startMinute >= 45)
            startSection = 6;
        else if( 13 == startHour&& startMinute < 30)
            startSection = 6;
        else if( 13 == startHour&& startMinute >= 30)
            startSection = 7;
        else if( 14 == startHour&& startMinute < 45)
            startSection = 7;
        else if( 14 == startHour&& startMinute >= 45)
            startSection = 8;
        else if( 15 == startHour&& startMinute < 30)
            startSection = 8;
        else if( 15 == startHour&& startMinute >= 30)
            startSection = 9;
        else if( 16 == startHour&& startMinute < 45)
            startSection = 9;
        else if( 16 == startHour&& startMinute >= 45)
            startSection = 10;
        else if( 17 == startHour&& startMinute < 30)
            startSection = 10;
        else if( 17 == startHour&& startMinute >= 30)
            startSection = 11;
        else if( 18 == startHour&& startMinute < 45)
            startSection = 11;
        else if( 18 == startHour&& startMinute >= 45)
            startSection = 12;
        else if( 19 == startHour&& startMinute < 30)
            startSection = 12;
        else if( 19 == startHour&& startMinute >= 30)
            startSection = 13;
        else if( 20 == startHour&& startMinute < 15)
            startSection = 13;
        else if( 20 == startHour&& startMinute >= 15)
            startSection = 14;
        else if( 21 == startHour)
            startSection = 14;
        else if( startHour > 21)
            startSection = 15;

        if( endHour < 8)
            endSection = 0;
        if( 8 == endHour && endMinute < 45)
            endSection = 1;
        else if( 8 == endHour && endMinute >= 45)
            endSection = 2;
        else if( 9 == endHour && endMinute < 30)
            endSection = 2;
        else if( 9 == endHour && endMinute >= 30)
            endSection = 3;
        else if( 10 == endHour&& endMinute < 45)
            endSection = 3;
        else if( 10 == endHour&& endMinute >= 45)
            endSection = 4;
        else if( 11 == endHour&& endMinute < 30)
            endSection = 4;
        else if( 11 == endHour&& endMinute >= 30)
            endSection = 5;
        else if( 12 == endHour&& endMinute < 45)
            endSection = 5;
        else if( 12 == endHour&& endMinute >= 45)
            endSection = 6;
        else if( 13 == endHour&& endMinute < 30)
            endSection = 6;
        else if( 13 == endHour&& endMinute >= 30)
            endSection = 7;
        else if( 14 == endHour&& endMinute < 45)
            endSection = 7;
        else if( 14 == endHour&& endMinute >= 45)
            endSection = 8;
        else if( 15 == endHour&& endMinute < 30)
            endSection = 8;
        else if( 15 == endHour&& endMinute >= 30)
            endSection = 9;
        else if( 16 == endHour&& endMinute < 45)
            endSection = 9;
        else if( 16 == endHour&& endMinute >= 45)
            endSection = 10;
        else if( 17 == endHour&& endMinute < 30)
            endSection = 10;
        else if( 17 == endHour&& endMinute >= 30)
            endSection = 11;
        else if( 18 == endHour&& endMinute < 45)
            endSection = 11;
        else if( 18 == endHour&& endMinute >= 45)
            endSection = 12;
        else if( 19 == endHour&& endMinute < 30)
            endSection = 12;
        else if( 19 == endHour&& endMinute >= 30)
            endSection = 13;
        else if( 20 == endHour&& endMinute < 15)
            endSection = 13;
        else if( 20 == endHour&& endMinute >= 15)
            endSection = 14;
        else if( 21 < endHour)
            endSection = 15;

        sections.add(0, startSection);
        sections.add(1, endSection);
        return sections;
    }

    //按时间查询已占用房间编号
    public  List<Integer> selectOccupiedRoomIds(int year, Byte week, Byte wDay, int sectionBegin,int sectionEnd){
        List<CurriculumSchedule> schedules =selectSchedulesByTime(year, week, wDay, sectionBegin,sectionEnd);

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
    public  List<Curriculum> selectCurriculums(int year, Byte week, Byte wDay, int sectionBegin,int sectionEnd){
        List<CurriculumSchedule> schedules =selectSchedulesByTime(year, week, wDay,sectionBegin,sectionEnd);

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
