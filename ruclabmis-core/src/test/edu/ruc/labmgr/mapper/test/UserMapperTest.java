package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import junit.framework.TestCase;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class UserMapperTest extends TestCase {
    UserMapper mapper;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(UserMapper.class);

    }

    @Test
    public void testListPage() throws Exception {
        RowBounds bounds = new RowBounds(0, 10);
        List<User> users = mapper.selectByCriteriaWithRowbounds(null, bounds);
        for (User each : users) {
            System.out.println(each.getName());
        }
    }

    @Test
    public void testSearchPage() throws Exception {
        RowBounds bounds = new RowBounds(0, 10);
        UserCriteria criteria = new UserCriteria();
        criteria.createCriteria().andSnLike("%1%");

        List<User> users = mapper.selectByCriteriaWithRowbounds(criteria, bounds);
        for (User each : users) {
            System.out.println(each.getName());
        }
    }
}
