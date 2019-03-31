package com.lov.mapper;

import com.lovegis.pojo.Sourcefour;
import com.lovegis.pojo.SourcefourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourcefourMapper {
    int countByExample(SourcefourExample example);

    int deleteByExample(SourcefourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sourcefour record);

    int insertSelective(Sourcefour record);

    List<Sourcefour> selectByExample(SourcefourExample example);

    Sourcefour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sourcefour record, @Param("example") SourcefourExample example);

    int updateByExample(@Param("record") Sourcefour record, @Param("example") SourcefourExample example);

    int updateByPrimaryKeySelective(Sourcefour record);

    int updateByPrimaryKey(Sourcefour record);
}