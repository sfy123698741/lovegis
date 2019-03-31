package com.lov.mapper;

import com.lovegis.pojo.ForumMsg;
import com.lovegis.pojo.ForumMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumMsgMapper {
    int countByExample(ForumMsgExample example);

    int deleteByExample(ForumMsgExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(ForumMsg record);

    int insertSelective(ForumMsg record);

    List<ForumMsg> selectByExample(ForumMsgExample example);

    ForumMsg selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") ForumMsg record, @Param("example") ForumMsgExample example);

    int updateByExample(@Param("record") ForumMsg record, @Param("example") ForumMsgExample example);

    int updateByPrimaryKeySelective(ForumMsg record);

    int updateByPrimaryKey(ForumMsg record);
}