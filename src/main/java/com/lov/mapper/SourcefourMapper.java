package com.lov.mapper;

import com.lovegis.pojo.SourceFour;
import com.lovegis.pojo.SourceFour;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourcefourMapper {
    int countByExample(SourcefourExample example);

    int deleteByExample(SourcefourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SourceFour record);

    int insertSelective(SourceFour record);

    List<SourceFour> selectByExample(SourcefourExample example);

    SourceFour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SourceFour record, @Param("example") SourcefourExample example);

    int updateByExample(@Param("record") SourceFour record, @Param("example") SourcefourExample example);

    int updateByPrimaryKeySelective(SourceFour record);

    int updateByPrimaryKey(SourceFour record);
}