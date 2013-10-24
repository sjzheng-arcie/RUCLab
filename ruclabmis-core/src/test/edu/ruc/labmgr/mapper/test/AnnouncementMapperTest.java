package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Announcement;
import edu.ruc.labmgr.domain.AnnouncementCriteria;
import edu.ruc.labmgr.mapper.AnnouncementMapper;
import edu.ruc.labmgr.mapper.AnnouncementMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AnnouncementMapperTest {
	private static AnnouncementMapper mapper;

	@BeforeClass
	public static void init() throws Exception {
		ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
		mapper = aContext.getBean(AnnouncementMapper.class);
	}

	@Test
	public void testSearchPage() throws Exception {
		//Announcement announcement = mapper.selectByCriteriaWithRowbounds(0,2);
	}
}
