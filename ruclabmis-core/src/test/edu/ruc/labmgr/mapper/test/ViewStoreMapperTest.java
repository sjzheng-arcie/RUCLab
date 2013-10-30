package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.ViewStoreMapper;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Consts;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ViewStoreMapperTest {
    private static ViewStoreMapper mapper;
    private UserService userService;
    private ApplicationFormMapper mapperApply;

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

    @Test
    public void testUpdate() throws Exception {
        ApplicationForm form = new ApplicationForm();
        form.setApplicantId(16);
        form.setProcessTime(new Date());
        form.setStateId(Consts.APPLY_STATE_PASS);

        form.setApproverId(userService.getCurrentUserId());

        assert(mapperApply.updateByPrimaryKeySelective(form) > 0 );
    }

    @Ignore
    public void testListAll() throws Exception {
        System.out.println("testListAll");
    }
}
