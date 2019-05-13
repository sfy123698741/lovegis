package com.lov.mapper;

import com.lovegis.pojo.SourceTwo;
import com.lovegis.pojo.SourceTwo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourcetwoMapper {
    int countByExample(SourcetwoExample example);

    int deleteByExample(SourcetwoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SourceTwo record);

    int insertSelective(SourceTwo record);

    List<SourceTwo> selectByExample(SourcetwoExample example);

    SourceTwo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SourceTwo record, @Param("example") SourcetwoExample example);

    int updateByExample(@Param("record") SourceTwo record, @Param("example") SourcetwoExample example);

    int updateByPrimaryKeySelective(SourceTwo record);

    int updateByPrimaryKey(SourceTwo record);
}