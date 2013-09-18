package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.mapper.ClassIfMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClassIfMapperTest extends TestCase {

    @Test
    public void testGetItem() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        ClassIfMapper mapper = aContext.getBean(ClassIfMapper.class);

        System.out.print(mapper.getList().get(0).getValue());
    }
}
