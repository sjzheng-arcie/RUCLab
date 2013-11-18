package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Classif;
import edu.ruc.labmgr.domain.ClassifCriteria;
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

    public Classif getClassifItem(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public Integer getIdByName(String name) {
        ClassifCriteria criteria = new  ClassifCriteria();
        ClassifCriteria.Criteria ec =  criteria.createCriteria();
        ec.andValueEqualTo(name);
        List<Classif> codes = mapper.selectByCriteria(criteria);
        if(codes.size() > 0)
            return codes.get(0).getId();
        else
            return null;
    }

    public List<Classif> getItemsByParentID(int parent_id) {
        ClassifCriteria classifCriteria = new ClassifCriteria();
        ClassifCriteria.Criteria criteria = classifCriteria.createCriteria();
        criteria.andParentIdEqualTo(parent_id);
        return mapper.selectByCriteria(classifCriteria);
    }
}
