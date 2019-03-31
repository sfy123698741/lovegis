package com.lov.mapper;

import com.lovegis.pojo.PageViewCounter;
import com.lovegis.pojo.PageViewCounterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageViewCounterMapper {
    int countByExample(PageViewCounterExample example);

    int deleteByExample(PageViewCounterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageViewCounter record);

    int insertSelective(PageViewCounter record);

    List<PageViewCounter> selectByExample(PageViewCounterExample example);

    PageViewCounter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageViewCounter record, @Param("example") PageViewCounterExample example);

    int updateByExample(@Param("record") PageViewCounter record, @Param("example") PageViewCounterExample example);

    int updateByPrimaryKeySelective(PageViewCounter record);

    int updateByPrimaryKey(PageViewCounter record);
}