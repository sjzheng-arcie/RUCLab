package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.domain.TeacherCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeacherMapper {
    int countByCriteria(TeacherCriteria criteria);

    int deleteByCriteria(TeacherCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByCriteriaWithRowbounds(TeacherCriteria criteria, RowBounds rowBounds);

    List<Teacher> selectByCriteria(TeacherCriteria criteria);

    Teacher selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Teacher record, @Param("criteria") TeacherCriteria criteria);

    int updateByCriteria(@Param("record") Teacher record, @Param("criteria") TeacherCriteria criteria);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}