package com.lov.service;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heygis.beans.User;
import com.lovegis.mapper.UserMapper;
import com.lovegis.pojo.Users;
import com.lovegis.pojo.UsersInfo;
import com.lovegis.util.Util;

@Service
public class LoginService {

	@Resource UserMapper userMapper;
	
	
	
	public boolean login(String account,String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String passwordFromBaseMd5 =userMapper.validateUser(account);
		Util.logger.debug(passwordFromBaseMd5);
		
		if(passwordFromBaseMd5 == null || passwordFromBaseMd5.length() <= 0){
			System.out.println("account not exist");
			return false;
		}else{
			String pw = Util.EncoderByMd5(password);
			Util.logger.debug(pw);
			if(passwordFromBaseMd5.equals(pw)){
				System.out.println("login ok");
				return true;
			}else{
				System.out.println("password wrong");
				return false;
			}
		}
		
	}
	public User getUser(String account){
		UsersInfo usersInfo=userMapper.getUser(account);
		return new User(usersInfo.getUid(), usersInfo.getAccount(), usersInfo.getNickname(), usersInfo.getGrade(), usersInfo.getGender(), usersInfo.getQq(), usersInfo.getTel(), usersInfo.getSelfintroduction(), usersInfo.getIconImg());
	}
	public int addUser(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Users users = new Users();
		users.setAccount(user.getAccount());
		users.setPassword(Util.EncoderByMd5(user.getPassWord()));
		
		UsersInfo usersInfo = new UsersInfo();
		usersInfo.setUid(user.getUid());
		usersInfo.setAccount(user.getAccount());
		usersInfo.setNickname(user.getNickName());
		usersInfo.setGrade(user.getGrade());
		
		if(userMapper.addUser(users)==1)
		return userMapper.addUserInfo(usersInfo);
		return 0;
	}
	

}
