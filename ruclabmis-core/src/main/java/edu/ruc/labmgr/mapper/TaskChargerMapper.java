package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.TaskCharger;
import edu.ruc.labmgr.domain.TaskChargerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskChargerMapper {
    int countByExample(TaskChargerCriteria example);

    int deleteByExample(TaskChargerCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskCharger record);

    int insertSelective(TaskCharger record);

    List<TaskCharger> selectByExampleWithRowbounds(TaskChargerCriteria example, RowBounds rowBounds);

    List<TaskCharger> selectByExample(TaskChargerCriteria example);

    TaskCharger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskCharger record, @Param("example") TaskChargerCriteria example);

    int updateByExample(@Param("record") TaskCharger record, @Param("example") TaskChargerCriteria example);

    int updateByPrimaryKeySelective(TaskCharger record);

    int updateByPrimaryKey(TaskCharger record);
	int countTaskChargerList(@Param("taskName") String taskName,
							 @Param("chargerId") int chargerId,
							 @Param("type") int type,
							 @Param("ifCompleted") int ifCompleted,
							 @Param("ifScored") int ifScored);
	List<TaskCharger> selectTaskChargerList(@Param("taskName") String taskName,
											@Param("chargerId") int chargerId,
											@Param("type") int type,
											@Param("ifCompleted") int ifCompleted,
											@Param("ifScored") int ifScored,
											RowBounds rowBounds);
}