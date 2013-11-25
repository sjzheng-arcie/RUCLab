package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.domain.ClassStudentCriteria;
import edu.ruc.labmgr.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ClassStudentMapper {
    int countByCriteria(ClassStudentCriteria criteria);

    int deleteByCriteria(ClassStudentCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassStudent record);

    int insertSelective(ClassStudent record);

    List<ClassStudent> selectByCriteriaWithRowbounds(ClassStudentCriteria criteria, RowBounds rowBounds);

    List<ClassStudent> selectByCriteria(ClassStudentCriteria criteria);

    List<Student> selectByCriteriaWithStudent(ClassStudentCriteria criteria);

    ClassStudent selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") ClassStudent record, @Param("criteria") ClassStudentCriteria criteria);

    int updateByCriteria(@Param("record") ClassStudent record, @Param("criteria") ClassStudentCriteria criteria);

    int updateByPrimaryKeySelective(ClassStudent record);

    int updateByPrimaryKey(ClassStudent record);
}