package edu.ruc.labmgr.service;

import edu.ruc.labmgr.domain.Equipment;
import edu.ruc.labmgr.domain.EquipmentCriteria;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import edu.ruc.labmgr.mapper.UserMapper;
import edu.ruc.labmgr.utils.MD5.CipherUtil;
import edu.ruc.labmgr.utils.SysUtil;
import edu.ruc.labmgr.utils.ValidateCode;
import edu.ruc.labmgr.utils.page.ObjectListPage;
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

    public User selectByPrimaryKey(int id) {
        User user = null;
        user = mapperUser.selectByPrimaryKey(id);

        return user;
    }

    public User getUserByLoginSn(String loginSn) {
        User user = null;
        UserCriteria criteria;
        user = mapperUser.selectUserByLoginSn(loginSn);

        return user;
    }

    public int getCurrentUserId() {
        Subject currentUser = SecurityUtils.getSubject();
        String userSn = (String) currentUser.getPrincipal();
        User userInfo = mapperUser.selectUserByLoginSn(userSn);
        return userInfo.getId();
    }


    public PageInfo<User> selectListPage(String sn,String name, int pageNum){
        UserCriteria criteria = new UserCriteria();
        criteria.setOrderByClause("sn");
        UserCriteria.Criteria ec = criteria.createCriteria();
        if (!StringUtils.isNullOrEmpty(sn))
            ec.andSnLike("%" + sn + "%");
        if (!StringUtils.isNullOrEmpty(name))
            ec.andNameLike("%" + name + "%");

        return getPageUserByCriteria(pageNum,criteria);
    }

    private PageInfo<User> getPageUserByCriteria(int pageNum,UserCriteria criteria){
        int totalCount = mapperUser.countByCriteria(criteria);
        PageInfo<User> page = new PageInfo<>(totalCount,-1,pageNum);
        List<User> data = mapperUser.selectByCriteriaWithRowbounds(criteria,
                new RowBounds(page.getCurrentResult(),page.getPageSize()));
        page.setData(data);
        return page;
    }

    public List<User> getUserList( UserCriteria criteria) {
        List<User> retList = null;
        try {
            retList = mapperUser.selectByCriteria(criteria);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;
    }


    public int insert(User user) {
        int result = 0;
        result = mapperUser.insert(user);

        return result;
    }

    public int update(User user) {
        int result = 0;
        result = mapperUser.updateByPrimaryKeySelective(user);

        return result;
    }

    public int updatePassword(int id, String oriPassword, String newPassword) {
        int result = 0;
        User user = mapperUser.selectByPrimaryKey(id);
        if(!CipherUtil.validatePassword(user.getPassword(), oriPassword)){
            return -1;
        };

        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setPassword(CipherUtil.generatePassword(newPassword));
        result = mapperUser.updateByPrimaryKeySelective(updateUser);

        return result;
    }

    public int delete(int id) {
        int result = 0;
        result = mapperUser.deleteByPrimaryKey(id);

        return result;
    }

    public int countAllUsers() {
        return mapperUser.countByCriteria(null);
    }
}
