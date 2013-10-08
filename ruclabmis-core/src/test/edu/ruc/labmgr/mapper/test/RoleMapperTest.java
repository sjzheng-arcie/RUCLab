package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Privilege;
import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.mapper.RoleMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class RoleMapperTest extends TestCase {

    @Test
    public void testSelectRoleWithUsers() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        RoleMapper mapper = aContext.getBean(RoleMapper.class);

        Role role = mapper.selectRoleWithUsers(1);
        System.out.println(role.getName());

        if (role != null && role.getUsers() != null) {
            for (User each : role.getUsers()) {
                System.out.println(each.getName());
            }
        }
        else{
            assert(false);
        }
    }

    @Test
    public void testSelectRoleWithPrivileges() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        RoleMapper mapper = aContext.getBean(RoleMapper.class);

        Role role = mapper.selectRoleWithPrivileges(1);
        System.out.println(role.getName());

        if (role != null && role.getPrivileges() != null) {
            for (Privilege each : role.getPrivileges()) {
                System.out.println(each.getName());
            }
        }
        else{
            assert(false);
        }
    }
}
