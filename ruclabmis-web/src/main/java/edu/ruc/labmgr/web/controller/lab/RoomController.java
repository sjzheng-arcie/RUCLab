package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.service.CurriculumScheduleService;
import edu.ruc.labmgr.service.DeskService;
import edu.ruc.labmgr.service.LaboratoryRoomService;
import edu.ruc.labmgr.service.RoomService;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * User: jlding
 * Date: 13-12-16
 * Time: 下午3:55
 * Des:
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/lab/house")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private DeskService deskService;
	@Autowired
	private LaboratoryRoomService laboratoryRoomService;
	@Autowired
	CurriculumScheduleService curriculumScheduleService;


	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(@RequestParam(required = false,defaultValue = "") String roomName,
							 @RequestParam(value="roomType" ,required = false,defaultValue = "3") int  roomTypeNum,
							 @RequestParam(value = "page", required = false, defaultValue = "1") int page){
		RoomCriteria roomCriteria=new RoomCriteria();
		RoomCriteria.Criteria criteria=roomCriteria.createCriteria();
		criteria.andNameLike("%"+roomName+"%");
		if(roomTypeNum==0){
			criteria.andTypeEqualTo(false);
		}
		if(roomTypeNum==1){
			criteria.andTypeEqualTo(true);
		}
		PageInfo<Room> pageInfo =roomService.selectListPage(roomCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/house/list");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value="/toadd",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/house/add");
		return modelAndView;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@RequestParam String roomName,
							@RequestParam boolean roomType,
							@RequestParam String roomDescription){
		Room room = new Room();
		room.setType(roomType);
		room.setDescription(roomDescription);
		room.setName(roomName);

		roomService.insertRoom(room);
		String mdl="redirect:/laboratory/jsp/lab/house/list";
		return mdl;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam int[] items){
		for(int id:items){
//			LaboratoryRoomCriteria laboratoryRoomCriteria = new LaboratoryRoomCriteria();
//			LaboratoryRoomCriteria.Criteria criteria= laboratoryRoomCriteria.createCriteria();
//			criteria.andLaboratoryRoomIdEqualTo(id);
//
//
//			laboratoryRoomService.deleteByCriteria(laboratoryRoomCriteria);
			roomService.deleteById(id);
		}
		String mdl="redirect:/laboratory/jsp/lab/house/list";
		return mdl;
	}
	@RequestMapping(value="/todelete",method=RequestMethod.GET)
	public String todelete(@RequestParam int id){



		roomService.deleteById(id);
		String mdl="redirect:/laboratory/jsp/lab/house/list";
		return mdl;
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update(@RequestParam int id){
		Room room=roomService.getRoomById(id);
		ModelAndView mdl=new ModelAndView("/laboratory/jsp/lab/house/update");
		mdl.addObject("roomInfo",room);
		return mdl;
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam int roomId,
						 @RequestParam String roomName,
						 @RequestParam boolean roomType,
						 @RequestParam String roomDescription){
		Room room = new Room();
		room.setId(roomId);
		room.setType(roomType);
		room.setDescription(roomDescription);
		room.setName(roomName);
		roomService.updateRoom(room);
		String mdl="redirect:/laboratory/jsp/lab/house/list";
		return mdl;
	}


}
