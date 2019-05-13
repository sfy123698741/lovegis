package com.lov.mapper;

import com.lovegis.pojo.SourceOne;
import com.lovegis.pojo.SourceOne;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceoneMapper {
    int countByExample(SourceoneExample example);

    int deleteByExample(SourceoneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SourceOne record);

    int insertSelective(SourceOne record);

    List<SourceOne> selectByExample(SourceoneExample example);

    SourceOne selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SourceOne record, @Param("example") SourceoneExample example);

    int updateByExample(@Param("record") SourceOne record, @Param("example") SourceoneExample example);

    int updateByPrimaryKeySelective(SourceOne record);

    int updateByPrimaryKey(SourceOne record);
}