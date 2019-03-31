package com.lov.mapper;

import com.lovegis.pojo.ForumThread;
import com.lovegis.pojo.ForumThreadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumThreadMapper {
    int countByExample(ForumThreadExample example);

    int deleteByExample(ForumThreadExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(ForumThread record);

    int insertSelective(ForumThread record);

    List<ForumThread> selectByExample(ForumThreadExample example);

    ForumThread selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") ForumThread record, @Param("example") ForumThreadExample example);

    int updateByExample(@Param("record") ForumThread record, @Param("example") ForumThreadExample example);

    int updateByPrimaryKeySelective(ForumThread record);

    int updateByPrimaryKey(ForumThread record);
}