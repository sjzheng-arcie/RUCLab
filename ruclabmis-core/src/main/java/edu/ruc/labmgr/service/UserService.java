package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.UserMapper;
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

    public User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser == null) {
            throw (new org.apache.shiro.authz.UnauthenticatedException("未登录系统，请登录后重试"));
        }
        Object userSn = currentUser.getPrincipal();
        if (userSn == null) {
            throw (new org.apache.shiro.authz.UnauthenticatedException("未登录系统，请登录后重试"));
        }
        return mapperUser.selectUserByLoginSn((String)userSn);
    }

    public int getCurrentUserId() {
        return getCurrentUser().getId();
    }

    public int getUserIdByName(String name) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria ec = criteria.createCriteria();
        ec.andNameEqualTo(name);
        List<User> teachers = mapperUser.selectByCriteria(criteria);
        if (teachers.size() != 1)
            return -1;

        return teachers.get(0).getId();
    }


    public int getUserIdBySn(String sn) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria ec = criteria.createCriteria();
        ec.andSnEqualTo(sn);
        List<User> teachers = mapperUser.selectByCriteria(criteria);
        if (teachers.size() != 1)
            return -1;

        return teachers.get(0).getId();
    }
}
