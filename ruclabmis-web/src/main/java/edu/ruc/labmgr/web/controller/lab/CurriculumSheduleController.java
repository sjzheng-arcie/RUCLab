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
	@Autowired
	TeacherService teacherService;


	@RequestMapping(value = "/toDelete", method = RequestMethod.POST)
	public String toDelete(@RequestParam("items") List<Integer> items) {
		return "redirect:/laboratory/jsp/bas/curriculum/list";
	}
	@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
	public String deleteById(@RequestParam("curriculumScheduleId") int curriculumScheduleId) {
		curriculumScheduleService.deleteById(curriculumScheduleId);
		return "redirect:/laboratory/jsp/curriculum/curriculumclasslist?page=1";
	}
	@RequestMapping(value = "/curriculumclasslist", method = (RequestMethod.GET))
	public ModelAndView curriculumClassList(@RequestParam(value="page",required = true) int page){

		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
		List<Teacher> teacherList= teacherService.getAllTeacherList();
		List<Room> roomList = roomService.getAllRoomList();
		CurriculumScheduleCriteria scheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria sCriteria = scheduleCriteria.createCriteria();
		List<CurriculumSchedule> curriculumScheduleList= curriculumScheduleService.getCurriculumScheduleListGroupByWeek(scheduleCriteria);

		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
		PageInfo<CurriculumSchedule>pageInfo=curriculumScheduleService.selectListPage(curriculumScheduleCriteria,page);
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist");
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("termYearList",termYearList);
		mav.addObject("teacherList",teacherList);
		mav.addObject("roomList",roomList);
		return mav;
	}
	@RequestMapping(value = "/curriculumclasslist", method = (RequestMethod.POST))
	public ModelAndView curriculumClassList(@RequestParam(required = false,defaultValue = "") String roomName,
											@RequestParam(value="page",required = true) int page,
											@RequestParam(value="teacherId",required = false,defaultValue = "-1") int teacherId,
											@RequestParam(value="roomId",required = false,defaultValue = "-1") int roomId,
											@RequestParam(value="curriculumClassId",required = false,defaultValue = "-1") int classId,
											@RequestParam(value="weekNum",required = false,defaultValue = "-1") byte weekNum,
											@RequestParam(value="termYearId",required = false,defaultValue = "-1") int termYearId){

		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
		List<Teacher> teacherList= teacherService.getAllTeacherList();
		List<Room> roomList = roomService.getAllRoomList();
		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		curriculumScheduleCriteria.setDistinct(true);
		CurriculumScheduleCriteria.Criteria criteria = curriculumScheduleCriteria.createCriteria();
		if(classId!=-1)
			criteria.andClassIdEqualTo(classId);
		if(teacherId!=-1)
			criteria.andTeacheridEqualTo(teacherId);
		if(roomId!=-1)
			criteria.andRoomIdEqualTo(roomId);
		if(termYearId!=-1)
			criteria.andTermYearidEqualTo(termYearId);
		if(weekNum!=-1)
			criteria.andWeeknumEqualTo(weekNum);
		//if(ampmNum!=-1)
		//	criteria.andAmPmEqualTo(ampmNum);
		PageInfo<CurriculumSchedule>pageInfo=curriculumScheduleService.selectListPage(curriculumScheduleCriteria,page);
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/curriculumclasslist");
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("termYearList",termYearList);
		mav.addObject("teacherList",teacherList);
		mav.addObject("roomList",roomList);
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
	@RequestMapping(value = "/toupdatecurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toUpdateCurriculumSchedule(@RequestParam(value="curriculumScheduleId",required = true) int curriculumScheduleId){

		CurriculumSchedule curriculumSchedule= curriculumScheduleService.getCurriculumScheduleById(curriculumScheduleId);
		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/updatecurriculumschedule");
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("termYearList",termYearList);
		mav.addObject("curriculumSchedule",curriculumSchedule);
		return mav;
	}
	@RequestMapping(value = "/updatecurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateCurriculumSchedule(@RequestParam(value="page",required = false,defaultValue = "1") int page,
												 @RequestParam(value="curriculumScheduleId",required = true) int curriculumscheduleId,
												 @RequestParam(value="termYearId",required = true,defaultValue = "-1") int termYearId,
												 @RequestParam(value="curriculumClassId",required = true) int curriculumClassId,
												 @RequestParam(value="weekDay",required = true) Byte weekDay,
												 @RequestParam(value="weekNum",required = true) Byte weekNum,
												 @RequestParam(value="sectionBegin",required = true) int sectionBegin,
												 @RequestParam(value="roomId",required = true) int roomId,
												 @RequestParam(value="sectionEnd",required = true) int sectionEnd){

		CurriculumSchedule curriculumSchedule= curriculumScheduleService.getCurriculumScheduleById(curriculumscheduleId);
		if(curriculumClassId!=-1)
			curriculumSchedule.setClassId(curriculumClassId);
		if(termYearId!=-1)
			curriculumSchedule.setTermYearid(termYearId);
		if(weekDay!=-1)
			curriculumSchedule.setWeekdays(weekDay);
		if(weekNum!=-1)
			curriculumSchedule.setWeeknum(weekNum);
//		if(classSection!=-1)
//			curriculumSchedule.setAmPm(classSection);
		curriculumSchedule.setSectionBegin(sectionBegin);
		curriculumSchedule.setSectionEnd(sectionEnd);
		curriculumSchedule.setRoomId(roomId);
		curriculumScheduleService.update(curriculumSchedule);
		ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/curriculum/curriculumclasslist?page=1");
		return mav;
	}

	@RequestMapping(value = "/addcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addCurriculumSchedule(@RequestParam(value="termYearId",required = true) int teamYearId,
											  @RequestParam(value="curriculumClassId",required = true) int curriculumClassId,
											  @RequestParam(value="weekDay",required = true) Byte weekDay,
											  @RequestParam(value="roomId",required = true) int roomId ,
											  @RequestParam(value="beginWeek",required = true) Byte beginWeek,
											  @RequestParam(value="endWeek",required = true) Byte endWeek,
											  @RequestParam(value="sectionBegin",required = true) int sectionBegin,
											  @RequestParam(value="sectionEnd",required = true) int sectionEnd){

		CurriculumClass curriculumClass = curriculumClassService.getVirtualClass(curriculumClassId);
		Curriculum curriculum = curriculumService.getCurriculum(curriculumClass.getId());
		List<CurriculumSchedule> exsitedCurriculumScheduleList= new ArrayList();
		List<CurriculumSchedule> curriculumScheduleList= new ArrayList();
		for(Byte i=beginWeek;i<=endWeek;i++){

				CurriculumSchedule curriculumSchedule = new CurriculumSchedule();
				curriculumSchedule.setTermYearid(teamYearId);
				curriculumSchedule.setCurriculumId(curriculumClass.getId());
				curriculumSchedule.setWeekdays(weekDay);
				curriculumSchedule.setClassId(curriculumClassId);
				curriculumSchedule.setTeacherid(curriculum.getTeacherId());
				curriculumSchedule.setSectionBegin(sectionBegin);
				curriculumSchedule.setSectionEnd(sectionEnd);
				curriculumSchedule.setWeeknum(i);
				if(curriculumScheduleService.ifCurriculumScheduleExistd(curriculumSchedule)){
					curriculumSchedule.setTeacher(teacherService.selectByPrimaryKey(teamYearId));
					curriculumSchedule.setCurriculum(curriculumService.getCurriculum(curriculumClassService.getVirtualClass(curriculumClassId).getId()));
					curriculumSchedule.setCurriculumClass(curriculumClassService.getVirtualClass(curriculumClassId));
					curriculumSchedule.setTermYear(schoolCalenderService.getTermYearByPk(teamYearId));
					exsitedCurriculumScheduleList.add(curriculumSchedule);
				}else{
					curriculumScheduleList.add(curriculumSchedule);
				}


		}
		if(exsitedCurriculumScheduleList.size()==0){
			for(int i=0;i<curriculumScheduleList.size();i++){
				curriculumScheduleList.get(i).setRoomId(roomId);
				//curriculumScheduleService.update(curriculumScheduleList.get(i));
				curriculumScheduleService.add(curriculumScheduleList.get(i));

			}
		}
		ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/curriculum/curriculumclasslist?page=1");
		if(exsitedCurriculumScheduleList.size()>0){
			mav.setViewName("/laboratory/jsp/curriculum/existedcurriculumschedule");
			mav.addObject("exsitedCurriculumScheduleList",exsitedCurriculumScheduleList);
		}
		mav.addObject("",endWeek);
		return mav;
	}
//@RequestMapping(value = "/addcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
//public ModelAndView addCurriculumSchedule(@RequestParam(value="termYearId",required = true) int teamYearId,
//										  @RequestParam(value="curriculumClassId",required = true) int curriculumClassId,
//										  @RequestParam(value="weekDay",required = true) Byte weekDay,
//										  @RequestParam(value="roomId",required = true) int roomId ,
//										  @RequestParam(value="beginWeek",required = true) Byte beginWeek,
//										  @RequestParam(value="endWeek",required = true) Byte endWeek,
//										  @RequestParam(value="sectionBegin",required = true) int sectionBegin,
//										  @RequestParam(value="sectionEnd",required = true) int sectionEnd){
//
//	CurriculumClass curriculumClass = curriculumClassService.getVirtualClass(curriculumClassId);
//	Curriculum curriculum = curriculumService.getCurriculum(curriculumClass.getId());
//	List<CurriculumSchedule> exsitedCurriculumScheduleList= new ArrayList();
//	List<CurriculumSchedule> curriculumScheduleList= new ArrayList();
//
//
//		CurriculumSchedule curriculumSchedule = new CurriculumSchedule();
//		curriculumSchedule.setTermYearid(teamYearId);
//		curriculumSchedule.setCurriculumId(curriculumClass.getId());
//		curriculumSchedule.setWeekdays(weekDay);
//		curriculumSchedule.setClassId(curriculumClassId);
//		curriculumSchedule.setTeacherid(curriculum.getTeacherId());
//		curriculumSchedule.setSectionBegin(sectionBegin);
//		curriculumSchedule.setSectionEnd(sectionEnd);
//		curriculumSchedule.setWeeknum((byte)0);
//		if(curriculumScheduleService.ifCurriculumScheduleExistd(curriculumSchedule)){
//			curriculumSchedule.setTeacher(teacherService.selectByPrimaryKey(teamYearId));
//			curriculumSchedule.setCurriculum(curriculumService.getCurriculum(curriculumClassService.getVirtualClass(curriculumClassId).getId()));
//			curriculumSchedule.setCurriculumClass(curriculumClassService.getVirtualClass(curriculumClassId));
//			curriculumSchedule.setTermYear(schoolCalenderService.getTermYearByPk(teamYearId));
//			exsitedCurriculumScheduleList.add(curriculumSchedule);
//		}else{
//			curriculumScheduleList.add(curriculumSchedule);
//		}
//
//
//
//	if(exsitedCurriculumScheduleList.size()==0){
//		for(int i=0;i<curriculumScheduleList.size();i++){
//			curriculumScheduleList.get(i).setRoomId(roomId);
//			//curriculumScheduleService.update(curriculumScheduleList.get(i));
//			curriculumScheduleService.add(curriculumScheduleList.get(i));
//
//		}
//	}
//	ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/curriculum/curriculumclasslist?page=1");
//	if(exsitedCurriculumScheduleList.size()>0){
//		mav.setViewName("/laboratory/jsp/curriculum/existedcurriculumschedule");
//		mav.addObject("exsitedCurriculumScheduleList",exsitedCurriculumScheduleList);
//	}
//	mav.addObject("",endWeek);
//	return mav;
//}
	@RequestMapping(value = "/toselectlab", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomListchedule(@RequestParam(value="termYearId",required = true) int termYearId,
										@RequestParam(value="weekDay",required = true) Byte weekDay,
										@RequestParam(value="beginWeek",required = true) Byte beginWeek,
										@RequestParam(value="endWeek",required = true) Byte endWeek,
										@RequestParam(value="sectionBegin",required = true) int sectionBegin,
										@RequestParam(value="sectionEnd",required = true) int sectionEnd){

		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria=curriculumScheduleCriteria.createCriteria();
		criteria.andSectionBeginGreaterThanOrEqualTo(sectionBegin);
		criteria.andSectionEndLessThanOrEqualTo(sectionEnd);
		criteria.andWeekdaysGreaterThanOrEqualTo(beginWeek);
		criteria.andWeekdaysLessThanOrEqualTo(endWeek);
		criteria.andWeeknumEqualTo(weekDay);
		criteria.andTermYearidEqualTo(termYearId);
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
		mav.addObject("roomList",roomList);
		//mav.addObject("curriculumSchedule",curriculumSchedule);
		return mav;
	}

	@RequestMapping(value = "/toSearchroombyId", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toSearchroombyId(
										@RequestParam(value="roomId",required = true) int roomId){


		//List<Integer> roomIdList=new ArrayList<>();
		//roomIdList.add(roomId);
		List<Room> roomList= new ArrayList<>();
		roomList.add(roomService.getRoomById(roomId));

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
		mav.addObject("roomList",roomList);
		//mav.addObject("curriculumSchedule",curriculumSchedule);
		return mav;
	}

	@RequestMapping(value = "/tosetlab", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomschedule(@RequestParam(value="curriculumScheduleId",required = true) int curriculumScheduleId,
			@RequestParam(value="termYearId",required = true) int termYearId,
										@RequestParam(value="weekDay",required = true) Byte weekDay,
										@RequestParam(value="sectionBegin",required = true) int sectionBegin,
										@RequestParam(value="sectionEnd",required = true) int sectionEnd){

		CurriculumSchedule curriculumSchedule=curriculumScheduleService.getCurriculumScheduleById(curriculumScheduleId);
		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria=curriculumScheduleCriteria.createCriteria();
		criteria.andSectionBeginGreaterThanOrEqualTo(sectionBegin);
		criteria.andSectionEndLessThanOrEqualTo(sectionEnd);
		criteria.andWeeknumEqualTo(weekDay);
		criteria.andRoomIdEqualTo(curriculumSchedule.getRoomId());
		criteria.andTermYearidEqualTo(termYearId);
		criteria.andCurriculumIdEqualTo(curriculumScheduleId);
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
		//mav.addObject("curriculumSchedule",curriculumSchedule);
		return mav;
	}
//	@RequestMapping(value = "/tosetlab", method = {RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView roomschedule(@RequestParam(value="curriculumScheduleId",required = true) int curriculumScheduleId){
//
//		CurriculumSchedule curriculumSchedule=curriculumScheduleService.getCurriculumScheduleById(curriculumScheduleId);
//		CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
//		CurriculumScheduleCriteria.Criteria criteria=curriculumScheduleCriteria.createCriteria();
//		//criteria.andAmPmEqualTo(curriculumSchedule.getAmPm());
//		criteria.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
//		criteria.andWeeknumEqualTo(curriculumSchedule.getWeeknum());
//		criteria.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
//		List<Integer> roomIdList=curriculumScheduleService.getRoomListIdList(curriculumScheduleCriteria);
//		List<Room> roomList= roomService.getAllRoomListByIdList(roomIdList);
//		List<List<Room>> listRoomList=new ArrayList<List<Room>>();
//		for(int i=0;i<roomList.size()/4;i++){
//			listRoomList.add(i,roomList.subList(i*4,i*4+4));
//		}
//		listRoomList.add(listRoomList.size(),roomList.subList(listRoomList.size()*4,roomList.size()));
//		List<CurriculumSchedule> curriculumScheduleList=curriculumScheduleService.getCurriculumScheduleList();
//		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/setlab");
//		mav.addObject("roomList",roomList);
//		mav.addObject("listRoomList",listRoomList);
//		mav.addObject("curriculumScheduleList",curriculumScheduleList);
//		mav.addObject("curriculumSchedule",curriculumSchedule);
//		return mav;
//	}

	@RequestMapping(value = "/setlab", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView setLab(@RequestParam(required = true,defaultValue = "") int curriculumScheduleId,
							   @RequestParam(required = true,defaultValue = "") int roomId){
		CurriculumSchedule curriculumSchedule=curriculumScheduleService.getCurriculumScheduleById(curriculumScheduleId);
		curriculumSchedule.setRoomId(roomId);
		curriculumScheduleService.update(curriculumSchedule);
		ModelAndView mav = new ModelAndView("redirect:/laboratory/jsp/curriculum/curriculumclasslist?page=1");
		return mav;
	}

	@RequestMapping(value = "/allcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView allCurruculumschedule(@RequestParam(value="termYearId",required = true) int termYearId,
											  @RequestParam(value="teacherId",required = false,defaultValue = "-1") int teacherId,
											  @RequestParam(value="studentId",required = false,defaultValue = "-1") int studentId,
											  @RequestParam(value="curriculumClassId",required = false,defaultValue = "-1") int classId,
											  @RequestParam(value="roomId",required = false,defaultValue = "-1") int roomId){

		List<List<String>>  strCurriculumScheduleListStr= new ArrayList<>();
		for(byte i=0;i<4;i++){
			for(byte j=0;j<7;j++){
				List<String> strCurriculumSchedule = new ArrayList<String>();
				CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
				CurriculumScheduleCriteria.Criteria criteria= curriculumScheduleCriteria.createCriteria();
				if(teacherId!=-1){
					criteria.andTeacheridEqualTo(teacherId);
				}else if(roomId!=-1){
					criteria.andRoomIdEqualTo(roomId);
				}else if(classId!=-1){
					criteria.andClassIdEqualTo(classId);
				}
				criteria.andTermYearidEqualTo(termYearId);
				//criteria.andAmPmEqualTo((byte)(i+1));
				if(i==0){
					criteria.andSectionEndLessThanOrEqualTo(4);
				}else if(i==1){
					criteria.andSectionBeginGreaterThanOrEqualTo(5);
					criteria.andSectionEndLessThanOrEqualTo(6);
				}else if(i==2){
					criteria.andSectionBeginGreaterThanOrEqualTo(7);
					criteria.andSectionEndLessThanOrEqualTo(10);
				}
				else if(i==3){
					criteria.andSectionBeginGreaterThanOrEqualTo(11);
					criteria.andSectionEndLessThanOrEqualTo(14);
				}

				criteria.andWeekdaysEqualTo((byte)(j+1));

				if(curriculumScheduleService.getCurriculumScheduleListGroupByWeek(curriculumScheduleCriteria).size()!=0){
					List<CurriculumSchedule> curriculumScheduleLists= curriculumScheduleService.getCurriculumScheduleListGroupByWeek(curriculumScheduleCriteria);
					for(int k=0;k<curriculumScheduleLists.size();k++){
						CurriculumSchedule curriculumSchedule = curriculumScheduleLists.get(k);
						CurriculumScheduleCriteria curriculumScheduleCriteria1= new CurriculumScheduleCriteria();
						CurriculumScheduleCriteria.Criteria criteria1= curriculumScheduleCriteria1.createCriteria();
						curriculumScheduleCriteria1.setOrderByClause("weekNum asc");
						//criteria1.andAmPmEqualTo(curriculumSchedule.getAmPm());

						if(roomId!=-1){
							criteria1.andRoomIdEqualTo(roomId);
						}else{
							if(curriculumSchedule.getRoomId()!=null){
								criteria1.andRoomIdEqualTo(curriculumSchedule.getRoomId());
							}else{
								criteria1.andRoomIdIsNull();
							}
						}
						if(termYearId!=-1){
							criteria.andTermYearidEqualTo(termYearId);
						}
						criteria1.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
						criteria1.andClassIdEqualTo(curriculumSchedule.getClassId());
						criteria1.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
						criteria1.andTeacheridEqualTo(curriculumSchedule.getTeacherid());
						criteria1.andCurriculumIdEqualTo(curriculumSchedule.getCurriculumId());
						criteria1.andSectionBeginEqualTo(curriculumSchedule.getSectionBegin());
						criteria1.andSectionEndEqualTo(curriculumSchedule.getSectionEnd());
						List<CurriculumSchedule> tempList=curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria1);
						int tempBegin=0;
						if(tempList.size()==1){
							String strClassSchedule=tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";
							if(tempList.get(0).getRoom()!=null){
								strClassSchedule=strClassSchedule+tempList.get(0).getRoom().getName()+"<br>";
							}else{
								strClassSchedule=strClassSchedule+"房间待分配<br>";
							}
							strClassSchedule=strClassSchedule+"(第"+tempList.get(0).getWeeknum()+"周)<br>";

							strCurriculumSchedule.add(strClassSchedule);
						}else{

							for(int m=1;m<tempList.size();m++){
								String tempString=new String();
								if(tempList.get(m).getWeeknum()-tempList.get(m-1).getWeeknum()!=1){
									tempString=tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";
									if(tempList.get(0).getRoom()!=null){
										tempString=tempString+tempList.get(0).getRoom().getName()+"<br>";
									}else{
										tempString=tempString+"房间待分配<br>";
									}
									tempString=tempString+"(第"+tempList.get(tempBegin).getWeeknum()+"至"+tempList.get(m-1).getWeeknum()+"周)<br>";
									if(tempList.get(tempBegin).getSectionBegin().equals(tempList.get(tempBegin).getSectionEnd())){

										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"节)<br>";
									}else{
										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"至"+tempList.get(m-1).getSectionEnd()+"节)<br>";
									}
									tempBegin=m;
									strCurriculumSchedule.add(tempString);
								}
								if(m==tempList.size()-1&&tempBegin<tempList.size()-1&&tempList.get(m).getWeeknum()-tempList.get(m-1).getWeeknum()==1){
									tempString=tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";
									if(tempList.get(0).getRoom()!=null){
										tempString=tempString+tempList.get(0).getRoom().getName()+"<br>";
									}else{
										tempString=tempString+"房间待分配<br>";
									}
									tempString=tempString+"(第"+tempList.get(tempBegin).getWeeknum()+"至"+tempList.get(m).getWeeknum()+"周)<br>";
									if(tempList.get(tempBegin).getSectionBegin().equals(tempList.get(tempBegin).getSectionEnd())){

										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"节)<br>";
									}else{
										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"至"+tempList.get(m-1).getSectionEnd()+"节)<br>";
									}
									tempBegin=m;
									strCurriculumSchedule.add(tempString);
								}
							}
						}
					}
					strCurriculumScheduleListStr.add(i*7+j,strCurriculumSchedule);
				}else {
					strCurriculumScheduleListStr.add(i*7+j,strCurriculumSchedule);
				}
			}
		}
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();

		ModelAndView mav = new ModelAndView();
		if(teacherId!=-1){

			mav= new ModelAndView("/laboratory/jsp/curriculum/searchcurriculumschedulebyteacher");
			mav.addObject("teacherInfo",teacherService.selectByPrimaryKey(teacherId));
			mav.addObject("teacherList",teacherService.getAllTeacherList());
			mav.addObject("curriculumScheduleTitle",teacherService.selectByPrimaryKey(teacherId).getName()+"老师的课表");
		}
		if(classId!=-1){
			mav= new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyclassid");
			mav.addObject("classInfo",curriculumClassService.getVirtualClass(classId));
			mav.addObject("curriculumClassList",curriculumClassService.getAllCurriculumClass());
			mav.addObject("curriculumScheduleTitle","班级"+curriculumClassService.getVirtualClass(classId).getClassName()+" 的课表");
		}

		if(roomId!=-1){
			mav= new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyroom");
			mav.addObject("roomInfo",roomService.getRoomById(roomId));
			mav.addObject("roomList",roomService.getAllRoomList());
			mav.addObject("curriculumScheduleTitle","房间"+roomService.getRoomById(roomId).getName()+" 的课表");
		}
		mav.addObject("termYearInfo",schoolCalenderService.getTermYearByPk(termYearId));
		mav.addObject("strCurriculumScheduleListStr",strCurriculumScheduleListStr);
		mav.addObject("termYearList",termYearList);
		return mav;
	}


//	@RequestMapping(value = "/allcurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView allCurruculumschedule(@RequestParam(value="termYearId",required = true) int termYearId,
//											  @RequestParam(value="teacherId",required = false,defaultValue = "-1") int teacherId,
//											  @RequestParam(value="studentId",required = false,defaultValue = "-1") int studentId,
//											  @RequestParam(value="curriculumClassId",required = false,defaultValue = "-1") int classId,
//											  @RequestParam(value="roomId",required = false,defaultValue = "-1") int roomId){
//
//		List<List<String>>  strCurriculumScheduleListStr= new ArrayList<>();
//		for(byte i=0;i<4;i++){
//			for(byte j=0;j<7;j++){
//				List<String> strCurriculumSchedule = new ArrayList<String>();
//				CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
//				CurriculumScheduleCriteria.Criteria criteria= curriculumScheduleCriteria.createCriteria();
//				if(teacherId!=-1){
//					criteria.andTeacheridEqualTo(teacherId);
//				}else if(roomId!=-1){
//					criteria.andRoomIdEqualTo(roomId);
//				}else if(classId!=-1){
//					criteria.andClassIdEqualTo(classId);
//				}
//				criteria.andTermYearidEqualTo(termYearId);
//				//criteria.andAmPmEqualTo((byte)(i+1));
//				criteria.andWeekdaysEqualTo((byte)(j+1));
//				if(curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria).size()!=0){
//					List<CurriculumSchedule> curriculumScheduleLists= curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria);
//					for(int k=0;k<curriculumScheduleLists.size();k++){
//						CurriculumSchedule curriculumSchedule = curriculumScheduleLists.get(k);
//						CurriculumScheduleCriteria curriculumScheduleCriteria1= new CurriculumScheduleCriteria();
//						CurriculumScheduleCriteria.Criteria criteria1= curriculumScheduleCriteria1.createCriteria();
//					//	curriculumScheduleCriteria1.setOrderByClause("weekNum asc");
//						//criteria1.andAmPmEqualTo(curriculumSchedule.getAmPm());
//						if(i==0){
//							criteria1.andSectionEndLessThanOrEqualTo(4);
//						}else if(i==1){
//							criteria1.andSectionBeginGreaterThanOrEqualTo(5);
//							criteria1.andSectionEndLessThanOrEqualTo(6);
//						}else if(i==2){
//							criteria1.andSectionBeginGreaterThanOrEqualTo(7);
//							criteria1.andSectionEndLessThanOrEqualTo(10);
//						}
//						else if(i==3){
//							criteria1.andSectionBeginGreaterThanOrEqualTo(11);
//							criteria1.andSectionEndLessThanOrEqualTo(14);
//						}
//
//						if(roomId!=-1){
//							criteria1.andRoomIdEqualTo(roomId);
//						}else{
//							if(curriculumSchedule.getRoomId()!=null){
//								criteria1.andRoomIdEqualTo(curriculumSchedule.getRoomId());
//							}else{
//								criteria1.andRoomIdIsNull();
//							}
//						}
//						if(termYearId!=-1){
//							criteria.andTermYearidEqualTo(termYearId);
//						}
//						criteria1.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
//						criteria1.andClassIdEqualTo(curriculumSchedule.getClassId());
//						criteria1.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
//						criteria1.andTeacheridEqualTo(curriculumSchedule.getTeacherid());
//						criteria1.andCurriculumIdEqualTo(curriculumSchedule.getCurriculumId());
//						List<CurriculumSchedule> tempList=curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria1);
//						int tempBegin=0;
//
//
//							for(int m=0;m<tempList.size();m++){
//								String tempString=new String();
//									tempString=tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";
//									tempString=tempString+tempList.get(0).getRoom().getName()+"<br>";
//									if(tempList.get(tempBegin).getSectionBegin().equals(tempList.get(tempBegin).getSectionEnd())){
//
//										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"节)<br>";
//									}else{
//										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"至"+tempList.get(m-1).getSectionEnd()+"节)<br>";
//									}
//									tempBegin=m;
//									strCurriculumSchedule.add(tempString);
//							}
//
//					}
//					strCurriculumScheduleListStr.add(i*7+j,strCurriculumSchedule);
//				}else {
//					strCurriculumScheduleListStr.add(i*7+j,strCurriculumSchedule);
//				}
//			}
//		}
//		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
//
//		ModelAndView mav = new ModelAndView();
//		if(teacherId!=-1){
//
//			mav= new ModelAndView("/laboratory/jsp/curriculum/searchcurriculumschedulebyteacher");
//			mav.addObject("teacherInfo",teacherService.selectByPrimaryKey(teacherId));
//			mav.addObject("teacherList",teacherService.getAllTeacherList());
//			mav.addObject("curriculumScheduleTitle",teacherService.selectByPrimaryKey(teacherId).getName()+"老师的课表");
//		}
//		if(classId!=-1){
//			mav= new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyclassid");
//			mav.addObject("classInfo",curriculumClassService.getVirtualClass(classId));
//			mav.addObject("curriculumClassList",curriculumClassService.getAllCurriculumClass());
//			mav.addObject("curriculumScheduleTitle","班级"+curriculumClassService.getVirtualClass(classId).getClassName()+" 的课表");
//		}
//
//		if(roomId!=-1){
//			mav= new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyroom");
//			mav.addObject("roomInfo",roomService.getRoomById(roomId));
//			mav.addObject("roomList",roomService.getAllRoomList());
//			mav.addObject("curriculumScheduleTitle","房间"+roomService.getRoomById(roomId).getName()+" 的课表");
//		}
//		mav.addObject("termYearInfo",schoolCalenderService.getTermYearByPk(termYearId));
//		mav.addObject("strCurriculumScheduleListStr",strCurriculumScheduleListStr);
//		mav.addObject("termYearList",termYearList);
//		return mav;
//	}



	@RequestMapping(value = "/mycurriculumschedule", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mycurruculumschedule(@RequestParam(value="termYearId",required = false,defaultValue = "-1") int termYearId){
		List<CurriculumSchedule> curriculumScheduleList = new ArrayList<CurriculumSchedule>();

		List<List<String>>  strCurriculumScheduleListStr= new ArrayList<>();
		List<Teacher> teacherList = teacherService.getAllTeacherList();
		for(byte i=0;i<4;i++){
			for(byte j=0;j<7;j++){
				List<String> strCurriculumSchedule = new ArrayList<String>();
				CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
				CurriculumScheduleCriteria.Criteria criteria= curriculumScheduleCriteria.createCriteria();
				if (userService.getCurrentUser().getRole().getName().equals("student")){
					if(curriculumScheduleService.getClassIdListByStudentId(userService.getCurrentUserId())!=null&&curriculumScheduleService.getClassIdListByStudentId(userService.getCurrentUserId()).size()>0){
						criteria.andClassIdIn(curriculumScheduleService.getClassIdListByStudentId(userService.getCurrentUserId()));
					}else{
						criteria.andClassIdIsNull();
					}

				}else if (userService.getCurrentUser().getRole().getName().equals("teacher")){
					criteria.andTeacheridEqualTo(userService.getCurrentUserId());
				}
				if(termYearId!=-1){
					criteria.andTermYearidEqualTo(termYearId);
				}

				//criteria.andAmPmEqualTo((byte)(i+1));
				criteria.andWeekdaysEqualTo((byte)(j+1));
				if(curriculumScheduleService.getCurriculumScheduleListGroupByWeek(curriculumScheduleCriteria)!=null){
					List<CurriculumSchedule> curriculumScheduleLists= curriculumScheduleService.getCurriculumScheduleListGroupByWeek(curriculumScheduleCriteria);
					for(int k=0;k<curriculumScheduleLists.size();k++){
						CurriculumSchedule curriculumSchedule = curriculumScheduleLists.get(k);
						CurriculumScheduleCriteria curriculumScheduleCriteria1= new CurriculumScheduleCriteria();
						CurriculumScheduleCriteria.Criteria criteria1= curriculumScheduleCriteria1.createCriteria();
						curriculumScheduleCriteria1.setOrderByClause("weekNum asc");
						criteria1.andSectionBeginEqualTo(curriculumSchedule.getSectionBegin());
						criteria1.andSectionEndEqualTo(curriculumSchedule.getSectionEnd());
						//criteria1.andAmPmEqualTo(curriculumSchedule.getAmPm());

						if(i==0){
							criteria1.andSectionEndLessThanOrEqualTo(4);
						}else if(i==1){
							criteria1.andSectionBeginGreaterThanOrEqualTo(5);
							criteria1.andSectionEndLessThanOrEqualTo(6);
						}else if(i==2){
							criteria1.andSectionBeginGreaterThanOrEqualTo(7);
							criteria1.andSectionEndLessThanOrEqualTo(10);
						}
						else if(i==3){
							criteria1.andSectionBeginGreaterThanOrEqualTo(11);
							criteria1.andSectionEndLessThanOrEqualTo(14);
						}

						if(curriculumSchedule.getRoomId()!=null){
							criteria1.andRoomIdEqualTo(curriculumSchedule.getRoomId());
						}else{
							criteria1.andRoomIdIsNull();
						}
						if(termYearId!=-1){
							criteria.andTermYearidEqualTo(termYearId);
						}
						if (curriculumSchedule.getTermYearid()!=null)
							criteria1.andTermYearidEqualTo(curriculumSchedule.getTermYearid());
						if(curriculumSchedule.getClassId()!=null)
							criteria1.andClassIdEqualTo(curriculumSchedule.getClassId());
						if(curriculumSchedule.getWeekdays()!=null)
							criteria1.andWeekdaysEqualTo(curriculumSchedule.getWeekdays());
						if(curriculumSchedule.getTeacherid()!=null)
							criteria1.andTeacheridEqualTo(curriculumSchedule.getTeacherid());
						if(curriculumSchedule.getCurriculumId()!=null)
							criteria1.andCurriculumIdEqualTo(curriculumSchedule.getCurriculumId());
						List<CurriculumSchedule> tempList=curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria1);
						int tempBegin=0;
						if(tempList.size()==1){
							String strClassSchedule = "";
							if(tempList.get(0).getCurriculum()!=null){
								strClassSchedule =tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";

							}
							if(tempList.get(0).getRoom()!=null){
								strClassSchedule=strClassSchedule+"<br>"+tempList.get(0).getRoom().getName()+"<br>";
							}else{
								strClassSchedule=strClassSchedule+"房间待分配<br>";
							}
							strClassSchedule=strClassSchedule+"(第"+tempList.get(0).getWeeknum()+"周)<br>";
							strCurriculumSchedule.add(strClassSchedule);
						}else{

							for(int m=1;m<tempList.size();m++){
								String tempString=new String();
								if(tempList.get(m).getWeeknum()-tempList.get(m-1).getWeeknum()!=1&&m!=tempList.size()){
									tempString=tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";
									if(tempList.get(0).getRoom()!=null){
										tempString=tempString+tempList.get(0).getRoom().getName()+"<br>";
									}else{
										tempString=tempString+"房间待分配<br>";
									}
									tempString=tempString+"(第"+tempList.get(tempBegin).getWeeknum()+"至"+tempList.get(m-1).getWeeknum()+"周)<br>";
									if(tempList.get(tempBegin).getSectionBegin().equals(tempList.get(tempBegin).getSectionEnd())){

										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"节)<br>";
									}else{
										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"至"+tempList.get(m-1).getSectionEnd()+"节)<br>";
									}
									tempBegin=m;
									strCurriculumSchedule.add(tempString);
								}
								if(m==tempList.size()-1&&tempBegin<tempList.size()-1&&tempList.get(m).getWeeknum()-tempList.get(m-1).getWeeknum()==1){
									tempString=tempList.get(0).getCurriculum().getName()+"<br>"+tempList.get(0).getTeacher().getName()+"<br>";
									if(tempList.get(0).getRoom()!=null){
										tempString=tempString+tempList.get(0).getRoom().getName()+"<br>";
									}else{
										tempString=tempString+"房间待分配<br>";
									}
									tempString=tempString+"(第"+tempList.get(tempBegin).getWeeknum()+"至"+tempList.get(m).getWeeknum()+"周)<br>";
									if(tempList.get(tempBegin).getSectionBegin().equals(tempList.get(tempBegin).getSectionEnd())){

										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"节)<br>";
									}else{
										tempString=tempString+"(第"+tempList.get(tempBegin).getSectionBegin()+"至"+tempList.get(m-1).getSectionEnd()+"节)<br>";
									}
									tempBegin=m;
									strCurriculumSchedule.add(tempString);
								}
							}
						}
					}
					strCurriculumScheduleListStr.add(i*7+j,strCurriculumSchedule);
				}else {

					strCurriculumScheduleListStr.add(i*7+j,strCurriculumSchedule);
				}
			}
		}
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();

		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/mycurriculumschedule");
		mav.addObject("strCurriculumScheduleListStr",strCurriculumScheduleListStr);
		mav.addObject("termYearInfo",schoolCalenderService.getTermYearByPk(termYearId));
		mav.addObject("termYearList",termYearList);
		mav.addObject("teacherList",teacherList);
		return mav;
	}

	@RequestMapping(value = "/toSearchByClassId", method = (RequestMethod.GET))
	public ModelAndView toSearchByClassId(){

		List<CurriculumClass> curriculumClassList=curriculumClassService.getAllCurriculumClass();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
		List<String> tempStrList = new ArrayList<String>();
		tempStrList.add(0,"");
		List<List<String>>  strCurriculumScheduleListStr= new ArrayList<>();
		for(byte i=0;i<4;i++){
			for(byte j=0;j<7;j++){
				strCurriculumScheduleListStr.add(i*7+j,tempStrList);
			}
		}

		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyclassid");
		mav.addObject("curriculumClassList",curriculumClassList);
		mav.addObject("strCurriculumScheduleListStr",strCurriculumScheduleListStr);
		mav.addObject("termYearList",termYearList);
		return mav;
	}

	@RequestMapping(value = "/toSearchByRoomId", method = (RequestMethod.GET))
	public ModelAndView toSearchByRoomId(){

		List<Room> roomList=roomService.getAllRoomList();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
		List<String> tempStrList = new ArrayList<String>();
		tempStrList.add(0,"");
		List<List<String>>  strCurriculumScheduleListStr= new ArrayList<>();
		for(byte i=0;i<4;i++){
			for(byte j=0;j<7;j++){
				strCurriculumScheduleListStr.add(i*7+j,tempStrList);
			}
		}

		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyroom");
		mav.addObject("roomList",roomList);
		mav.addObject("strCurriculumScheduleListStr",strCurriculumScheduleListStr);
		mav.addObject("termYearList",termYearList);
		return mav;
	}

	@RequestMapping(value = "/toSearchByTeacherId", method = (RequestMethod.GET))
	public ModelAndView toSearchByTeacherId(){

		List<Teacher> teacherList = teacherService.getAllTeacherList();
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
		List<String> tempStrList = new ArrayList<String>();
		tempStrList.add(0,"");
		List<List<String>>  strCurriculumScheduleListStr= new ArrayList<>();
		for(byte i=0;i<5;i++){
			for(byte j=0;j<7;j++){
				strCurriculumScheduleListStr.add(i*7+j,tempStrList);
			}
		}
		ModelAndView mav = new ModelAndView("laboratory/jsp/curriculum/searchcurriculumschedulebyteacher");
		mav.addObject("teacherList",teacherList);
		mav.addObject("strCurriculumScheduleListStr",strCurriculumScheduleListStr);
		mav.addObject("termYearList",termYearList);
		return mav;
	}

	@RequestMapping(value = "/searchByTeacherId", method = (RequestMethod.POST))
	public ModelAndView searchByTeacherId(@RequestParam(value="termYearId",required = true) int termYearId,
												   @RequestParam(value="teacherId",required = true) int teacherId){
		List<TermYear> termYearList=schoolCalenderService.getAllTermYear();
		List<Teacher> teacherList = teacherService.getAllTeacherList();
		List<CurriculumSchedule> curriculumScheduleList = new ArrayList<CurriculumSchedule>();
		curriculumScheduleList.add(0,new CurriculumSchedule());
		List<List<CurriculumSchedule>>  curriculumScheduleListList= new ArrayList<>();
		for(byte i=0;i<4;i++){
			for(byte j=0;j<7;j++){
				CurriculumScheduleCriteria curriculumScheduleCriteria = new CurriculumScheduleCriteria();
				CurriculumScheduleCriteria.Criteria criteria= curriculumScheduleCriteria.createCriteria();
				criteria.andTeacheridEqualTo(teacherId);
				criteria.andTermYearidEqualTo(termYearId);
			//	criteria.andAmPmEqualTo((byte)(i+1));
				criteria.andWeekdaysEqualTo((byte)(j+1));
				if(curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria).size()!=0){
					curriculumScheduleListList.add(i*7+j,curriculumScheduleService.getCurriculumScheduleList(curriculumScheduleCriteria));

				}else {
					curriculumScheduleListList.add(i*7+j,curriculumScheduleList);
				}
			}
		}
		ModelAndView mav = new ModelAndView("/laboratory/jsp/curriculum/searchcurriculumschedulebyteacher");
		mav.addObject("curriculumScheduleTitle","教师"+teacherService.selectByPrimaryKey(teacherId).getName()+"于"+schoolCalenderService.getTermYearByPk(termYearId).getName()+"学期的课表");
		mav.addObject("curriculumScheduleListList",curriculumScheduleListList);
		mav.addObject("termYearList",termYearList);
		mav.addObject("teacherList",teacherList);
		return mav;
	}
}

