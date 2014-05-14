package edu.ruc.labmgr.service;

import com.mysql.jdbc.StringUtils;
import edu.ruc.labmgr.domain.*;
import edu.ruc.labmgr.mapper.StudentMapper;
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
public class StudentService extends UserService {
    @Autowired
    private UserMapper mapperUser;
    @Autowired
    private StudentMapper mapperStudent;

    public Student selectByPrimaryKey(int id) {
        return mapperStudent.selectByPrimaryKey(id);
    }

    public Student getStudentByLoginSn(String loginSn) {
        User user = mapperUser.selectUserByLoginSn(loginSn);
        return mapperStudent.selectByPrimaryKey(user.getId());
    }

    public PageInfo<Student> getPageStudent(int pageNum,String sn,String name,String major){
        StudentCriteria criteria = new StudentCriteria();
        StudentCriteria.Criteria c = criteria.or();
        if (!StringUtils.isNullOrEmpty(sn)){
            c.andStudentSnLike("%"+sn+"%");
        }
        if (!StringUtils.isNullOrEmpty(name)){
            c.andStudentNameLike("%"+name+"%");
        }
        if (!StringUtils.isNullOrEmpty(major)){
            c.andStudentMajorLike("%"+major+"%");
        }
        return getPageStudentByCriteria(pageNum,criteria);
    }
    private PageInfo<Student> getPageStudentByCriteria(int pageNum, StudentCriteria criteria) {
        int totalCount = mapperStudent.countByCriteria(criteria);
        PageInfo<Student> page = new PageInfo<>(totalCount, -1, pageNum);
        List<Student> data = mapperStudent.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(), page.getPageSize()));
        page.setData(data);
        return page;
    }

    public List<Student> getStudentList(StudentCriteria criteria) {
        return mapperStudent.selectByCriteria(criteria);
    }

    public List<Student> getStudentListNameLike(String name) {
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria ecu = userCriteria.createCriteria();
        ecu.andNameLike("%" + name + "%");

        List<User> users = mapperUser.selectByCriteria(userCriteria);
        if (users.size() <= 0)
            return new ArrayList<Student>();

        List<Integer> studentIds = new ArrayList<Integer>();
        for (User user : users) {
            studentIds.add(user.getId());
        }

        StudentCriteria studentCriteriaCriteria = new StudentCriteria();
        studentCriteriaCriteria.setOrderByClause("id");
        StudentCriteria.Criteria ect = studentCriteriaCriteria.createCriteria();
        if(!studentIds.isEmpty())
            ect.andIdIn(studentIds);

        List<Student> students = mapperStudent.selectByCriteria(studentCriteriaCriteria);
        return mapperStudent.selectByCriteria(studentCriteriaCriteria);
    }

    public List<Student> getAllStudentList() {
        return mapperStudent.selectByCriteria(null);
    }


    public void insert(Student student) {
        User user = student;
        user.setPassword(CipherUtil.generatePassword(CipherUtil.DEFAULT_PASSWORD));
        user.setRoleId(Types.Role.STUDENT.getValue());
        mapperUser.insert(user);

        mapperStudent.insert(student);
    }

    public void update(Student student) {
        if (StringUtils.isNullOrEmpty(student.getPassword())) {
            User tmpUser = mapperUser.selectByPrimaryKey(student.getId());
            student.setPassword(tmpUser.getPassword());
        }
        User user = student;
        user.setRoleId(Types.Role.STUDENT.getValue());
        mapperUser.updateByPrimaryKey(user);

        mapperStudent.updateByPrimaryKey(student);
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
        mapperStudent.deleteByPrimaryKey(id);
        mapperUser.deleteByPrimaryKey(id);
    }

    public int countAllStudents() {
        return mapperStudent.countByCriteria(null);
    }

    public void saveOrUpdateStudents(List<Student> students) {
        if (students != null) {
            for (Student student : students) {
                String sn = student.getSn();
                if (StringUtils.isNullOrEmpty(sn))
                    continue;

                User user = mapperUser.selectUserByLoginSn(sn);
                if (user != null) {
                    student.setId(user.getId());
                    mapperUser.updateByPrimaryKey(student);
                    mapperStudent.updateByPrimaryKey(student);
                } else {
                    mapperUser.insert(student);
                    mapperStudent.insert(student);
                }
            }
        }
    }
}
