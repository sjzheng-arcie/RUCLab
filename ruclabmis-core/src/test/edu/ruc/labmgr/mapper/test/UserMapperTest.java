package edu.ruc.labmgr.mapper.test;

import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.mapper.UserMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserMapperTest extends TestCase {

    @Test
    public void testGetItem() throws Exception {
        ApplicationContext aContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = aContext.getBean(UserMapper.class);

        User user = mapper.selectUserWithRoles(1);
        System.out.println(user.getName() + "-" + user.getPassword());

        if (user != null && user.getRoles() != null) {
            for (Role each : user.getRoles()) {
                System.out.println(each.getName());
            }
        }
        else{
            assert(false);
        }

    }
}
