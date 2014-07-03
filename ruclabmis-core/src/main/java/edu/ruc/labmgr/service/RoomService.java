package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.CurriculumScheduleCriteria;
import edu.ruc.labmgr.domain.LaboratoryRoomCriteria;
import edu.ruc.labmgr.domain.Room;
import edu.ruc.labmgr.domain.RoomCriteria;
import edu.ruc.labmgr.mapper.CurriculumScheduleMapper;
import edu.ruc.labmgr.mapper.LaboratoryRoomMapper;
import edu.ruc.labmgr.mapper.RoomMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("ALL")
@Service
public class RoomService {

    @Autowired
    private RoomMapper mapper;
	@Autowired
	CurriculumScheduleService curriculumScheduleService;
	@Autowired
	LaboratoryRoomService laboratoryRoomService;

   	public Room getRoomById(int id){
		Room room= mapper.selectByPrimaryKey(id);
		return room;
	}
	public boolean ifNameExisted(String roomName){
		RoomCriteria  roomCriteria= new RoomCriteria();
		RoomCriteria.Criteria criteria= roomCriteria.createCriteria();
		criteria.andNameEqualTo(roomName);
		List<Room> roomList= mapper.selectByCriteria(roomCriteria);
		if(roomList!=null&&roomList.size()>0){
			return true;
		}else{
			return false;
		}
	}

	public void insertRoom(Room room){
		mapper.insert(room);
	}
	public void updateRoom(Room room){
		mapper.updateByPrimaryKey(room);
	}
	public void deleteById(int id){
		LaboratoryRoomCriteria laboratoryRoomCriteria = new LaboratoryRoomCriteria();
		LaboratoryRoomCriteria.Criteria criteria= laboratoryRoomCriteria.createCriteria();
		criteria.andLaboratoryRoomIdEqualTo(id);
		laboratoryRoomService.deleteByCriteria(laboratoryRoomCriteria);

		CurriculumScheduleCriteria curriculumScheduleCriteria= new CurriculumScheduleCriteria();
		CurriculumScheduleCriteria.Criteria criteria1= curriculumScheduleCriteria.createCriteria();
		criteria1.andRoomIdEqualTo(id);
		curriculumScheduleService.deleteByCriteria(curriculumScheduleCriteria);

		mapper.deleteByPrimaryKey(id);
	}
	public PageInfo<Room> selectListPage(RoomCriteria criteria, int pageNum) {
		int totalCount = mapper.countByCriteria(criteria);
		PageInfo<Room> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Room> data = mapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
		return page;
	}
	public List<Room> getAllRoomListByIdList(List<Integer> roomIdList){
		RoomCriteria roomCriteria= new RoomCriteria();
		RoomCriteria.Criteria criteria= roomCriteria.createCriteria();
		//criteria.andTypeEqualTo(true);
		if(roomIdList.size()!=0){
			criteria.andIdNotIn(roomIdList);
		}
		return mapper.selectByCriteria(roomCriteria);
	}
	public List<Room> getAllRoomList(){
        RoomCriteria roomCriteria= new RoomCriteria();
        roomCriteria.setOrderByClause("id, type, name");
		return mapper.selectByCriteria(roomCriteria);
	}
	public List<Room> getAllRoomListByCriteria(RoomCriteria roomCriteria){
		roomCriteria.setOrderByClause("id, type, name");
		return mapper.selectByCriteria(roomCriteria);
	}
}
