package com.lov.mapper;

import com.lovegis.pojo.SourceThree;
import com.lovegis.pojo.SourceThree;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourcethreeMapper {
    int countByExample(SourcethreeExample example);

    int deleteByExample(SourcethreeExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(SourceThree record);

    int insertSelective(SourceThree record);

    List<SourceThree> selectByExample(SourcethreeExample example);

    SourceThree selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") SourceThree record, @Param("example") SourcethreeExample example);

    int updateByExample(@Param("record") SourceThree record, @Param("example") SourcethreeExample example);

    int updateByPrimaryKeySelective(SourceThree record);

    int updateByPrimaryKey(SourceThree record);
}