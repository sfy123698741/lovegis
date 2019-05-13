package com.lov.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lovegis.mapper.UserMapper;
import com.lovegis.pojo.Users;
import com.lovegis.pojo.UsersInfo;
@Service
public class RegisterService {
	@Resource UserMapper userMapper;
	public int addUser(String account, String passWord, String nickName, String grade) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		//应该在pojo或bean里声明构造函数来初始化，而不要用setget 
		//初始化的地方就用构造函数来减少代码量，getset用户单个读取 或者mybaits 实现时需要的
		//本质构造函数就是getset的集合，构造函数可以被setget代替，反之不行。
		//Users users = new Users();
		Users users = new Users(account, passWord);
//		users.setAccount(account);
//		users.setPassword(Util.EncoderByMd5(passWord));
		
		UsersInfo usersInfo = new UsersInfo(account, grade, nickName);
		
//		usersInfo.setAccount(account);
//		usersInfo.setNickname(nickName);
//		usersInfo.setGrade(grade);
		
		if(userMapper.addUser(users)==1){
		usersInfo.setUid(userMapper.LAST_INSERT_ID());//获取最后插入的主键
		return userMapper.addUserInfo(usersInfo);}
		return 0;
	}
	public boolean judgeEmail(String account){
		
		//Util.logger.debug("找不到"+userMapper.judgeEmail(account));
		if (userMapper.judgeEmail(account)!=null) 
			return true;
		return false;	
		
	}
	public boolean judgeNickName(String nickName){
		if (userMapper.judgeNickName(nickName)!=null) 
			return true;
		return false;	
		
	}
}
