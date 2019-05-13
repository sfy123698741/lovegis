package com.lovegis.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumMsgPage;
//import com.heygis.dao.ForumMessageDAOImpl;
//import com.heygis.dao.ForumPostDAOImpl;
//import com.heygis.dao.interfaces.ForumMessageDAO;
//import com.heygis.dao.interfaces.ForumPostDAO;
//import com.lov.service.AddPostService;
//import com.lov.service.LoginService;
import com.lovegis.mapper.ForumMessageMapper;
import com.lovegis.mapper.ForumPostMapper;
//import com.lovegis.pojo.ForumPost;
@Service
public class PersonalCenterService {
	@Resource ForumPostMapper forumPostMapper;
	@Resource PersonalCenterService personalCenterService;
	///@Resource ForumMessageMapper forumMessageMapper2;
	 @Resource ForumMessageMapper forumMessageMapper;
		int ADDPOSTservice;//源ADDPOSTservice
    //添加评论（附加提醒（非本人消息））
		//如果评论之后自己还有消息就很奇怪，但是这两个方法应该合并一下
	public int addPostWithMsg(ForumPost post, int t_uid, String subject){
		Integer author_uid =  post.getAuthorUid();
		
		
    	forumPostMapper.addPost(forumPostMapper.CountPid()+1,post);//插入评论
    	forumPostMapper.UpdateLastpostThread(new Date().getTime(),post.getAuthor(),post.getTid());//更新最后更新时间提示
    	int posi = forumPostMapper.LAST_INSERT_ID(); //返回主键
    	
    	
    	if(posi != 0){//如果插入成功
    		if(author_uid != t_uid){
	    		ForumMessage fmsg = new ForumMessage(post.getAuthor(), t_uid, subject, post.getDateline().getTime(), 1, post.getFid(), post.getTid());
	    		//sfy :调用处 ForumMessage(String author, int rd_uid
	    		//所以t——uid 就是rd——uid 不知道为啥不同一
	    		fmsg.setPosition(posi);
	    		if(forumMessageMapper.addMsg(1, fmsg)){//给被评论的楼主发送新消息提醒
	    			forumMessageMapper.addMsg(2, fmsg);  //添加到消息组里
	    			return posi;
	    			}
	    	
    		}
    	}
    	return 0;
    }
	/*//添加评论
    public int addPost(ForumPost post, int t_uid, String subject){
    	forumPostMapper.addPost(forumPostMapper.CountPid()+1,post);//插入评论
    	forumPostMapper.UpdateLastpostThread(new Date().getTime(),post.getAuthor(),post.getTid());//更新最后更新时间提示
    	int posi = forumPostMapper.LAST_INSERT_ID();
    	if(posi != 0){
    		return posi;
    	}else{
    		return 0;
    	}
    }*/
    	int newMsgService;//源newMsgService
   
	public int howManyNewMsg(int uid){ //多少新消息
		return forumMessageMapper.howManyNewMsg(uid);
	}
	public int howManyOldwMsg(int uid){//多少旧消息
		return forumMessageMapper.howManyOldMsg(uid);
	}
	public ForumMsgPage getMsgPage(int uid,int page, int n){//获取消息页
		int begin = (page-1)*20;
		int end = 20;
		
		List<ForumMessage> list = forumMessageMapper.getMsgPage(uid, n,begin,end);
		ForumMsgPage msgPage = new ForumMsgPage(uid,page,list.size(),(ForumMessage[]) list.toArray());
		return msgPage;
	}
	public String getMsgList(int uid,int page, int n){//获取消息列表
		int begin = (page-1)*20;
		int end = 20;
		List<ForumMessage> list = forumMessageMapper.getMsgPage(uid, n,begin,end);
		ForumMsgPage msgPage = new ForumMsgPage(uid,page,list.size(),(ForumMessage[]) list.toArray());
		
		
		//之后应该修改成从bean中直接转化json
		/*JSONObject mp = new JSONObject();
		JSONArray msgArray = new JSONArray();
		try {
			mp.put("size", msgPage.getSize());
			mp.put("page", msgPage.getPage());
			JSONObject msg;
			for(int i=0;i<msgPage.getSize();i++){
				msg = new JSONObject();
				msg.put("mid", msgPage.getMsg(i).getMid());
				msg.put("author", msgPage.getMsg(i).getAuthor());
				msg.put("rd_uid", msgPage.getMsg(i).getRd_uid());
				msg.put("subject", msgPage.getMsg(i).getSubject());
				msg.put("dateline", new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date(msgPage.getMsg(i).getDateline())));
				msg.put("type", msgPage.getMsg(i).getType());
				msg.put("fid", msgPage.getMsg(i).getFid());
				msg.put("tid", msgPage.getMsg(i).getTid());
				msg.put("position", msgPage.getMsg(i).getPosition());
				msg.put("page", msgPage.getMsg(i).getPage());
				msgArray.put(msg);
			}
			mp.put("msgArray", msgArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		
		 
		return new Gson().toJson(msgPage);
	}
	public boolean makeMsgOld(int mid){//让消息成为旧消息
		return forumMessageMapper.makeMsgOld(mid);
	}
	
		int replyPostService;//源replyPostService
/*	private ForumPostDAO postDAO = null;
	private ForumMessageDAO msgDAO= null;
	*/
	/*public ReplyPostService(){
		postDAO = new ForumPostDAOImpl();
		msgDAO = new ForumMessageDAOImpl();
	}*/
		
	public String getPostMessage(int pid){//获取信息
		return forumPostMapper.getPostMessage(pid);
	}
	public boolean addReplyPost(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		//添加相应信息
		int replyposi = this.addPostWithMsg(post, t_uid, fmsg.getSubject());  //返回楼数
		/*if(author_uid != t_uid){
			replyposi = this.addPostWithMsg(post, t_uid, fmsg.getSubject());
		}else{
			replyposi = this.addPost(post, t_uid, fmsg.getSubject());
		}*/
		if(replyposi != 0){
			/*if(author_uid != fmsg.getRd_uid()){//如果写消息的不是作者
				fmsg.setPosition(replyposi);   ///这里好像重复插入了两次
				if(msgDAO.addMsg(2, fmsg)){  //添加消息
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}*/
			return true;
		}
		return false;
	}
	
	/*并没有掉用的三个函数  不知所用
	//111
	public boolean addReplyPost1(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			return true;
		}
		return false;
	}
	//112 & 121
	public boolean addReplyPost2(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			fmsg.setPosition(replyposi);
			if(msgDAO.addMsg(2, fmsg)){
				return true;
			}
		}
		return false;
	}
	//211
	public boolean addReplyPost4(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPostWithMsg(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			fmsg.setPosition(replyposi);
			if(msgDAO.addMsg(2, fmsg)){
				return true;
			}
		}
		return false;
	}
*/
}
