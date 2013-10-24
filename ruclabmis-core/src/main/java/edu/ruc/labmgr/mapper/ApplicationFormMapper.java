package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplicationFormCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplicationFormMapper {
    int countByCriteria(ApplicationFormCriteria criteria);

    int deleteByCriteria(ApplicationFormCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationForm record);

    int insertSelective(ApplicationForm record);

    List<ApplicationForm> selectByCriteriaWithRowbounds(ApplicationFormCriteria criteria, RowBounds rowBounds);

    List<ApplicationForm> selectByCriteria(ApplicationFormCriteria criteria);

    ApplicationForm selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ApplicationForm record, @Param("criteria") ApplicationFormCriteria criteria);

    int updateByCriteria(@Param("record") ApplicationForm record, @Param("criteria") ApplicationFormCriteria criteria);

    int updateByPrimaryKeySelective(ApplicationForm record);

    int updateByPrimaryKey(ApplicationForm record);
}