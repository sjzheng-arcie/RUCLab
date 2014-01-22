package edu.ruc.labmgr.web.controller.lab;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Curriculum;
import edu.ruc.labmgr.domain.CurriculumSchedule;
import edu.ruc.labmgr.domain.Room;
import edu.ruc.labmgr.domain.TermYear;
import edu.ruc.labmgr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

public class AppointmentController {
    @Autowired
    CurriculumScheduleService curriculumScheduleService;
    @Autowired
    CurriculumService curriculumService;
    @Autowired
    ArrangementService arrangementService;
    @Autowired
    RoomService roomService;
    @Autowired
    TermYearService yearService;

    @RequestMapping(value = "/appointmentbaseinfo")
    public ModelAndView appointmentBaseinfo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Integer currYear =   calendar.get(Calendar.YEAR);
        Integer currWeek =   calendar.get(Calendar.WEEK_OF_YEAR);
        Integer currDay =   calendar.get(Calendar.DAY_OF_WEEK);

        List<TermYear> years = yearService.getAllTermYearList();

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/appointmentbaseinfo");
        mav.addObject("currYear", currYear);
        mav.addObject("currWeek", currWeek);
        mav.addObject("currDay", currDay);
        mav.addObject("years", years);
        return mav;
    }

    @RequestMapping(value = "/roomstatus", method = RequestMethod.GET)
    ModelAndView roomStatus(@RequestParam(required = false,defaultValue = "") String year,
                            @RequestParam(required = false,defaultValue = "") String week,
                            @RequestParam(required = false,defaultValue = "") String wDay,
                            @RequestParam(required = false,defaultValue = "") String section) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Integer inYear;
        if(StringUtils.isNullOrEmpty(year)){
            inYear = calendar.get(Calendar.YEAR);
        }
        else{
            inYear = Integer.parseInt(year);
        }

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

        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/roomstatus");
        mav.addObject("rooms", rooms);
        mav.addObject("occupiedRoomIds", occupiedRoomIds);
        mav.addObject("schedules", schedules);
        return mav;
    }


    @RequestMapping(value = "/laboratory/appointmentbaseinfo")
    public ModelAndView appointmentBaseInfo() {
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/appointmentbaseinfo");
        return mav;
    }

    @RequestMapping(value ="/laboratory/laboratoryapply",method = RequestMethod.GET)
    public ModelAndView laboratoryapply(){
        ModelAndView mav = new ModelAndView("laboratory/jsp/appointment/laboratory/laboratoryapply");
        return mav;
    }
    @RequestMapping(value ="/laboratory/appointmentinfosubmit",method = RequestMethod.GET)
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
