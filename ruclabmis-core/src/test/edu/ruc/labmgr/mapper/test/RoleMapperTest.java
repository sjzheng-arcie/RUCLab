package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.mapper.RoleMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class RoleMapperTest {
    private static RoleMapper mapper;

    @BeforeClass
    public static void getBean() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(RoleMapper.class);
        System.out.println("getBean");
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

        System.out.println("testQueryList");
    }


    @Test
    public void testListAll() throws Exception {
        System.out.println("testListAll");
    }
}
