package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.mapper.ClassifMapper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("ALL")
@Service
public class ClassifService {

    @Autowired
    private ClassifMapper mapper;

    @RequiresRoles("administrators")
    public Classif getClassifItem(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @RequiresRoles("administrators")
    public List<Classif> getItemsByParentID(int parent_id) {
        return mapper.selectByParentKey(parent_id);
    }
}
