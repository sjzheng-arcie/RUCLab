package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.ClassIf;
import edu.ruc.labmgr.mapper.ClassIfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ClassIfService {

    @Autowired
    private ClassIfMapper mapper;

    public List<ClassIf> getAllItems() {
        return mapper.getList();
    }

    public ClassIf getClassIfItem(Integer id) {
        return mapper.selectByID(id);
    }


}
