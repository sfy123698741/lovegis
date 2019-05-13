package com.heygis.service;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.annotation.Resource;

import com.heygis.beans.User;
import com.lovegis.mapper.UserMapper;

public class LoginService {
//	UserDAOImpl udi = null;
	@Resource UserMapper userMapper;
//	public LoginService(){
//		udi = new UserDAOImpl();
//	}
	
	
	public boolean login(String account,String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String passwordFromBaseMd5 =userMapper.validateUser(account);
		if(passwordFromBaseMd5 == null || passwordFromBaseMd5.length() <= 0){
			String pw = EncoderByMd5(password);
			System.out.println(pw);
			if(passwordFromBaseMd5.equals(pw)){
				System.out.println("login ok");
				return true;
			}else{
				System.out.println("password wrong");
				return false;
			}
		}else{
			System.out.println("account not exist");
			return false;
		}
		
	}
	public User getUser(String account){
		return userMapper.getUser(account);
	}
	public int addUser(User user){
		return userMapper.addUser(user);		
	}
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 //确定计算方法
		// MessageDigest md5=MessageDigest.getInstance("MD5");
		
	    // BASE64Encoder base64en = new BASE64Encoder(); 
		 Base64.Encoder encoder = Base64.getEncoder();//sfy 
		 
		 //加密后的字符串
		 //String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		 
		 String newstr = encoder.encodeToString(str.getBytes("utf-8"));//sfy 
		 return newstr;
	 }

}
