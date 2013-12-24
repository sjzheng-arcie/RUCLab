package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.LaboratoryRoomService;
import edu.ruc.labmgr.service.LaboratoryService;
import edu.ruc.labmgr.service.RoomService;
import edu.ruc.labmgr.service.TeacherService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 下午2:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/lab/lab")
public class LaboratoryController {
	@Autowired
	private LaboratoryService laboratoryService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private LaboratoryRoomService laboratoryRoomServiceService;
	@Autowired
	private TeacherService userService;

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(@RequestParam(required = false,defaultValue = "") String laboratoryName,
							 @RequestParam(value = "page", required = false, defaultValue = "1") int page){
		LaboratoryCriteria laboratoryCriteria=new LaboratoryCriteria();
		LaboratoryCriteria.Criteria criteria=laboratoryCriteria.createCriteria();
		criteria.andNameLike("%"+laboratoryName+"%");
		PageInfo<Laboratory> pageInfo =laboratoryService.selectListPage(laboratoryCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/lab/list");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/lab/add");


		List<Teacher> teacherList = userService.getAllTeacherList();
		modelAndView.addObject("directorList",teacherList);
		return modelAndView;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@RequestParam String laboratoryName,
					  @RequestParam int theDirector,
					  @RequestParam String laboratoryDescription){
		Laboratory laboratory= new Laboratory();
		laboratory.setName(laboratoryName);
		laboratory.setDirectorId(theDirector);
		laboratory.setDescription(laboratoryDescription);
		laboratoryService.insertLaboratory(laboratory);

		String mdl="redirect:/laboratory/jsp/lab/lab/list";
		return mdl;
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update( @RequestParam int id){
		Laboratory laboratory= laboratoryService.getLaboratoryById(id);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/lab/update");
		List<Teacher> teacherList = userService.getAllTeacherList();
		modelAndView.addObject("directorList",teacherList);
		modelAndView.addObject("laboratoryInfo",laboratory);
		return modelAndView;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam String laboratoryName,
					  @RequestParam int theDirector,
					  @RequestParam String laboratoryDescription){
		Laboratory laboratory= new Laboratory();
		laboratory.setName(laboratoryName);
		laboratory.setDirectorId(theDirector);
		laboratory.setDescription(laboratoryDescription);
		laboratoryService.updateLaboratory(laboratory);

		String mdl="redirect:/laboratory/jsp/lab/lab/list";
		return mdl;
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete( @RequestParam int id){


		LaboratoryRoomCriteria laboratoryRoomCriteria =new LaboratoryRoomCriteria();
		LaboratoryRoomCriteria.Criteria criteria=laboratoryRoomCriteria.createCriteria();
		criteria.andLaboratoryIdEqualTo(id);
		laboratoryRoomServiceService.deleteByCriteria(laboratoryRoomCriteria);
		laboratoryService.deleteById(id);
		String mdl="redirect:/laboratory/jsp/lab/lab/list";
		return mdl;
	}
	@RequestMapping(value = "/roomlist", method = (RequestMethod.GET))
	public ModelAndView roomList(@RequestParam(value = "id", required = true, defaultValue = "1") int id,
								 @RequestParam(value = "page", required = false, defaultValue = "1") int page){

		Laboratory laboratory = laboratoryService.getLaboratoryById(id);

		LaboratoryRoomCriteria laboratoryRoomCriteria=new LaboratoryRoomCriteria();
		LaboratoryRoomCriteria.Criteria criteria=laboratoryRoomCriteria.createCriteria();
		criteria.andLaboratoryIdEqualTo(id);
		PageInfo<LaboratoryRoomKey> pageInfo=laboratoryRoomServiceService.selectListPage(laboratoryRoomCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/lab/roomlist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("laboratoryInfo",laboratory);
		return modelAndView;
	}
	@RequestMapping(value = "/addroom", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addRoom(@RequestParam(value = "laboratoryId", required = true, defaultValue = "1") int laboratoryId,
								@RequestParam(value = "roomName", required = false, defaultValue = "") String roomName,
								@RequestParam(value = "page", required = false, defaultValue = "1") int page){

		Laboratory laboratory = laboratoryService.getLaboratoryById(laboratoryId);
		List<Integer> list=laboratoryRoomServiceService.getAllRoomIdByLaboratoryId(laboratoryId);
		RoomCriteria roomCriteria = new RoomCriteria();
		RoomCriteria.Criteria criteria = roomCriteria.createCriteria();
		criteria.andIdNotIn(list);
		criteria.andNameLike("%"+roomName+"%");
		PageInfo<Room> pageInfo = roomService.selectListPage(roomCriteria ,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/lab/addroom");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("laboratoryInfo",laboratory);
		return modelAndView;
	}
	@RequestMapping(value = "/addtolaboratory", method = {RequestMethod.GET,RequestMethod.POST})
	public String addToLaboratory(@RequestParam(value = "laboratoryId", required = true, defaultValue = "1") int laboratoryId,
										@RequestParam("items") List<Integer> items){


		for(int i:items){
			LaboratoryRoomKey laboratoryRoomKey=new LaboratoryRoomKey();
			laboratoryRoomKey.setLaboratoryRoomId(i);
			laboratoryRoomKey.setLaboratoryId(laboratoryId);
			laboratoryRoomServiceService.insertLaboratoryRoomKey(laboratoryRoomKey);
		}

		return "redirect:/laboratory/jsp/lab/lab/roomlist?id="+laboratoryId+"&page=1";

	}
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public String delete( @RequestParam int roomId,
						  @RequestParam int laboratoryId){
		LaboratoryRoomKey laboratoryRoomKey = new LaboratoryRoomKey();
		laboratoryRoomKey.setLaboratoryId(laboratoryId);
		laboratoryRoomKey.setLaboratoryRoomId(roomId);
		laboratoryRoomServiceService.delete(laboratoryRoomKey);

		return "redirect:/laboratory/jsp/lab/lab/roomlist?id="+laboratoryId+"&page=1";
	}
}

