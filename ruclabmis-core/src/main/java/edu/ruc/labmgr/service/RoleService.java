package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.annotations.Param;
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
        try {
            Role = (Role) mapperRole.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Role;
    }

    public List<Role> listAll() {
        return mapperRole.selectByCriteria(null);
    }
}
