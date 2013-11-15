package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ClassStudent;
import edu.ruc.labmgr.domain.ClassStudentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassStudentMapper {
    int countByExample(ClassStudentCriteria example);

    int deleteByExample(ClassStudentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassStudent record);

    int insertSelective(ClassStudent record);

    List<ClassStudent> selectByExampleWithRowbounds(ClassStudentCriteria example, RowBounds rowBounds);

    List<ClassStudent> selectByExample(ClassStudentCriteria example);

    ClassStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassStudent record, @Param("example") ClassStudentCriteria example);

    int updateByExample(@Param("record") ClassStudent record, @Param("example") ClassStudentCriteria example);

    int updateByPrimaryKeySelective(ClassStudent record);

    int updateByPrimaryKey(ClassStudent record);
}