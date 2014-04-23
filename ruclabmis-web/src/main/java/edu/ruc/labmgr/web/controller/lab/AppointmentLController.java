package edu.ruc.labmgr.web.controller.lab;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import edu.ruc.labmgr.web.controller.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
@RequestMapping(value = "/laboratory/jsp/appointment")

public class AppointmentLController {
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

    @RequestMapping(value = "/laboratory/appointmentbaseinfo")
    public ModelAndView appointmentBaseinfo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Integer currYear =   calendar.get(Calendar.YEAR);
        Integer currWeek =   calendar.get(Calendar.WEEK_OF_YEAR);
        Integer currDay =   calendar.get(Calendar.DAY_OF_WEEK);

        List<TermYear> years = yearService.getAllTermYearList();

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentbaseinfo");
        mav.addObject("currYear", currYear);
        mav.addObject("currWeek", currWeek);
        mav.addObject("currDay", currDay);
        mav.addObject("years", years);
        return mav;
    }

    @RequestMapping(value = "/laboratory/roomstatus", method = RequestMethod.GET)
    ModelAndView roomStatus(@RequestParam(required = true,defaultValue = "") String year,
                            @RequestParam(required = false,defaultValue = "") String week,
                            @RequestParam(required = false,defaultValue = "") String wDay,
                            @RequestParam(required = false,defaultValue = "") String section) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
		Integer inYear = null;
		if(year.isEmpty())
			inYear = calendar.getTime().getYear();
		else
            inYear = Integer.parseInt(year);

        Byte inWeek;
        if(StringUtils.isNullOrEmpty(week)){
            byte bWeek = (byte)calendar.get(Calendar.WEEK_OF_YEAR);
            inWeek = bWeek;
        }
        else{
            inWeek = Byte.parseByte(week);
        }

        Byte inDay;
        if(StringUtils.isNullOrEmpty(wDay)){
            byte bDay = (byte)calendar.get(Calendar.DAY_OF_WEEK);
            inDay = bDay;
        }
        else{
            inDay = Byte.parseByte(wDay);
        }

        Byte inSection;
        if(StringUtils.isNullOrEmpty(section)){
            inSection = (byte)1;
        }
        else{
            inSection = Byte.parseByte(section);
        }

        List<CurriculumSchedule> schedules = curriculumScheduleService.selectSchedulesByTime(inYear, inWeek, inDay, inSection);

        List<Integer> occupiedRoomIds = curriculumScheduleService.selectOccupiedRoomIds(inYear, inWeek, inDay, inSection);

        List<Room> rooms = roomService.getAllRoomList();

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/roomstatus");
        mav.addObject("rooms", rooms);
        mav.addObject("occupiedRoomIds", occupiedRoomIds);
        mav.addObject("schedules", schedules);
        mav.addObject("year", inYear);
        mav.addObject("week", inWeek);
        mav.addObject("wDay", inDay);
        mav.addObject("section", inSection);
        return mav;
    }

    @RequestMapping(value = "/laboratory/toAdd", method = RequestMethod.GET)
    ModelAndView toAdd(@RequestParam(required = true) Integer year,
                       @RequestParam(required = true) Integer week,
                       @RequestParam(required = true) Integer wDay,
                       @RequestParam(required = true) Integer section,
                       @RequestParam(required = true) Integer roomId) {
        Calendar calendar = Calendar.getInstance();
        TermYear termYear = yearService.getTermYearById(year);
        calendar.setWeekDate(termYear.getYear(), week, wDay);
        Date scheduleDate = calendar.getTime();

        Room room = roomService.getRoomById(roomId);

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/add");
        mav.addObject("scheduleDate", scheduleDate);
        mav.addObject("room", room);
        mav.addObject("year", year);
        mav.addObject("week", week);
        mav.addObject("wDay", wDay);
        mav.addObject("section", section);

        return mav;
    }

    @RequestMapping(value = "/laboratory/add", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result add(Arrangement arrangement,
               @RequestParam(required = true) Integer roomId) {
        Result result = null;
        try {
            arrangement.setUserId(userService.getCurrentUserId());
            arrangement.setState((byte) Types.ApplyState.WAITING.getValue());
            arrangementService.insert(arrangement);

            CurriculumSchedule schedule = new CurriculumSchedule();
            schedule.setTeacherid(userService.getCurrentUserId());
            schedule.setRoomId(roomId);
            schedule.setAmPm(arrangement.getSection().byteValue());
            schedule.setTermYearid(arrangement.getTermYear());
            schedule.setWeeknum(arrangement.getWeek().byteValue());
            schedule.setWeekdays(arrangement.getWday().byteValue());
            curriculumScheduleService.add(schedule);

            ArrangementSchedule arrangementSchedule = new ArrangementSchedule();
            arrangementSchedule.setArrangementId(arrangement.getId());
            arrangementSchedule.setCurriculumsheduleId(schedule.getId());
            arrangementScheduleService.insert(arrangementSchedule);

            result = new Result(true, "预约成功!");
        } catch (Exception e) {
            result = new Result(false, "预约失败!");
        }
        return result;
    }

    @RequestMapping(value = "/laboratory/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pageList( @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                  @RequestParam(value = "formType", required = false, defaultValue = "") String formType) {
        Subject subject = SecurityUtils.getSubject();
        PageInfo<Arrangement> pageInfo = null;
        if (subject.hasRole(Types.Role.ADMIN.getName()) || subject.hasRole(Types.Role.LAB_ADMIN.getName()) ) {
            if(formType.equalsIgnoreCase("history")){
                //管理员历史
                pageInfo = arrangementService.pageAllHistoryArrangements(page);
            }
            else{
                //管理员查看所有
                pageInfo = arrangementService.pageAllCurrArrangements(page);
            }
        }
        else{
            if(formType.equalsIgnoreCase("history")){
                //用户历史
                pageInfo = arrangementService.pageHistoryArrangementsByUser(page, userService.getCurrentUserId());
            }
            else{
                //用户申请中
                pageInfo = arrangementService.pageCurrArrangementsByUser(page, userService.getCurrentUserId());
            }
        }

        for(Arrangement arrangement : pageInfo.getData()){
            Calendar calendar = Calendar.getInstance();
            TermYear termYear = yearService.getTermYearById(arrangement.getTermYear());
            calendar.setWeekDate(termYear.getYear(), arrangement.getWeek(), arrangement.getWday());
            Date scheduleDate = calendar.getTime();

            arrangement.setScheduleDate(scheduleDate);

            Classif stateClassif = classifService.getClassifItem(arrangement.getState());
            arrangement.setStateClassif(stateClassif);

        }
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/list");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("formType", formType);
        return mav;
    }

    @RequestMapping(value = "/laboratory/toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(@RequestParam("id") int id) {
        Arrangement arrangement = arrangementService.selectByPrimaryKey(id);

        Calendar calendar = Calendar.getInstance();
        TermYear termYear = yearService.getTermYearById(arrangement.getTermYear());
        calendar.setWeekDate(termYear.getYear(), arrangement.getWeek(), arrangement.getWday());
        Date scheduleDate = calendar.getTime();

        arrangement.setScheduleDate(scheduleDate);


        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/detail");
        mav.addObject("arrangement", arrangement);
        return mav;
    }

    @RequestMapping(value = "/laboratory/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            int scheduleId = arrangementScheduleService.getSecheduleIdByArrangementId(id);
            arrangementScheduleService.delete(id, scheduleId);
            curriculumScheduleService.deleteById(scheduleId);
            arrangementService.delete(id);
        }
        return "redirect:/laboratory/jsp/appointment/laboratory/list";
    }

    @RequestMapping(value = "/laboratory/approve", method = RequestMethod.POST)
    public String approve(@RequestParam("items") List<Integer> items) {
        for(int id : items){
            Arrangement arrangement = arrangementService.selectByPrimaryKey(id);
            arrangement.setState((byte)Types.ApplyState.PASS.getValue());
            arrangement.setApprovalId(userService.getCurrentUserId());
            arrangementService.update(arrangement);
        }
        return "redirect:/laboratory/jsp/appointment/laboratory/list";
    }

    @RequestMapping(value = "/laboratory/reject", method = RequestMethod.POST)
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
        return "redirect:/laboratory/jsp/appointment/laboratory/list";
    }

//    @RequestMapping(value = "/appointmentbaseinfo")
//    public ModelAndView appointmentBaseInfo() {
//        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentbaseinfo");
//        return mav;
//    }

    @RequestMapping(value ="/laboratory/laboratoryapply",method = RequestMethod.GET)
    public ModelAndView laboratoryapply(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/laboratoryapply");
        return mav;
    }
    @RequestMapping(value ="/appointmentinfosubmit",method = RequestMethod.GET)
    public ModelAndView appointmentinfosubmit(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentinfosubmit");
        return mav;
    }

    @RequestMapping(value ="/laboratory/mydatelist",method = RequestMethod.GET)
    public ModelAndView mydatelist(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/mydatelist");
        return mav;
    }

    @RequestMapping(value ="/laboratory/appointmentdate",method = RequestMethod.GET)
    public ModelAndView appointdate(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentdate");
        return mav;
    }
    @RequestMapping(value ="/laboratory/appointmentdatecontent",method = RequestMethod.GET)
    public ModelAndView appointmentdatecontent(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentdatecontent");
        return mav;
    }

}
