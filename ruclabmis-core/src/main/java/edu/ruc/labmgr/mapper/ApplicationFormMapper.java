package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplicationFormCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplicationFormMapper {
    int countByExample(ApplicationFormCriteria example);

    int deleteByExample(ApplicationFormCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationForm record);

    int insertSelective(ApplicationForm record);

    List<ApplicationForm> selectByExampleWithRowbounds(ApplicationFormCriteria example, RowBounds rowBounds);

    List<ApplicationForm> selectByExample(ApplicationFormCriteria example);

    ApplicationForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicationForm record, @Param("example") ApplicationFormCriteria example);

    int updateByExample(@Param("record") ApplicationForm record, @Param("example") ApplicationFormCriteria example);

    int updateByPrimaryKeySelective(ApplicationForm record);

    int updateByPrimaryKey(ApplicationForm record);
}