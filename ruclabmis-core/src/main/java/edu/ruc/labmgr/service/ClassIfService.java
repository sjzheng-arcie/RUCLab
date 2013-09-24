package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.mapper.ClassifMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ClassIfService {

    @Autowired
    private ClassifMapper mapper;

    public List<Classif> getAllItems() {
                return mapper.selectByParentKey(0);
    }

    public Classif getClassifItem(Integer id) {
        return null;
    }


}
