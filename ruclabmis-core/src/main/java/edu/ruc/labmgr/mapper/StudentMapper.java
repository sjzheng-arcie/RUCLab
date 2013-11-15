package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Student;
import edu.ruc.labmgr.domain.StudentCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StudentMapper {
    int countByCriteria(StudentCriteria example);

    int deleteByCriteria(StudentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByCriteriaWithRowbounds(StudentCriteria example, RowBounds rowBounds);

    List<Student> selectByCriteria(StudentCriteria example);

    Student selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByCriteria(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}