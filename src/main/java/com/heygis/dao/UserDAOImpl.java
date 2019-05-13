package com.heygis.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
//import Decoder.BASE64Encoder;

import com.heygis.beans.User;
import com.heygis.dao.interfaces.UserDAO;

public class UserDAOImpl extends DAOSupport implements UserDAO{

	@Override
	public boolean validateUser(String account,String password){
		try {
			String sql = "select password from users where account=?";
			this.openConn();
			ResultSet rs = this.execQuery(sql, account);
			if(rs.next()){
				String pw = EncoderByMd5(password);
				System.out.println(pw);
				if(rs.getString("password").equals(pw)){
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
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public int addUser(User user){//添加默认的性别，头像，个人介绍
		try {
			String account = user.getAccount();
			String password = EncoderByMd5(user.getPassWord());
			System.out.println(password);
			String nickName = user.getNickName();
			String grade = user.getGrade();
			String sql1 = "insert into users (account,password) values (?,?)";
			String sql2 = "insert into users_info (uid,account,nickname,grade) values (?,?,?,?)";
			this.openConn();
			System.out.println(account);
			int result1 = this.execUpdate(sql1,account,password);
			if(result1 == 1){
				System.out.println("register scuessfully");
				int uid = this.LAST_INSERT_ID();
				this.execUpdate(sql2,uid,account,nickName,grade);
				this.close();
				return result1;
			}else{
				this.close();
				System.out.println("register failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;		
	}

	@Override
	public User getUser(String account){
		try {
			User user = null;
			String sql = "select uid,account,nickname,gender,grade,QQ,tel,selfintroduction,identity_id,icon_img from users_info where account=?";
			this.openConn();
			ResultSet rs = this.execQuery(sql,account);
			if(rs.next()){
//				System.out.println("user已经填充");
				user = new User(rs.getInt("uid"),rs.getString("account"),rs.getString("nickname"), rs.getString("grade"),
						rs.getString("gender"), rs.getString("QQ"), rs.getString("tel"),
						rs.getString("selfIntroduction"), rs.getString("icon_Img"));
			}
			this.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean judgeEmail(String account) {
		boolean bool = false;
		String sql = "select * from users where account=?";
		this.openConn();
		ResultSet rs = this.execQuery(sql, account);
		try {
			bool = !rs.next();
			this.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean judgeNickName(String nickName) {
		boolean bool = false;
		String sql = "select * from users_info where nickname=?";
		this.openConn();
		ResultSet rs = this.execQuery(sql, nickName);
		try {
			bool = !rs.next();
			this.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean fillInfo(User user) {
		//boolean bool = false;
		String sql = "update users_info set nickname=?,grade=?,selfintroduction=?,gender=?,QQ=?,tel=? where account=?";
		this.openConn();
		int result = this.execUpdate(sql, user.getNickName(),user.getGrade(),user.getSelfIntroduction(),user.getGender(),user.getQQ(),user.getTel(),user.getAccount());
		this.close();
		System.out.println(user.getAccount());
		System.out.println(result);
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateIconImg(User user) {
		String icon_img = "/heygis_img/icon/"+user.getAccount()+"_img.jpg";//这儿要改成图片地址路径
		String sql = "UPDATE users_info SET icon_img = ? WHERE account = ?";
		this.openConn();
		int result = this.execUpdate(sql, icon_img,user.getAccount());
		System.out.println(result);
		this.close();
		if(result == 1){
			return true;
		}
		return false;
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
