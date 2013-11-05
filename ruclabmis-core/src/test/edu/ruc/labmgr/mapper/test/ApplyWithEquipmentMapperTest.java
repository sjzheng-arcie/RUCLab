package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
import edu.ruc.labmgr.service.UserService;
import edu.ruc.labmgr.utils.Types;
import org.apache.ibatis.session.RowBounds;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ApplyWithEquipmentMapperTest {
    private static ApplyWithEquipmentMapper mapper;
    private UserService userService;
    private static ApplicationFormMapper mapperApply;

    @BeforeClass
    public static void getBean() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(ApplyWithEquipmentMapper.class);
        mapperApply = aContext.getBean(ApplicationFormMapper.class);
        System.out.println("getBean");
    }

    @Test
    public void testSelectAll() throws Exception {

        RowBounds bounds = new RowBounds(8, 8);
        List<ApplyWithEquipment> stores = mapper.selectByCriteriaWithRowbounds(null, bounds);

        System.out.println(stores.size());
        for (Equipment each : stores.get(0).getEquipments()) {
            System.out.println(each.getName());
        }

    }

    @Test
    public void testUpdate() throws Exception {
        ApplicationForm form = new ApplicationForm();
        form.setId(89);
        form.setSn("test");
//        form.setProcessTime(new Date());
        form.setStateId(Types.ApplyState.PASS.getValue());
        form.setApproveTime(new Date());

        assert(mapperApply.updateByPrimaryKeySelective(form) > 0 );
    }

    @Ignore
    public void testListAll() throws Exception {
        System.out.println("testListAll");
    }
}
