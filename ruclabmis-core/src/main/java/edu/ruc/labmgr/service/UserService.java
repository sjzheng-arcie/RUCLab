package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserService {
    @Autowired
    private UserMapper mapperUser;

    public User getUserByLoginSn(String loginSn) {
        return mapperUser.selectUserByLoginSn(loginSn);
    }

    public int getCurrentUserId() {
        Subject currentUser = SecurityUtils.getSubject();
        String userSn = (String) currentUser.getPrincipal();
        User user = mapperUser.selectUserByLoginSn(userSn);
        return user.getId();
    }

    public int getUserIdByName(String name) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria ec = criteria.createCriteria();
        ec.andNameEqualTo(name);
        List<User> teachers = mapperUser.selectByCriteria(criteria);
        if(teachers.size() != 1)
            return -1;

        return teachers.get(0).getId();
    }


    public int getUserIdBySn(String sn) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria ec = criteria.createCriteria();
        ec.andSnEqualTo(sn);
        List<User> teachers = mapperUser.selectByCriteria(criteria);
        if(teachers.size() != 1)
            return -1;

        return teachers.get(0).getId();
    }
}
