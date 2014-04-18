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
@RequestMapping(value = "/laboratory/jsp/appointment/meetingroom")

public class AppointmentMController {
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

    @RequestMapping(value = "/appointmentbaseinfo")
    public ModelAndView appointmentBaseinfo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Integer currYear =   calendar.get(Calendar.YEAR);
        Integer currWeek =   calendar.get(Calendar.WEEK_OF_YEAR);
        Integer currDay =   calendar.get(Calendar.DAY_OF_WEEK);

        List<TermYear> years = yearService.getAllTermYearList();

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/appointmentbaseinfo");
        mav.addObject("currYear", currYear);
        mav.addObject("currWeek", currWeek);
        mav.addObject("currDay", currDay);
        mav.addObject("years", years);
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

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/roomstatus");
        mav.addObject("rooms", rooms);
        mav.addObject("occupiedRoomIds", occupiedRoomIds);
        mav.addObject("schedules", schedules);
        mav.addObject("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calStart.getTime()));
        mav.addObject("endTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
        return mav;
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    ModelAndView toAdd(@RequestParam(required = false,defaultValue = "") Date startTime,
                       @RequestParam(required = false,defaultValue = "") Date endTime,
                       @RequestParam(required = true) Integer roomId) {

        Room room = roomService.getRoomById(roomId);

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/add");
        mav.addObject("room", room);
        mav.addObject("startTime", startTime );
        mav.addObject("endTime",  endTime );

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result add(Arrangement arrangement,
               @RequestParam(required = true) String startTime,
               @RequestParam(required = true) String endTime,
               @RequestParam(required = true) Integer roomId) {
        Result result = null;
        try {
            arrangement.setUserId(userService.getCurrentUserId());
            arrangement.setState((byte) Types.ApplyState.WAITING.getValue());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            arrangement.setMeetSTime(sdf.parse(startTime));
            arrangement.setMeetETime(sdf.parse(endTime));
            arrangementService.insert(arrangement);

            CurriculumSchedule schedule = new CurriculumSchedule();
            schedule.setTeacherid(userService.getCurrentUserId());
            schedule.setRoomId(roomId);
            schedule.setMeetSTime(sdf.parse(startTime));
            schedule.setMeetETime(sdf.parse(endTime));
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
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/list");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("formType", formType);
        return mav;
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Arrangement arrangement = arrangementService.selectByPrimaryKey(id);

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/detail");
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
        return "redirect:/laboratory/jsp/appointment/meetingroom/list";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approve(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            Arrangement arrangement = arrangementService.selectByPrimaryKey(id);
            arrangement.setState((byte)Types.ApplyState.PASS.getValue());
            arrangement.setApprovalId(userService.getCurrentUserId());
            arrangementService.update(arrangement);
        }
        return "redirect:/laboratory/jsp/appointment/meetingroom/list";
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public String reject(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            Arrangement arrangement = arrangementService.selectByPrimaryKey(id);
            arrangement.setState((byte)Types.ApplyState.REJECT.getValue());
            arrangement.setApprovalId(userService.getCurrentUserId());
            arrangementService.update(arrangement);

            int scheduleId = arrangementScheduleService.getSecheduleIdByArrangementId(id);
            arrangementScheduleService.delete(id, scheduleId);
            curriculumScheduleService.deleteById(scheduleId);
        }
        return "redirect:/laboratory/jsp/appointment/meetingroom/list";
    }

//    @RequestMapping(value = "/appointmentbaseinfo")
//    public ModelAndView appointmentBaseInfo() {
//        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/appointmentbaseinfo");
//        return mav;
//    }

    @RequestMapping(value ="/meetingroomapply",method = RequestMethod.GET)
    public ModelAndView meetingroomapply(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/meetingroomapply");
        return mav;
    }
    @RequestMapping(value ="/appointmentinfosubmit",method = RequestMethod.GET)
    public ModelAndView appointmentinfosubmit(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/appointmentinfosubmit");
        return mav;
    }

    @RequestMapping(value ="/mydatelist",method = RequestMethod.GET)
    public ModelAndView mydatelist(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/mydatelist");
        return mav;
    }

    @RequestMapping(value ="/appointmentdate",method = RequestMethod.GET)
    public ModelAndView appointdate(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/appointmentdate");
        return mav;
    }
    @RequestMapping(value ="/appointmentdatecontent",method = RequestMethod.GET)
    public ModelAndView appointmentdatecontent(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/meetingroom/appointmentdatecontent");
        return mav;
    }

}
