package edu.ruc.labmgr.mapper;

import edu.ruc.labmgr.domain.Message;
import edu.ruc.labmgr.domain.MessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MessageMapper {
    int countByCriteria(MessageCriteria example);

    int deleteByExample(MessageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByCriteriaWithRowbounds(MessageCriteria example, RowBounds rowBounds);

    List<Message> selectByExample(MessageCriteria example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageCriteria example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageCriteria example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}