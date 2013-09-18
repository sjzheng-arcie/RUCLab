package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.ClassIf;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ClassIfMapper {

    List<ClassIf> getList();

    ClassIf selectByID(Integer id);

    List<ClassIf> selectByParentID(Integer id);

    int deleteByID(Integer id);

    int deleteByParentID(Integer parentId);

    int insert(ClassIf record);

    int updateValueByID(Integer id, String value);
}