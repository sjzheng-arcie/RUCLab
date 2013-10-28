package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Message;
import edu.ruc.labmgr.domain.MessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MessageMapper {
    int countByCriteria(MessageCriteria criteria);

    int deleteByCriteria(MessageCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByCriteriaWithRowbounds(MessageCriteria criteria, RowBounds rowBounds);

    List<Message> selectByCriteria(MessageCriteria criteria);

    Message selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Message record, @Param("criteria") MessageCriteria criteria);

    int updateByCriteria(@Param("record") Message record, @Param("criteria") MessageCriteria criteria);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}