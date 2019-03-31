package com.lov.mapper;

import com.lovegis.pojo.Sourcetwo;
import com.lovegis.pojo.SourcetwoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourcetwoMapper {
    int countByExample(SourcetwoExample example);

    int deleteByExample(SourcetwoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sourcetwo record);

    int insertSelective(Sourcetwo record);

    List<Sourcetwo> selectByExample(SourcetwoExample example);

    Sourcetwo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sourcetwo record, @Param("example") SourcetwoExample example);

    int updateByExample(@Param("record") Sourcetwo record, @Param("example") SourcetwoExample example);

    int updateByPrimaryKeySelective(Sourcetwo record);

    int updateByPrimaryKey(Sourcetwo record);
}