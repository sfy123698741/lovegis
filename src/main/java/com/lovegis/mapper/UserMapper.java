package com.lovegis.mapper;

import java.sql.ResultSet;

import org.apache.ibatis.annotations.Param;

import com.heygis.beans.User;
import com.lovegis.pojo.Users;
import com.lovegis.pojo.UsersInfo;

public interface UserMapper extends BaseMapper{
	public String validateUser(String account);
	public int addUser(@Param("users")Users users);
	public int addUserInfo(@Param("usersInfo")UsersInfo usersInfo);
	public UsersInfo getUser(String account);
	public Users judgeEmail(String account);
	
	public UsersInfo judgeNickName(String nickName);
	public boolean fillInfo(@Param("usersInfo")UsersInfo usersInfo);
	public int updateIconImg(String icon_img,String account);
}
