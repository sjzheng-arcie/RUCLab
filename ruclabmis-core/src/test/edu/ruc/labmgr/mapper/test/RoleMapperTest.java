package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.mapper.RoleMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleMapperTest extends TestCase {
    RoleMapper mapper;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(RoleMapper.class);

    }

    @Test
    public void testSelectRoleWithUsers() throws Exception {
//        Role role = mapper.selectRoleWithUsers(1);
//        System.out.println(role.getName());

//        if (role != null && role.getUsers() != null) {
//            for (User each : role.getUsers()) {
//                System.out.println(each.getName());
//            }
//        }
//        else{
//            assert(false);
//        }
    }

    @Test
    public void testSelectRoleWithPrivileges() throws Exception {

//        Role role = mapper.selectRoleWithPrivileges(1);
//        System.out.println(role.getName());
//
//        if (role != null && role.getPrivileges() != null) {
//            for (Privilege each : role.getPrivileges()) {
//                System.out.println(each.getName());
//            }
//        }
//        else{
//            assert(false);
//        }
    }

    @Test
    public void testQueryList() throws Exception {

    }


    @Test
    public void testListAll() throws Exception {

    }
}
