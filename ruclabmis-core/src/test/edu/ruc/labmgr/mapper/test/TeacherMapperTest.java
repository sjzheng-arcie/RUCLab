package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Privilege;
import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.TeacherMapper;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TeacherMapperTest {
    private static TeacherMapper mapper;

    @BeforeClass
    public static void getBean() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(TeacherMapper.class);
        System.out.println("getBean");
    }

    @Test
    public void testSelectTeacher() throws Exception {
        Teacher teacher = mapper.selectByPrimaryKey(1);
        System.out.println(teacher.getUser().getName());
    }

    @Ignore
    public void testQueryList() throws Exception {
        System.out.println("testQueryList");
    }


    @Ignore
    public void testListAll() throws Exception {
        System.out.println("testListAll");
    }
}
