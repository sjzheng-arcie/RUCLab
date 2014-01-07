package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.*;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-31
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/curriculum")
public class CurriculumSheduleController {
	@Autowired
	UserService userService;
	@Autowired
	CurriculumScheduleService curriculumScheduleService;
	@Autowired
	CurriculumClassService curriculumClassService;
	@Autowired
	SchoolCalenderService schoolCalenderService;
	@Autowired
	CurriculumService curriculumService;
	@Autowired
	LaboratoryRoomService laboratoryRoomService;
	@Autowired
	RoomService roomService;


	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("items") List<Integer> items) {
		return "redirect:/laboratory/jsp/bas/curriculum/list";
	}
	@RequestMapping(value = "/curriculumclasslist", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView curriculumClassList(@RequestParam(required = false,defaultValue = "") String roomName,
											@RequestParam(value="page",required = false,defaultValue = "1") int page){
		PageInfo<CurriculumSchedule>pageInfo=curriculumScheduleService.selectListPage(null,page);
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist");
		mav.addObject("pageInfo",pageInfo);
		return mav;
	}
	@RequestMapping(value = "/newcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView newCurriculumSchedule(@RequestParam(value="page",required = false,defaultValue = "1") int page){

		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/newcurriculumschedule");
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("termYearList",termYearList);
		return mav;
	}
	@RequestMapping(value = "/updatecurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateCurriculumSchedule(@RequestParam(value="page",required = false,defaultValue = "1") int page,
												 @RequestParam(value="curriculumscheduleId",required = false,defaultValue = "1") int curriculumscheduleId){

		CurriculumSchedule curriculumSchedule= curriculumScheduleService.getCurriculumScheduleById(curriculumscheduleId);
		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/newcurriculumschedule");
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("termYearList",termYearList);
		mav.addObject("curriculumSchedule",curriculumSchedule);
		return mav;
	}
	@RequestMapping(value = "/addcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addCurriculumSchedule(@RequestParam(value="termYearId",required = true) int teamYearId,
											  @RequestParam(value="curriculumClassId",required = true) int curriculumClassId,
											  @RequestParam(value="weekDay",required = true) Byte weekDay,
											  @RequestParam(value="beginWeek",required = true) Byte beginWeek,
											  @RequestParam(value="endWeek",required = true) Byte endWeek,
											  @RequestParam(value="classSection",required = true) Byte classSection ){

		CurriculumClass curriculumClass = curriculumClassService.getVirtualClass(curriculumClassId);
		Curriculum curriculum = curriculumService.getCurriculum(curriculumClass.getCurriculumId());

		for(Byte i=0;i<(endWeek-beginWeek);i++){
			CurriculumSchedule curriculumSchedule = new CurriculumSchedule();
			curriculumSchedule.setTermYearid(teamYearId);
			curriculumSchedule.setCurriculumId(curriculumClass.getCurriculumId());
			curriculumSchedule.setWeekday(weekDay);
			curriculumSchedule.setClassId(curriculumClassId);
			curriculumSchedule.setTeacherid(curriculum.getId());
			curriculumSchedule.setAmPm(classSection);
			curriculumSchedule.setWeek(i);
			curriculumScheduleService.add(curriculumSchedule);
		}
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/setlab");
		mav.addObject("",endWeek);

		return mav;
	}
	@RequestMapping(value = "/tosetlab", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomschedule(@RequestParam(value="curriculumScheduleId",required = true) int curriculumScheduleId){

		CurriculumSchedule curriculumSchedule=curriculumScheduleService.getCurriculumScheduleById(curriculumScheduleId);
		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria=curriculumScheduleCriteria.createCriteria();
		criteria.andAmPmEqualTo(curriculumSchedule.getAmPm());
		criteria.andWeekdayEqualTo(curriculumSchedule.getWeekday());
		criteria.andWeekEqualTo(curriculumSchedule.getWeek());
		criteria.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
		List<Integer> roomIdList=curriculumScheduleService.getRoomListIdList(curriculumScheduleCriteria);
		List<Room> roomList= roomService.getAllRoomListByIdList(roomIdList);
 		List<List<Room>> listRoomList=new ArrayList<List<Room>>();
		for(int i=0;i<roomList.size()/4;i++){
			listRoomList.add(i,roomList.subList(i*4,i*4+4));
		}
		listRoomList.add(listRoomList.size(),roomList.subList(listRoomList.size()*4,roomList.size()));
		List<CurriculumSchedule> curriculumScheduleList=curriculumScheduleService.getCurriculumScheduleList();
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/setlab");
		mav.addObject("roomList",roomList);
		mav.addObject("listRoomList",listRoomList);
		mav.addObject("curriculumScheduleList",curriculumScheduleList);
		mav.addObject("curriculumSchedule",curriculumSchedule);
		return mav;
	}
	@RequestMapping(value = "/setlab", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView setLab(@RequestParam(required = true,defaultValue = "") int curriculumScheduleId,
							   @RequestParam(required = true,defaultValue = "") int roomId){
		CurriculumSchedule curriculumSchedule=curriculumScheduleService.getCurriculumScheduleById(curriculumScheduleId);
		curriculumSchedule.setRoomId(roomId);
		curriculumScheduleService.update(curriculumSchedule);
		ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/curriculum/curriculumclasslist");
		return mav;
	}
	@RequestMapping(value = "/myteachercurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView myteachercurruculumschedule(){

		List<CurriculumSchedule> curriculumScheduleList = new ArrayList<CurriculumSchedule>();
		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria= curriculumScheduleCriteria.createCriteria();
		Byte weekNum=1;
		criteria.andWeekEqualTo(weekNum);
		criteria.andTeacheridEqualTo(userService.getCurrentUserId());
		for(Byte i=0;i<5;i++){
			criteria.andAmPmEqualTo(i);

			for(Byte j=0;j<5;j++){
				criteria.andWeekdayEqualTo(j);
				if(curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria).size()!=0){
					curriculumScheduleList.add(i*5+j,curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria).get(0));

				}else {
					curriculumScheduleList.add(i*5+j,new CurriculumSchedule());
				}

			}
		}
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/myteachercurriculumschedule");
		mav.addObject("curriculumScheduleList",curriculumScheduleList);
		return mav;
	}
	@RequestMapping(value = "/addlession", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addLession(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/addlession");
		return mav;
	}
	@RequestMapping(value = "/createcurriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView createCurriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/createcurriculum");
		return mav;
	}

	@RequestMapping(value = "/curriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Curriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculum");
		return mav;
	}
	@RequestMapping(value = "/curriculumclasslist-bak", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView curriculumClassListBak(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist-bak");
		return mav;
	}

	@RequestMapping(value = "/curriculumview", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView curriculumview(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumview");
		return mav;
	}

	@RequestMapping(value = "/importcurriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView importcurriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/importcurriculum");
		return mav;
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView list(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/list");
		return mav;
	}

	@RequestMapping(value = "/listapply", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listApply(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/listapply");
		return mav;
	}

	@RequestMapping(value = "/listcommit", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listCommit(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/listcommit");
		return mav;
	}

	@RequestMapping(value = "/mycurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mycurriculumschedule(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/mycurriculumschedule");
		return mav;
	}

	@RequestMapping(value = "/setcurriculum", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView setcurriculum(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/setcurriculum");
		return mav;
	}

	@RequestMapping(value = "/toaddlession", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toaddlession(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/toaddlession");
		return mav;
	}
	@RequestMapping(value = "/view", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView view(@RequestParam(required = false,defaultValue = "") String roomName){

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/view");
		return mav;
	}
}

