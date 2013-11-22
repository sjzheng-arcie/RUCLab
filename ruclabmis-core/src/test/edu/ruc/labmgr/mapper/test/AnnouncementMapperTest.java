package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.mapper.AnnouncementMapper;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AnnouncementMapperTest {
    private static AnnouncementMapper mapper;

    @Ignore
    public static void init() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(AnnouncementMapper.class);
    }

    @Ignore
    public void testSearchPage() throws Exception {
        //Announcement announcement = mapper.selectByCriteriaWithRowbounds(0,2);
    }
}
