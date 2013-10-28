package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class RoleService {
    @Autowired
    private RoleMapper mapperRole;

    public Role selectByPrimaryKey(int id) {
        Role Role = null;
        Role = (Role) mapperRole.selectByPrimaryKey(id);

        return Role;
    }

    public List<Role> listAll() {
        return mapperRole.selectByCriteria(null);
    }
}
