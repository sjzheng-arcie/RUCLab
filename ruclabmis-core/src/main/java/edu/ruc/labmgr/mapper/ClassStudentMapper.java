package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.domain.ClassStudentCriteria;
import java.util.List;

import edu.ruc.labmgr.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassStudentMapper {
    int countByCriteria(ClassStudentCriteria example);

    int deleteByCriteria(ClassStudentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassStudent record);

    int insertSelective(ClassStudent record);

    List<ClassStudent> selectByCriteriaWithRowbounds(ClassStudentCriteria example, RowBounds rowBounds);

    List<ClassStudent> selectByCriteria(ClassStudentCriteria example);

    List<Student> selectByCriteriaWithStudent(ClassStudentCriteria example);

    ClassStudent selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ClassStudent record, @Param("example") ClassStudentCriteria example);

    int updateByCriteria(@Param("record") ClassStudent record, @Param("example") ClassStudentCriteria example);

    int updateByPrimaryKeySelective(ClassStudent record);

    int updateByPrimaryKey(ClassStudent record);
}