package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.domain.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    int countByCriteria(UserCriteria criteria);

    int deleteByCriteria(UserCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByCriteriaWithRowbounds(UserCriteria criteria, RowBounds rowBounds);

    List<User> selectByCriteria(UserCriteria criteria);

    User selectByPrimaryKey(Integer id);

    User selectUserByLoginSn(String sn);

    int updateByCriteriaSelective(@Param("record") User record, @Param("criteria") UserCriteria criteria);

    int updateByCriteria(@Param("record") User record, @Param("criteria") UserCriteria criteria);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}