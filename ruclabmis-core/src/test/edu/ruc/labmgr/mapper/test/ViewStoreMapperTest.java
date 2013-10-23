package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.Privilege;
import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.ViewStore;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.ViewStoreMapper;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class ViewStoreMapperTest {
    private static ViewStoreMapper mapper;

    @BeforeClass
    public static void getBean() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(ViewStoreMapper.class);
        System.out.println("getBean");
    }

    @Test
    public void testSelectAll() throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalResult(10);
        pageInfo.setTotalPage(2);
        pageInfo.setCurrentPage(0);

        RowBounds bounds = new RowBounds(0, 10);
        List<ViewStore> stores = mapper.selectByCriteriaWithRowbounds(null, bounds);

        System.out.println(stores.size());
        for (Equipment each : stores.get(0).getEquipments()) {
            System.out.println(each.getName());
        }

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
