package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Room;
import edu.ruc.labmgr.domain.RoomCriteria;
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

   	public Room getRoomById(int id){
		Room room= mapper.selectByPrimaryKey(id);
		return room;
	}
	public List<Room> getRoomListByCriteria(RoomCriteria criteria){
		List<Room> roomList=mapper.selectByCriteria(criteria);
		return roomList;
	}
	public PageInfo<Room> getPageRoomByCriteria(int pageNum, RoomCriteria criteria) {
		int totalCount = mapper.countByCriteria(criteria);
		PageInfo<Room> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Room> data = mapper.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));

		page.setData(data);
		return page;
	}

	public void insertRoom(Room room){
		mapper.insert(room);
	}
	public void updateRoom(Room room){
		mapper.updateByPrimaryKey(room);
	}
	public void deleteById(int id){
		mapper.deleteByPrimaryKey(id);
	}
}
