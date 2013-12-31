package edu.ruc.labmgr.web.controller.lab;

import edu.ruc.labmgr.domain.Desk;
import edu.ruc.labmgr.domain.DeskCriteria;
import edu.ruc.labmgr.domain.Laboratory;
import edu.ruc.labmgr.domain.Room;
import edu.ruc.labmgr.service.DeskService;
import edu.ruc.labmgr.service.LaboratoryService;
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
 * Created with IntelliJ IDEA.
 * User: jinlytin
 * Date: 13-12-18
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/laboratory/jsp/lab/desk")
public class DeskController {
	@Autowired
	private DeskService deskService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private LaboratoryService laboratoryService;


	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	 public ModelAndView list(@RequestParam(required = false,defaultValue = "") String deskName,
							  @RequestParam(value = "page", required = false, defaultValue = "1") int page){
		DeskCriteria roomCriteria=new DeskCriteria();
		DeskCriteria.Criteria criteria=roomCriteria.createCriteria();
		criteria.andNameLike("%"+deskName+"%");

		PageInfo<Desk> pageInfo =deskService.selectListPage(roomCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/list");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value = "/getlist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getList(@RequestParam(required = false,defaultValue = "") int laboratoryRoomId,
							 @RequestParam(value = "page", required = false, defaultValue = "1") int page){
		DeskCriteria roomCriteria=new DeskCriteria();
		DeskCriteria.Criteria criteria=roomCriteria.createCriteria();
		criteria.andLaboratoryRoomIdEqualTo(laboratoryRoomId);

		PageInfo<Desk> pageInfo =deskService.selectListPage(roomCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/list");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	@RequestMapping(value="/toadd",method=RequestMethod.GET)
	public ModelAndView add(@RequestParam int roomId
	//						,@RequestParam(value = "laboratoryId", required = true, defaultValue = "1") int laboratoryId
	){
		Room room =roomService.getRoomById(roomId);
		//Laboratory laboratory =laboratoryService.getLaboratoryById(laboratoryId);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/add");
		//modelAndView.addObject("laboratoryInfo",laboratory);
		modelAndView.addObject("roomInfo",room);
		return modelAndView;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@RequestParam String deskName,
					  @RequestParam int roomId,
					  @RequestParam String deskDescription){
		Desk desk= new Desk();
		desk.setName(deskName);
		desk.setLaboratoryRoomId(roomId);
		desk.setDescription(deskDescription);
		deskService.insertDesk(desk);

		String mdl="redirect:/laboratory/jsp/lab/desk/desklist?page0&roomId="+roomId;
		return mdl;
	}
	@RequestMapping(value="/toupdate",method=RequestMethod.GET)
	public ModelAndView update(@RequestParam int id,
	//						   @RequestParam(value = "laboratoryId", required = true, defaultValue = "1") int laboratoryId,
							   @RequestParam int roomId){
		Room room =roomService.getRoomById(roomId);
		Desk desk= deskService.getDeskById(id);
	//	Laboratory laboratory =laboratoryService.getLaboratoryById(laboratoryId);

		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/toupdate");
		modelAndView.addObject("deskInfo",desk);
	//	modelAndView.addObject("laboratoryInfo",laboratory);
		modelAndView.addObject("roomInfo",room);
		return modelAndView;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam String deskName,
					  @RequestParam int roomId,
					  @RequestParam int deskId,
					  @RequestParam String deskDescription){
		Desk desk= new Desk();
		desk.setId(deskId);
		desk.setName(deskName);
		desk.setLaboratoryRoomId(roomId);
		desk.setDescription(deskDescription);
		deskService.updateDesk(desk);

		String mdl="redirect:/laboratory/jsp/lab/desk/desklist?roomId";
		return mdl;
	}
	@RequestMapping(value = "/desklist", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomList(@RequestParam(value = "roomId", required = true, defaultValue = "1") int roomId,
								 @RequestParam(value = "houseListPage", required = false, defaultValue = "1") int houseListPage,
								 @RequestParam(value = "page", required = false, defaultValue = "1") int page){

		Room room= roomService.getRoomById(roomId);

		DeskCriteria deskCriteria=new DeskCriteria();
		DeskCriteria.Criteria criteria=deskCriteria.createCriteria();
		criteria.andLaboratoryRoomIdEqualTo(roomId);

		PageInfo<Desk> pageInfo=deskService.selectListPage(deskCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/desklist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("roomInfo",room);
		modelAndView.addObject("houseListPage",houseListPage);
		return modelAndView;
	}
	@RequestMapping(value = "/checkdesklist", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView checkdesklist(@RequestParam(value = "roomId", required = true, defaultValue = "1") int roomId,
								 @RequestParam(value = "laboratoryId", required = true, defaultValue = "1") int laboratoryId,
								 @RequestParam(value = "page", required = false, defaultValue = "1") int page){

		Room room= roomService.getRoomById(roomId);
		Laboratory laboratory =laboratoryService.getLaboratoryById(laboratoryId);

		DeskCriteria deskCriteria=new DeskCriteria();
		DeskCriteria.Criteria criteria=deskCriteria.createCriteria();
		criteria.andLaboratoryRoomIdEqualTo(roomId);

		PageInfo<Desk> pageInfo=deskService.selectListPage(deskCriteria,page);
		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/checkdesklist");
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("roomInfo",room);
		modelAndView.addObject("laboratoryInfo",laboratory);
		return modelAndView;
	}
//	@RequestMapping(value = "/adddesk", method = (RequestMethod.GET))
//	public ModelAndView addDesk(@RequestParam(value = "roomId", required = true, defaultValue = "1") int roomId,
//								@RequestParam(value = "deskName", required = false, defaultValue = "") String deskName,
//								@RequestParam(value = "page", required = false, defaultValue = "1") int page){
//
//		Room room= roomService.getRoomById(roomId);
//
//
//		DeskCriteria deskCriteria=new DeskCriteria();
//		DeskCriteria.Criteria criteria=deskCriteria.createCriteria();
//		criteria.andNameLike("%"+deskName+"%");
//		PageInfo<Desk> pageInfo=deskService.selectListPage(deskCriteria,page);
//		ModelAndView modelAndView= new ModelAndView("/laboratory/jsp/lab/desk/adddesk");
//		modelAndView.addObject("pageInfo",pageInfo);
//		modelAndView.addObject("roomInfo",room);
//		return modelAndView;
//	}
//	@RequestMapping(value = "/addtodesk", method = {RequestMethod.GET,RequestMethod.POST})
//	public String addToRoom(@RequestParam(value = "roomId", required = true, defaultValue = "1") int id,
//							@RequestParam("items") List<Integer> items){
//
//
//		for(int i=0;i<items.size();i++){
//			Desk desk=new Desk();
//			desk.setId(items.get(i));
//			desk.setLaboratoryRoomId(id);
//			deskService.insertDesk(desk);
//		}
//
//		return "redirect:/laboratory/jsp/lab/desk/desklist?roomId="+id+"&page=0";
//
//	}
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public String delete( @RequestParam int deskId){

		int tempId=deskService.getDeskById(deskId).getLaboratoryRoomId();
		deskService.deleteById(deskId);

		return "redirect:/laboratory/jsp/lab/desk/desklist?roomId="+tempId+"&page=0";
	}
	@RequestMapping(value="/delete",method={RequestMethod.GET,RequestMethod.POST})
	public String toDelete( @RequestParam("items") List<Integer> items){

		int tempId=deskService.getDeskById(items.get(0)).getLaboratoryRoomId();
		for(int i=0;i<items.size();i++){
			deskService.deleteById(items.get(i));
		}
		return "redirect:/laboratory/jsp/lab/desk/desklist?roomId="+tempId+"&page=0";
	}
}
