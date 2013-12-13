package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.ApplicationForm;
import edu.ruc.labmgr.domain.ApplyWithEquipment;
import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.mapper.ApplicationFormMapper;
import edu.ruc.labmgr.mapper.ApplyWithEquipmentMapper;
import edu.ruc.labmgr.mapper.EquipmentMapper;
import edu.ruc.labmgr.service.StudentService;
import edu.ruc.labmgr.utils.Types;
import org.apache.ibatis.session.RowBounds;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ApplyWithEquipmentMapperTest {
    private static ApplyWithEquipmentMapper mapper;
    private StudentService teacherService;
    private static ApplicationFormMapper mapperApply;
    private static EquipmentMapper mapperEquipment;

    @BeforeClass
    public static void getBean() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(ApplyWithEquipmentMapper.class);
        mapperApply = aContext.getBean(ApplicationFormMapper.class);
        mapperEquipment = aContext.getBean(EquipmentMapper.class);
        System.out.println("getBean");
    }

    @Ignore
    public void testSelectAll() throws Exception {

        RowBounds bounds = new RowBounds(8, 8);
        List<ApplyWithEquipment> stores = mapper.selectByCriteriaWithRowbounds(null, bounds);

        System.out.println(stores.size());
        for (Equipment each : stores.get(0).getEquipments()) {
            System.out.println(each.getName());
        }

        Equipment equipment = mapperEquipment.selectByPrimaryKey(1);
        System.out.println(equipment.getName());
    }

    @Ignore
    public void testUpdate() throws Exception {
        ApplicationForm form = new ApplicationForm();
        form.setId(89);
        form.setSn("test");
//        form.setProcessTime(new Date());
        form.setStateId(Types.ApplyState.PASS.getValue());
        form.setApproveTime(new Date());

        assert (mapperApply.updateByPrimaryKeySelective(form) > 0);
    }

    @Ignore
    public void testListAll() throws Exception {
        System.out.println("testListAll");
    }
}
