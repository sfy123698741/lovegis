package com.lov.mapper;

import com.lovegis.pojo.ForumPost;
import com.lovegis.pojo.ForumPostExample;
import com.lovegis.pojo.ForumPostKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumPostMapper {
    int countByExample(ForumPostExample example);

    int deleteByExample(ForumPostExample example);

    int deleteByPrimaryKey(ForumPostKey key);

    int insert(ForumPost record);

    int insertSelective(ForumPost record);

    List<ForumPost> selectByExampleWithBLOBs(ForumPostExample example);

    List<ForumPost> selectByExample(ForumPostExample example);

    ForumPost selectByPrimaryKey(ForumPostKey key);

    int updateByExampleSelective(@Param("record") ForumPost record, @Param("example") ForumPostExample example);

    int updateByExampleWithBLOBs(@Param("record") ForumPost record, @Param("example") ForumPostExample example);

    int updateByExample(@Param("record") ForumPost record, @Param("example") ForumPostExample example);

    int updateByPrimaryKeySelective(ForumPost record);

    int updateByPrimaryKeyWithBLOBs(ForumPost record);

    int updateByPrimaryKey(ForumPost record);
}