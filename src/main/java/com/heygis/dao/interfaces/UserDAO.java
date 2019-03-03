package com.heygis.dao.interfaces;

import java.sql.ResultSet;

import com.heygis.beans.User;

public interface UserDAO {
	public boolean validateUser(String account,String password);
	public int addUser(User user);
	public User getUser(String account);
	public boolean judgeEmail(String account);
	public boolean judgeNickName(String nickName);
	public boolean fillInfo(User user);
	public boolean updateIconImg(User user);
}
