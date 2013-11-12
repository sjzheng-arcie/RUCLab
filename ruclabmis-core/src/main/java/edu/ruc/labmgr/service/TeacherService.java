package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.TeacherMapper;
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

    public PageInfo<Teacher> selectListPage(String sn,String name, int pageNum){
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria ecu = userCriteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ecu.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ecu.andNameLike("%" + name + "%");
        List<User> users = mapperUser.selectByCriteria(userCriteria);
        List<Integer> teacherIds = new ArrayList<Integer>();
        for(User user : users){
            teacherIds.add(user.getId());
        }

        TeacherCriteria teacherCriteriaCriteria = new TeacherCriteria();
        teacherCriteriaCriteria.setOrderByClause("id");
        TeacherCriteria.Criteria ect = teacherCriteriaCriteria.createCriteria();
        ect.andIdIn(teacherIds);

        return getPageTeacherByCriteria(pageNum, teacherCriteriaCriteria);
    }

    private PageInfo<Teacher> getPageTeacherByCriteria(int pageNum,TeacherCriteria criteria){
        int totalCount = mapperTeacher.countByCriteria(criteria);
        PageInfo<Teacher> page = new PageInfo<>(totalCount,-1,pageNum);
        List<Teacher> data = mapperTeacher.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    public List<Teacher> getTeacherList(TeacherCriteria criteria) {
        return mapperTeacher.selectByCriteria(criteria);
    }

    public List<Teacher> getAllTeacherList() {
        return mapperTeacher.selectByCriteria(null);
    }

    public List<Teacher> getRoleTeacherList(Types.Role role) {
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria ecu = userCriteria.createCriteria();
        ecu.andRoleIdEqualTo(role.getValue());

        List<User> users = mapperUser.selectByCriteria(userCriteria);
        List<Integer> teacherIds = new ArrayList<Integer>();
        for(User user : users){
            teacherIds.add(user.getId());
        }

        TeacherCriteria teacherCriteriaCriteria = new TeacherCriteria();
        teacherCriteriaCriteria.setOrderByClause("id");
        TeacherCriteria.Criteria ect = teacherCriteriaCriteria.createCriteria();
        ect.andIdIn(teacherIds);

        return mapperTeacher.selectByCriteria(teacherCriteriaCriteria);
    }

    public void insert(Teacher teacher) {
        teacher.getUser().setPassword(CipherUtil.generatePassword(teacher.getUser().getPassword()));
        mapperUser.insert(teacher.getUser());
        teacher.setId(teacher.getUser().getId());
        mapperTeacher.insert(teacher);
    }

    public void update(Teacher teacher) {
        if(StringUtils.isNullOrEmpty(teacher.getUser().getPassword())){
            Teacher tmpTeacher = mapperTeacher.selectByPrimaryKey(teacher.getId());
            teacher.getUser().setPassword(tmpTeacher.getUser().getPassword());
        }
        mapperUser.updateByPrimaryKey(teacher.getUser());
        mapperTeacher.updateByPrimaryKey(teacher);
    }

    public void updatePassword(int id, String oriPassword, String newPassword) {

        Teacher teacher = mapperTeacher.selectByPrimaryKey(id);
        if(!CipherUtil.validatePassword(teacher.getUser().getPassword(), oriPassword)){
            return;
        };

        teacher.getUser().setPassword(CipherUtil.generatePassword(newPassword));
        mapperTeacher.updateByPrimaryKey(teacher);

    }

    public void delete(int id) {
        mapperUser.deleteByPrimaryKey(id);
        mapperTeacher.deleteByPrimaryKey(id);
    }

    public int countAllTeachers() {
        return mapperTeacher.countByCriteria(null);
    }
}
