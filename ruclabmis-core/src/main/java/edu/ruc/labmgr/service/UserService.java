package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.Types;
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

    public Integer getUserIdByName(String name) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria ec = criteria.createCriteria();
        ec.andNameEqualTo(name);
        List<User> teachers = mapperUser.selectByCriteria(criteria);
        if (teachers.size() != 1)
            return null;

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
	public String getUserNamebyId(int id){
		User user = mapperUser.selectByPrimaryKey(id);
		if (user==null)
			return "";
		return user.getName();
	}
	public String getUserSnbyId(int id){
		User user = mapperUser.selectByPrimaryKey(id);
		if (user==null)
			return "";
		return user.getSn();
	}
	public List<User> getAllUserList(){
		return mapperUser.selectByCriteria(null);
	}
	public Types.Role getCurrentUserRole(){
		String rolename = getCurrentUser().getRole().getName();
		Types.Role role = null;
		if(rolename.equals(Types.Role.ADMIN.getName()))
			role = Types.Role.ADMIN;
		else if(rolename.equals(Types.Role.TEACHER.getName()))
			role = Types.Role.TEACHER;
		else if(rolename.equals(Types.Role.STUDENT.getName()))
			role = Types.Role.STUDENT;
		else if(rolename.equals(Types.Role.LAB_ADMIN.getName()))
			role = Types.Role.LAB_ADMIN;
		else if(rolename.equals(Types.Role.EQUIPMENT_ADMIN.getName()))
			role = Types.Role.EQUIPMENT_ADMIN;
		else if(rolename.equals(Types.Role.LEADER.getName()))
			role = Types.Role.LEADER;
		return  role;
	}
}
