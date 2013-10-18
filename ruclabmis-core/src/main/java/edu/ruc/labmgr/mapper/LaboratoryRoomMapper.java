package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.LaboratoryRoomCriteria;
import edu.ruc.labmgr.domain.LaboratoryRoomKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LaboratoryRoomMapper {
    int countByCriteria(LaboratoryRoomCriteria criteria);

    int deleteByCriteria(LaboratoryRoomCriteria criteria);

    int deleteByPrimaryKey(LaboratoryRoomKey key);

    int insert(LaboratoryRoomKey record);

    int insertSelective(LaboratoryRoomKey record);

    List<LaboratoryRoomKey> selectByCriteriaWithRowbounds(LaboratoryRoomCriteria criteria, RowBounds rowBounds);

    List<LaboratoryRoomKey> selectByCriteria(LaboratoryRoomCriteria criteria);

    int updateByCriteriaSelective(@Param("record") LaboratoryRoomKey record, @Param("criteria") LaboratoryRoomCriteria criteria);

    int updateByCriteria(@Param("record") LaboratoryRoomKey record, @Param("criteria") LaboratoryRoomCriteria criteria);
}