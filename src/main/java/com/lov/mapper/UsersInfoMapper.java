package com.lov.mapper;

import com.lovegis.pojo.UsersInfo;
import com.lovegis.pojo.UsersInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersInfoMapper {
    int countByExample(UsersInfoExample example);

    int deleteByExample(UsersInfoExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(UsersInfo record);

    int insertSelective(UsersInfo record);

    List<UsersInfo> selectByExample(UsersInfoExample example);

    UsersInfo selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") UsersInfo record, @Param("example") UsersInfoExample example);

    int updateByExample(@Param("record") UsersInfo record, @Param("example") UsersInfoExample example);

    int updateByPrimaryKeySelective(UsersInfo record);

    int updateByPrimaryKey(UsersInfo record);
}