package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Privilege;
import edu.ruc.labmgr.domain.Role;
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
    public void testSelectRoleWithPrivileges() throws Exception {
        Role role = mapper.selectByPrimaryKey(2);
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

    @Test
    public void testQueryList() throws Exception {
        System.out.println("testQueryList");
    }


    @Test
    public void testListAll() throws Exception {
        System.out.println("testListAll");
    }
}
