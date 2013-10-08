package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.mapper.ClassifMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClassifMapperTest extends TestCase {

    @Test
    public void testGetItem() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        ClassifMapper mapper = aContext.getBean(ClassifMapper.class);

        System.out.println(mapper.selectByPrimaryKey(0).getValue());
    }
}
