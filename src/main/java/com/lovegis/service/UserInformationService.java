package com.lovegis.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.Spring;

import org.springframework.stereotype.Service;

import com.heygis.beans.FeedbackMsg;
import com.heygis.beans.ForumPostPage;
import com.heygis.beans.NewMember;
import com.heygis.beans.User;
import com.heygis.dao.MemberDaoImpl;
import com.heygis.dao.UserDAOImpl;
import com.lovegis.mapper.FeedbackMapper;
import com.lovegis.mapper.ForumPostMapper;
import com.lovegis.mapper.MemberMapper;
import com.lovegis.mapper.UserMapper;
import com.lovegis.pojo.ForumPost;
import com.lovegis.pojo.Users;
import com.lovegis.pojo.UsersInfo;
import com.lovegis.util.Util;
@Service
public class UserInformationService {
	
	@Resource ForumPostMapper forumPostMapper;
	public ForumPostPage Topics(int tid, int page){
		//源topicService的getPostPage方法 
		int begin = (page-1) * 30;
		int end = 30;
		ForumPostPage postPage = new ForumPostPage(tid,page);//新建论坛记录页对象
		postPage.setTotalPostNum(forumPostMapper.QueryTidCount(tid));//查询记录数
		
		int forumPostListIndex=0;
		List<ForumPost> forumPostList = forumPostMapper.getForumPost(tid, begin, end);//获取一页
		for (ForumPost forumPost : forumPostList) {
			postPage.setPost(forumPostListIndex++,forumPost);//向页内放入数据
		}
		//更新浏览量
		forumPostMapper.updateView(tid);
		return postPage;
	}
	@Resource UserMapper userMapper;
	public boolean updateImg(User user,String base64){
		//源UserIconService 的三个方法，其中原toimg方法迁移到工具类
		//String path = "/usr/local/tomcat/webapps/heygis_img/icon/"+user.getAccount()+"_img.jpg";
		String icon_img = "/heygis_img/icon/"+user.getAccount()+"_img.jpg";//这儿要改成图片地址路径
		if(new Util().base64ToImg(base64,icon_img)) //根据string生成图片并保存
			if(userMapper.updateIconImg(icon_img,user.getAccount()) == 1)//更新数据库的图片地址
			return true;
		return false;
	}
	
	public boolean fillInfo(User user){
		
		return userMapper.fillInfo(user.getusersInfo(user));//抽出userinfo 调用fillinfo方法
	}
	//原RegisterService.java的三个函数
	public int addUser(String account, String passWord, String nickName, String grade) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Users users = new Users(account, passWord);
		UsersInfo usersInfo = new UsersInfo(account, grade, nickName);
		
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
	//源登入LoginService.java三个函数
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
		if(userMapper.addUser(user.getusers(user))==1)
		return userMapper.addUserInfo( user.getusersInfo(user));
		return 0;
	}
	
	@Resource MemberMapper memberMapper;
	//原joinUs的函数
	
	public boolean addMember(NewMember member){
		if(memberMapper.addMember(member) == 1)
		return true;
		return false;
	}
	
	
	//源FeedBackservice
	@Resource FeedbackMapper feedbackMapper;
	public boolean addMsg(FeedbackMsg feedbackMsg){
		return (feedbackMapper.addMsg(feedbackMsg)==1)?true:false;
	}
	public List<FeedbackMsg> getMsg(){
		return feedbackMapper.getMsg();
		
	}
	
	
	



	
}
