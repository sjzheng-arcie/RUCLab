package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class UserMapperTest {
    private static UserMapper mapper;

    int offset;
    int limit;

    public UserMapperTest(int current, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    @Parameterized.Parameters
    public static Collection dateFeed() {
        return Arrays.asList(new Object[][]{
                {1, 2},
                {100, 3},
                {-10, 2}
        });
    }

    @BeforeClass
    public static void init() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        mapper = aContext.getBean(UserMapper.class);

        User user = new User();
        user.setId(30);
        user.setPassword("1");
        mapper.updateByPrimaryKeySelective(user);
    }

    @Ignore
    public void testSearchPage() throws Exception {
        RowBounds bounds = new RowBounds(offset, limit);
        UserCriteria criteria = new UserCriteria();
        criteria.createCriteria().andSnLike("%a%");
        criteria.createCriteria().andNameLike("%c%");

        List<User> users = mapper.selectByCriteriaWithRowbounds(criteria, bounds);
        System.out.println("=====" + offset + "-" + limit + "===========");
        for (User each : users) {
            System.out.println(each.getName());
            System.out.println(each.getMajorId());
            System.out.println(each.getMajor().getName());
            System.out.println(each.getRole().getId());
            System.out.println(each.getRole().getName());
        }
        System.out.println("============================================");
    }


}
