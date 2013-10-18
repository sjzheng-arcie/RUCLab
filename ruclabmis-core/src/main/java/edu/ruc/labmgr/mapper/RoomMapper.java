package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Room;
import edu.ruc.labmgr.domain.RoomCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoomMapper {
    int countByCriteria(RoomCriteria criteria);

    int deleteByCriteria(RoomCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByCriteriaWithRowbounds(RoomCriteria criteria, RowBounds rowBounds);

    List<Room> selectByCriteria(RoomCriteria criteria);

    Room selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Room record, @Param("criteria") RoomCriteria criteria);

    int updateByCriteria(@Param("record") Room record, @Param("criteria") RoomCriteria criteria);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}