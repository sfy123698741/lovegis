package com.lov.mapper;

import com.lovegis.pojo.Newmember;
import com.lovegis.pojo.NewmemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewmemberMapper {
    int countByExample(NewmemberExample example);

    int deleteByExample(NewmemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Newmember record);

    int insertSelective(Newmember record);

    List<Newmember> selectByExample(NewmemberExample example);

    Newmember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Newmember record, @Param("example") NewmemberExample example);

    int updateByExample(@Param("record") Newmember record, @Param("example") NewmemberExample example);

    int updateByPrimaryKeySelective(Newmember record);

    int updateByPrimaryKey(Newmember record);
}