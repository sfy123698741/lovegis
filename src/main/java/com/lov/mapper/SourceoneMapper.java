package com.lov.mapper;

import com.lovegis.pojo.Sourceone;
import com.lovegis.pojo.SourceoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceoneMapper {
    int countByExample(SourceoneExample example);

    int deleteByExample(SourceoneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sourceone record);

    int insertSelective(Sourceone record);

    List<Sourceone> selectByExample(SourceoneExample example);

    Sourceone selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sourceone record, @Param("example") SourceoneExample example);

    int updateByExample(@Param("record") Sourceone record, @Param("example") SourceoneExample example);

    int updateByPrimaryKeySelective(Sourceone record);

    int updateByPrimaryKey(Sourceone record);
}