package com.lov.mapper;

import com.lovegis.pojo.Sourcethree;
import com.lovegis.pojo.SourcethreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourcethreeMapper {
    int countByExample(SourcethreeExample example);

    int deleteByExample(SourcethreeExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(Sourcethree record);

    int insertSelective(Sourcethree record);

    List<Sourcethree> selectByExample(SourcethreeExample example);

    Sourcethree selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") Sourcethree record, @Param("example") SourcethreeExample example);

    int updateByExample(@Param("record") Sourcethree record, @Param("example") SourcethreeExample example);

    int updateByPrimaryKeySelective(Sourcethree record);

    int updateByPrimaryKey(Sourcethree record);
}