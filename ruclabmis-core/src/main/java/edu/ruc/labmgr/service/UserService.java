package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Teacher;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.StudentMapper;
import edu.ruc.labmgr.mapper.TeacherMapper;
import edu.ruc.labmgr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class UserService {

    @Autowired
    private UserMapper mapperUser;
    @Autowired
    private TeacherMapper mapperTeacher;
    @Autowired
    private StudentMapper mapperStudent;
    @Autowired
    private RoleMapper mapperRole;

    //type 用户类型：0 教师， 1 学生
    public User getUserByLoginSn(String loginSn) {
        User user = null;
        try {
            user = mapperUser.getUserByLoginSn(loginSn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean registeUser(User user) {
        boolean flag = false;
//        try {
//            if (user.getClass() == Teacher.class)
//                mapperTeacher.registeUser((Teacher) user);
//            else if (user.getClass() == Student.class)
//                mapperStudent.registeUser((Student) user);
//            flag = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return flag;
    }


}
