package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.mapper.ClassifMapper;
import edu.ruc.labmgr.mapper.RoleMapper;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClassifMapperTest {

    private static ClassifMapper mapper;

    @BeforeClass
    public static void getBean() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(ClassifMapper.class);
    }

    @Test
    public void testGetItem() throws Exception {
        System.out.println(mapper.selectByPrimaryKey(0).getValue());
    }
}
