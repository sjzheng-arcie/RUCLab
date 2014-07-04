package edu.ruc.labmgr.web.controller.lab;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * User: sjzheng
 * Date: 14-1-2
 * Time: 下午3:31
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/appointment/laboratory")

public class AppointmentController {
    @Autowired
    CurriculumScheduleService curriculumScheduleService;
    @Autowired
    ArrangementScheduleService arrangementScheduleService;
    @Autowired
    CurriculumService curriculumService;
    @Autowired
    ArrangementService arrangementService;
    @Autowired
    RoomService roomService;
    @Autowired
    TermYearService yearService;
    @Autowired
    UserService userService;
    @Autowired
    ClassifService classifService;
	@Autowired
	TermYearService termYearService;
    @RequestMapping(value = "/appointmentbaseinfo")
    public ModelAndView appointmentBaseinfo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Integer currYear =   calendar.get(Calendar.YEAR);
        Integer currWeek =   calendar.get(Calendar.WEEK_OF_YEAR);
        Integer currDay =   calendar.get(Calendar.DAY_OF_WEEK);
        if(currDay==1)
            currDay=7;
        else if(currDay>1 && currDay<=7)
            currDay=currDay-1;

        List<TermYear> years = yearService.getAllTermYearList();

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentbaseinfo");
        mav.addObject("currYear", currYear);
        mav.addObject("currWeek", currWeek);
        mav.addObject("currDay", currDay);
        mav.addObject("years", years);
        return mav;
    }
	@RequestMapping(value = "/multiappointmentbaseinfo")
	public ModelAndView multiAppointmentBaseinfo() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		Integer currYear =   calendar.get(Calendar.YEAR);
		Integer currWeek =   calendar.get(Calendar.WEEK_OF_YEAR);
		Integer currDay =   calendar.get(Calendar.DAY_OF_WEEK);
		if(currDay==1)
			currDay=7;
		else if(currDay>1 && currDay<=7)
			currDay=currDay-1;

		List<TermYear> termYearList = yearService.getAllTermYearList();

		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/multiappointmentbaseinfo");
		mav.addObject("currYear", currYear);
		mav.addObject("currWeek", currWeek);
		mav.addObject("currDay", currDay);
		mav.addObject("termYearList", termYearList);
		return mav;
	}

    @RequestMapping(value = "/roomstatus", method = RequestMethod.GET)
    ModelAndView roomStatus(@RequestParam(required = false,defaultValue = "") Date meetDate,
                            @RequestParam(required = false,defaultValue = "") String stime,
                            @RequestParam(required = false,defaultValue = "") String etime) {
        if(meetDate == null)
            meetDate = new Date();
        if(StringUtils.isNullOrEmpty(stime))
            stime = "07:00";
        if(StringUtils.isNullOrEmpty(etime))
            etime = "07:30";

        Calendar calStart = Calendar.getInstance();
        calStart.setTime(meetDate);
        int hour, minute;
        hour = Integer.parseInt(stime.split(":")[0]);
        minute = Integer.parseInt(stime.split(":")[1]);
        calStart.set(Calendar.HOUR, hour);
        calStart.set(Calendar.MINUTE, minute);

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(meetDate);
        hour =  Integer.parseInt(etime.split(":")[0]);
        minute = Integer.parseInt(etime.split(":")[1]);
        calEnd.set(Calendar.HOUR, hour);
        calEnd.set(Calendar.MINUTE, minute);


        List<CurriculumSchedule> schedules = curriculumScheduleService.selectSchedulesByTime(calStart.getTime(), calEnd.getTime());

        List<Integer> occupiedRoomIds = curriculumScheduleService.selectOccupiedRoomIds(calStart.getTime(), calEnd.getTime());

        List<Room> rooms = roomService.getAllRoomList();

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/roomstatus");
        mav.addObject("rooms", rooms);
        mav.addObject("occupiedRoomIds", occupiedRoomIds);
        mav.addObject("schedules", schedules);
        mav.addObject("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calStart.getTime()));
        mav.addObject("endTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
        return mav;
    }


	@RequestMapping(value = "/multiroomstatus", method = RequestMethod.GET)
	ModelAndView multiRoomStatus(
								 @RequestParam(required = false,defaultValue = "") int termYearId,
								 @RequestParam(required = false,defaultValue = "") byte weekDay,
								 @RequestParam(required = false,defaultValue = "") int beginWeek,
								 @RequestParam(required = false,defaultValue = "") int endWeek,
								 @RequestParam(required = false,defaultValue = "") String appointmentType,
							@RequestParam(required = false,defaultValue = "") String stime,
							@RequestParam(required = false,defaultValue = "") String etime) {

			Date meetDate =termYearService.getTermYearById(termYearId).getBegindate();
		//Date endDate =termYearService.getDateByWeekTermId(termYearId,endWeek,weekDay);
		if(StringUtils.isNullOrEmpty(stime))
			stime = "07:00";
		if(StringUtils.isNullOrEmpty(etime))
			etime = "07:30";

		Calendar calStart = Calendar.getInstance();
		calStart.setTime(meetDate);
		int hour, minute;
		hour = Integer.parseInt(stime.split(":")[0]);
		minute = Integer.parseInt(stime.split(":")[1]);
		calStart.set(Calendar.HOUR, hour);
		calStart.set(Calendar.MINUTE, minute);

		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(meetDate);
		hour =  Integer.parseInt(etime.split(":")[0]);
		minute = Integer.parseInt(etime.split(":")[1]);
		calEnd.set(Calendar.HOUR, hour);
		calEnd.set(Calendar.MINUTE, minute);


		List<CurriculumSchedule> schedules = curriculumScheduleService.selectSchedulesByTimeMulti(calStart.getTime(), calEnd.getTime(),
				termYearId,beginWeek,endWeek,weekDay,appointmentType);

		List<Integer> occupiedRoomIds = curriculumScheduleService.selectMultiOccupiedRoomIds(calStart.getTime(), calEnd.getTime(),
				termYearId,beginWeek,endWeek,weekDay,appointmentType);

		RoomCriteria roomCriteria= new RoomCriteria();

		if(appointmentType.equals("multiLaboratory")){
			roomCriteria.createCriteria().andTypeEqualTo(true);
		}else if(appointmentType.equals("multiMeeting")){
			roomCriteria.createCriteria().andTypeEqualTo(false);
		}
		List<Room> rooms = roomService.getAllRoomListByCriteria(roomCriteria);

		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/multiroomstatus");
		mav.addObject("rooms", rooms);
		mav.addObject("occupiedRoomIds", occupiedRoomIds);
		mav.addObject("schedules", schedules);
		mav.addObject("beginWeek",beginWeek);
		mav.addObject("endWeek",endWeek);
		mav.addObject("weekDay",weekDay);
		mav.addObject("termYearId",termYearId);
		mav.addObject("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calStart.getTime()));
		mav.addObject("endTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
		mav.addObject("appointmentType",appointmentType);
		mav.addObject("weekDay",weekDay);
		return mav;
	}

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    ModelAndView toAdd(@RequestParam(required = false,defaultValue = "") Date startTime,
                       @RequestParam(required = false,defaultValue = "") Date endTime,
                       @RequestParam(required = true) Integer roomId) {

        Room room = roomService.getRoomById(roomId);

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/add");
        mav.addObject("room", room);
        mav.addObject("startTime", startTime );
        mav.addObject("endTime",  endTime );

        return mav;
    }
	@RequestMapping(value = "/toMultiAdd", method = RequestMethod.GET)
	ModelAndView toMultiAdd(@RequestParam(required = false,defaultValue = "") Date startTime,
					   @RequestParam(required = false,defaultValue = "") Date endTime,
					   @RequestParam(required = false,defaultValue = "") byte weekDay,
					   @RequestParam(required = false,defaultValue = "") int beginWeek,
					   @RequestParam(required = false,defaultValue = "") int endWeek,
					   @RequestParam(required = false,defaultValue = "") int termYearId,
					   @RequestParam(required = false,defaultValue = "") String appointmentType,
					   @RequestParam(required = true) Integer roomId) {

		Room room = roomService.getRoomById(roomId);

		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/multiadd");
		mav.addObject("room", room);
		mav.addObject("startTime", startTime );
		mav.addObject("endTime",  endTime );
		mav.addObject("weekDay", weekDay);
		mav.addObject("beginWeek", beginWeek );
		mav.addObject("endWeek",  endWeek );
		mav.addObject("termYearId",  termYearId);
		mav.addObject("appointmentType",appointmentType);

		return mav;
	}

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result add(Arrangement arrangement,
               @RequestParam(required = true) String startTime,
               @RequestParam(required = true) String endTime,
			   @RequestParam(required = true) String phoneNum,
               @RequestParam(required = true) Integer roomId,
               @RequestParam(required = true) String type) {
        Result result = null;
        try {
            arrangement.setUserId(userService.getCurrentUserId());
            arrangement.setState((byte) Types.ApplyState.WAITING.getValue());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            arrangement.setMeetSTime(sdf.parse(startTime));
            arrangement.setMeetETime(sdf.parse(endTime));
            arrangement.setType(type);
			arrangement.setPhoneNum(phoneNum);
            arrangementService.insert(arrangement);

            CurriculumSchedule schedule = new CurriculumSchedule();
            schedule.setTeacherid(userService.getCurrentUserId());
            schedule.setRoomId(roomId);
            schedule.setMeetStime(sdf.parse(startTime));
            schedule.setMeetEtime(sdf.parse(endTime));
            curriculumScheduleService.add(schedule);

            ArrangementSchedule arrangementSchedule = new ArrangementSchedule();
            arrangementSchedule.setArrangementId(arrangement.getId());
            arrangementSchedule.setCurriculumsheduleId(schedule.getId());
            arrangementScheduleService.insert(arrangementSchedule);

            result = new Result(true, "预约成功!");
        } catch (Exception e) {
            result = new Result(false, "预约失败!\r\n" + e.toString());
        }
        return result;
    }
	//添加多次预订的记录
	@RequestMapping(value = "/multiadd", method = RequestMethod.POST, produces = "application/json")
	public
	@ResponseBody
	Result multiAdd(Arrangement arrangement,
			   @RequestParam(required = true) String startTime,
			   @RequestParam(required = true) String endTime,
			   @RequestParam(required = true) int beginWeek,
			   @RequestParam(required = true) int endWeek,
			   @RequestParam(required = true) byte weekDay,
			   @RequestParam(required = false) String phoneNum,
			   @RequestParam(required = true) Integer roomId,
			   @RequestParam(required = true) Integer termYearId,
			   @RequestParam(required = true) String type) {
		Result result = null;

		try {
			arrangement.setUserId(userService.getCurrentUserId());
			arrangement.setState((byte) Types.ApplyState.WAITING.getValue());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date beginDate=sdf.parse(startTime);
			Date endDate=sdf.parse(endTime);
			Date startTimeDate=sdf.parse(startTime);
			Date endTimeDate=sdf.parse(endTime);

			arrangement.setMeetSTime(sdf.parse(startTime));
			arrangement.setMeetETime(sdf.parse(endTime));
			arrangement.setBeginWeek(beginWeek);
			arrangement.setEndWeek(endWeek);
			arrangement.setWeekDay(weekDay);
			arrangement.setTermId(termYearId);
			//arrangement.setTermId(termId);
			if(type.equals("multiLaboratory")){
				arrangement.setType("多次实验室预约");
			}else{
				arrangement.setType("多次会议室预约");
			}

			arrangement.setPhoneNum(phoneNum);
			arrangementService.insert(arrangement);

			for(int i=beginWeek;i<=endWeek;i++){

				//startTime.setTime(startTime.getTime()+86400000*(7*(i-1)+weekDay-1));
				CurriculumSchedule schedule = new CurriculumSchedule();
				schedule.setTeacherid(userService.getCurrentUserId());
				schedule.setRoomId(roomId);
				beginDate.setTime(startTimeDate.getTime()+(long)86400000*(7*(i-1)+weekDay-1));
				endDate.setTime(endTimeDate.getTime()+(long)86400000*(7*(i-1)+weekDay-1));
				schedule.setMeetStime(beginDate);
				schedule.setMeetEtime(endDate);
				//schedule.setSectionBegin(beginWeek);
				//schedule.setSectionEnd(endWeek);
				schedule.setWeeknum((byte) i);
				schedule.setWeekdays(weekDay);
				curriculumScheduleService.add(schedule);

				ArrangementSchedule arrangementSchedule = new ArrangementSchedule();
				arrangementSchedule.setArrangementId(arrangement.getId());
				arrangementSchedule.setCurriculumsheduleId(schedule.getId());
				arrangementScheduleService.insert(arrangementSchedule);

			}

			result = new Result(true, "预约成功!");
		} catch (Exception e) {
			result = new Result(false, "预约失败!\r\n" + e.toString());
		}
		return result;
	}

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList( @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                  @RequestParam(value = "formType", required = false, defaultValue = "") String formType) {
        Subject subject = SecurityUtils.getSubject();
        PageInfo<Arrangement> pageInfo = null;
        if (subject.hasRole(Types.Role.ADMIN.getName()) || subject.hasRole(Types.Role.LAB_ADMIN.getName()) ) {
            if(formType.equalsIgnoreCase("history")){
                //管理员历史
                pageInfo = arrangementService.pageAllHistoryArrangMeetings(page);
            }
            else{
                //管理员查看所有
                pageInfo = arrangementService.pageAllCurrArrangMeetings(page);
            }
        }
        else{
            if(formType.equalsIgnoreCase("history")){
                //用户历史
                pageInfo = arrangementService.pageHistoryArrangMeetingsByUser(page, userService.getCurrentUserId());
            }
            else{
                //用户申请中
                pageInfo = arrangementService.pageCurrArrangMeetingsByUser(page, userService.getCurrentUserId());
            }
        }

        for(Arrangement arrangement : pageInfo.getData()){
//            Calendar calendar = Calendar.getInstance();
//            TermYear termYear = yearService.getTermYearById(arrangement.getTermYear());
//            calendar.setWeekDate(termYear.getYear(), arrangement.getWeek(), arrangement.getWday());
//            Date scheduleDate = calendar.getTime();
//
//            arrangement.setScheduleDate(scheduleDate);

            Classif stateClassif = classifService.getClassifItem(arrangement.getState());
            arrangement.setStateClassif(stateClassif);

        }
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/list");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("formType", formType);
        return mav;
    }
	@RequestMapping(value = "/multilist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView multiPageList( @RequestParam(value = "page", required = false, defaultValue = "1") int page,
								  @RequestParam(value = "formType", required = false, defaultValue = "") String formType) {
		Subject subject = SecurityUtils.getSubject();
		PageInfo<Arrangement> pageInfo = null;
		if (subject.hasRole(Types.Role.ADMIN.getName()) || subject.hasRole(Types.Role.LAB_ADMIN.getName()) ) {
			if(formType.equalsIgnoreCase("history")){
				//管理员历史
				pageInfo = arrangementService.multiAllHistoryArrangMeetings(page);
			}
			else{
				//管理员查看所有
				pageInfo = arrangementService.multiAllCurrArrangMeetings(page);
			}
		}
		else{
			if(formType.equalsIgnoreCase("history")){
				//用户历史
				pageInfo = arrangementService.multiHistoryArrangMeetingsByUser(page, userService.getCurrentUserId());
			}
			else{
				//用户申请中
				pageInfo = arrangementService.multiCurrArrangMeetingsByUser(page, userService.getCurrentUserId());
			}
		}


		for(Arrangement arrangement : pageInfo.getData()){
//            Calendar calendar = Calendar.getInstance();
//            TermYear termYear = yearService.getTermYearById(arrangement.getTermYear());
//            calendar.setWeekDate(termYear.getYear(), arrangement.getWeek(), arrangement.getWday());
//            Date scheduleDate = calendar.getTime();
//
//            arrangement.setScheduleDate(scheduleDate);

			Classif stateClassif = classifService.getClassifItem(arrangement.getState());
			arrangement.setStateClassif(stateClassif);
			arrangement.setTermName(termYearService.getTermYearByTime(arrangement.getMeetSTime()).getName());

		}
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/multilist");
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("formType", formType);
		return mav;
	}

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Arrangement arrangement = arrangementService.selectByPrimaryKey(id);

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/detail");
        mav.addObject("arrangement", arrangement);
        return mav;
    }

	@RequestMapping(value = "/toMultiUpdate", method = RequestMethod.GET)
	public ModelAndView toMultiUpdate(@RequestParam("id") int id) {
		Arrangement arrangement = arrangementService.selectByPrimaryKey(id);
		CurriculumSchedule curriculumSchedule= arrangementScheduleService.getSecheduleInfoByArrangementId(arrangement.getId());
		arrangement.setBeginWeek(curriculumSchedule.getSectionBegin());
		arrangement.setEndWeek(curriculumSchedule.getSectionEnd());
		arrangement.setWeekDay(curriculumSchedule.getWeekdays());
		ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/multidetail");
		mav.addObject("arrangement", arrangement);
		return mav;
	}

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            int scheduleId = arrangementScheduleService.getSecheduleIdByArrangementId(id);
            arrangementScheduleService.delete(id, scheduleId);
            curriculumScheduleService.deleteById(scheduleId);
            arrangementService.delete(id);
        }
        return "redirect:/laboratory/jsp/appointment/laboratory/list";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approve(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            Arrangement arrangement = arrangementService.selectByPrimaryKey(id);
            arrangement.setState((byte)Types.ApplyState.PASS.getValue());
            arrangement.setApprovalId(userService.getCurrentUserId());
            arrangementService.update(arrangement);
        }
        return "redirect:/laboratory/jsp/appointment/laboratory/list";
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public String reject(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            Arrangement arrangement = arrangementService.selectByPrimaryKey(id);
            arrangement.setState((byte)Types.ApplyState.REJECT.getValue());
            arrangement.setApprovalId(userService.getCurrentUserId());
            arrangementService.update(arrangement);

           // int scheduleId = arrangementScheduleService.getSecheduleIdByArrangementId(id);


			List<Integer> idList= arrangementScheduleService.getSecheduleIdListByArrangementId(id);
			arrangementScheduleService.delete(id);
			if(idList!=null&&idList.size()>0){
				CurriculumScheduleCriteria curriculumScheduleCriteria= new CurriculumScheduleCriteria();
				curriculumScheduleCriteria.createCriteria().andIdIn(idList);
				curriculumScheduleService.deleteByCriteria(curriculumScheduleCriteria);
			}




           // curriculumScheduleService.deleteById(scheduleId);
        }
        return "redirect:/laboratory/jsp/appointment/laboratory/list";
    }

//    @RequestMapping(value = "/appointmentbaseinfo")
//    public ModelAndView appointmentBaseInfo() {
//        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentbaseinfo");
//        return mav;
//    }

    @RequestMapping(value ="/laboratoryapply",method = RequestMethod.GET)
    public ModelAndView laboratoryapply(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/laboratoryapply");
        return mav;
    }
    @RequestMapping(value ="/appointmentinfosubmit",method = RequestMethod.GET)
    public ModelAndView appointmentinfosubmit(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentinfosubmit");
        return mav;
    }

    @RequestMapping(value ="/mydatelist",method = RequestMethod.GET)
    public ModelAndView mydatelist(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/mydatelist");
        return mav;
    }

    @RequestMapping(value ="/appointmentdate",method = RequestMethod.GET)
    public ModelAndView appointdate(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentdate");
        return mav;
    }
    @RequestMapping(value ="/appointmentdatecontent",method = RequestMethod.GET)
    public ModelAndView appointmentdatecontent(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentdatecontent");
        return mav;
    }

}
