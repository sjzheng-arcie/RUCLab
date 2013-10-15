package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.page.ObjectListPage;
import edu.ruc.labmgr.utils.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserService {

    @Autowired
    private UserMapper mapperUser;

    public User selectByPrimaryKey(int id) {
        User user = null;
        try {
            user = mapperUser.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

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

    public ObjectListPage<User> selectListPage(int currentPage, UserCriteria criteria) {
        ObjectListPage<User> retList = null;
        try{
            String count = SysUtil.getConfigValue("showCount", "10");


            int limit = Integer.valueOf(count);
            int currentResult = (currentPage-1) * limit;
            int totleCount = mapperUser.countByCriteria(criteria);
            int pageCount = (totleCount % limit == 0)?(totleCount/limit):(1+totleCount/limit);

            PageInfo pageInfo = new PageInfo();
            pageInfo.setTotalResult(totleCount);
            pageInfo.setTotalPage(pageCount);
            pageInfo.setCurrentPage(currentPage);

            RowBounds bounds = new RowBounds(currentResult, limit);
            List<User> users = mapperUser.selectByCriteriaWithRowbounds(criteria,bounds);

            retList = new ObjectListPage<User>(pageInfo, users);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;
    }


    public int insert(User user) {
        int result = 0;
        try{
            result = mapperUser.insert(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int update(User user) {
        int result = 0;
        try{
            result = mapperUser.updateByPrimaryKey(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int id) {
        int result = 0;
        try{
            result = mapperUser.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

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
