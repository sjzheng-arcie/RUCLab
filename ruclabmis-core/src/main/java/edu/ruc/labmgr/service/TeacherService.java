package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.domain.TeacherCriteria;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.TeacherMapper;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.Types;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class TeacherService extends UserService {
    @Autowired
    private UserMapper mapperUser;
    @Autowired
    private TeacherMapper mapperTeacher;

    public Teacher selectByPrimaryKey(int id) {
        return mapperTeacher.selectByPrimaryKey(id);
    }

    public Teacher getTeacherByLoginSn(String loginSn) {
        User user = mapperUser.selectUserByLoginSn(loginSn);
        return mapperTeacher.selectByPrimaryKey(user.getId());
    }

    public PageInfo<Teacher> selectListPage(String sn, String name, Integer major, Integer org, int pageNum) {
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria ecu = userCriteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ecu.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ecu.andNameLike("%" + name + "%");
        if (major != null && major > 0)
            ecu.andMajorIdEqualTo(major);

        List<User> users = mapperUser.selectByCriteria(userCriteria);
        List<Integer> teacherIds = new ArrayList<Integer>();
        for (User user : users) {
            teacherIds.add(user.getId());
        }

        TeacherCriteria teacherCriteriaCriteria = new TeacherCriteria();
        teacherCriteriaCriteria.setOrderByClause("id");
        TeacherCriteria.Criteria ect = teacherCriteriaCriteria.createCriteria();
		if(teacherIds.size()>0)
			ect.andIdIn(teacherIds);
		else{
			int totalCount = 0;
			PageInfo<Teacher> page = new PageInfo<>(0, -1, pageNum);
			List<Teacher> data = new ArrayList<>();
			page.setData(data);
			return  page;
		}
        if (org != null && org >= 0)
            ect.andOrganizationIdEqualTo(org);

        return getPageTeacherByCriteria(pageNum, teacherCriteriaCriteria);
    }

    private PageInfo<Teacher> getPageTeacherByCriteria(int pageNum, TeacherCriteria criteria) {
			int totalCount = mapperTeacher.countByCriteria(criteria);
		PageInfo<Teacher> page = new PageInfo<>(totalCount, -1, pageNum);
		List<Teacher> data = mapperTeacher.selectByCriteriaWithRowbounds(criteria,
				new RowBounds(page.getCurrentResult(), page.getPageSize()));
		page.setData(data);
        return page;
    }

    public List<Teacher> getTeacherList(TeacherCriteria criteria) {
        return mapperTeacher.selectByCriteria(criteria);
    }

    public List<Teacher> getTeacherListNameLike(String name) {
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria ecu = userCriteria.createCriteria();
        ecu.andNameLike("%" + name + "%");

        List<User> users = mapperUser.selectByCriteria(userCriteria);
        if (users.size() <= 0)
            return new ArrayList<Teacher>();

        List<Integer> teacherIds = new ArrayList<Integer>();
        for (User user : users) {
            teacherIds.add(user.getId());
        }

        TeacherCriteria teacherCriteriaCriteria = new TeacherCriteria();
        teacherCriteriaCriteria.setOrderByClause("id");
        TeacherCriteria.Criteria ect = teacherCriteriaCriteria.createCriteria();
        if(!teacherIds.isEmpty())
            ect.andIdIn(teacherIds);

        List<Teacher> teachers = mapperTeacher.selectByCriteria(teacherCriteriaCriteria);
        return mapperTeacher.selectByCriteria(teacherCriteriaCriteria);
    }

    public List<Teacher> getAllTeacherList() {
        return mapperTeacher.selectByCriteria(null);
    }

    public List<Teacher> getRoleTeacherList(Types.Role role) {
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria ecu = userCriteria.createCriteria();
        ecu.andRoleIdEqualTo(role.getValue());

        List<User> users = mapperUser.selectByCriteria(userCriteria);
        if (users.size() <= 0)
            return new ArrayList<Teacher>();

        List<Integer> teacherIds = new ArrayList<Integer>();
        for (User user : users) {
            teacherIds.add(user.getId());
        }

        TeacherCriteria teacherCriteriaCriteria = new TeacherCriteria();
        teacherCriteriaCriteria.setOrderByClause("id");
        TeacherCriteria.Criteria ect = teacherCriteriaCriteria.createCriteria();
        if(!teacherIds.isEmpty())
            ect.andIdIn(teacherIds);

        return mapperTeacher.selectByCriteria(teacherCriteriaCriteria);
    }

    public void insert(Teacher teacher) {
        User user = teacher;
        user.setPassword(CipherUtil.generatePassword(user.getPassword()));
        mapperUser.insert(user);
        teacher.setId(user.getId());
        mapperTeacher.insert(teacher);
    }

    public void update(Teacher teacher) {
        if (StringUtils.isNullOrEmpty(teacher.getPassword())) {
            User tmpUser = mapperUser.selectByPrimaryKey(teacher.getId());
            teacher.setPassword(tmpUser.getPassword());
        }
        User user = teacher;
        mapperUser.updateByPrimaryKey(user);

        mapperTeacher.updateByPrimaryKey(teacher);
    }

    public void updatePassword(int id, String oriPassword, String newPassword) throws Exception {
        User user = mapperUser.selectByPrimaryKey(id);
        //没有管理员权限则需要验证当前密码
        Subject subject = SecurityUtils.getSubject();
        if (!subject.hasRole(Types.Role.ADMIN.getName())) {
            if (!CipherUtil.validatePassword(user.getPassword(), oriPassword)) {
                throw (new Exception("用户原密码不匹配，请重新输入"));
            }
        }

        user.setPassword(CipherUtil.generatePassword(newPassword));
        mapperUser.updateByPrimaryKey(user);
    }

    public void delete(int id) {
        mapperTeacher.deleteByPrimaryKey(id);
        mapperUser.deleteByPrimaryKey(id);
    }

    public int countAllTeachers() {
        return mapperTeacher.countByCriteria(null);
    }


    public void saveOrUpdateTeachers(List<Teacher> teachers) {
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                String sn = teacher.getSn();
                if (StringUtils.isNullOrEmpty(sn))
                    continue;

                User user = mapperUser.selectUserByLoginSn(sn);
                if (user != null) {
                    teacher.setId(user.getId());
                    mapperUser.updateByPrimaryKey(teacher);
                    mapperTeacher.updateByPrimaryKey(teacher);
                } else {
                    mapperUser.insert(teacher);
                    mapperTeacher.insert(teacher);
                }
            }
        }
    }

}
