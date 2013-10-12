package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.StudentMapper;
import edu.ruc.labmgr.mapper.TeacherMapper;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserService {

    @Autowired
    private UserMapper mapperUser;

    public User getUserByLoginSn(String loginSn) {
        User user = null;
        try {
            UserCriteria criteria;
            user = mapperUser.selectByPrimaryKey(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public ObjectListPage<User> selectUserListPage(int currentPage, UserCriteria criteria) {
        String count = SysUtil.getConfigValue("showCount", "10");

        int limit = Integer.valueOf(count);
        int currentResult = (currentPage-1) * limit;
        int totleCount = mapperUser.countByCriteria(criteria);
        int pageCount = (totleCount % limit == 0)?(totleCount%limit):(1+totleCount/limit);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalResult(totleCount);
        pageInfo.setTotalPage(pageCount);
        pageInfo.setCurrentPage(currentPage);

        RowBounds bounds = new RowBounds(currentResult, limit);
        List<User> users = mapperUser.selectByCriteriaWithRowbounds(criteria,bounds);

        ObjectListPage<User> retVal = new ObjectListPage<User>(pageInfo, users);

        return retVal;
    }

//
//    public ObjectListPage<User> serachUserListPage(int currentPage) {
//        String count = SysUtil.getConfigValue("showCount", "10");
//
//        int limit = Integer.valueOf(count);
//        int currentResult = (currentPage-1) * limit;
//        int totleCount = mapperUser.countByCriteria(null);
//        int pageCount = (totleCount % limit == 0)?(totleCount%limit):(1+totleCount/limit);
//
//        PageInfo pageInfo = new PageInfo();
//        pageInfo.setTotalResult(totleCount);
//        pageInfo.setTotalPage(pageCount);
//        pageInfo.setCurrentPage(currentPage);
//
//        RowBounds bounds = new RowBounds(currentResult, limit);
//
//        UserCriteria criteria = new UserCriteria();
//        criteria.createCriteria().andSnLike("%1%");
//
//        List<User> users = mapperUser.selectByCriteriaWithRowbounds(criteria, bounds);
//
//        ObjectListPage<User> retVal = new ObjectListPage<User>(pageInfo, users);
//
//        return retVal;
//    }

    public int countAllUsers()
    {
        return mapperUser.countByCriteria(null);
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
