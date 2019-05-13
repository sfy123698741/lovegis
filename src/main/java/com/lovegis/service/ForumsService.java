package com.lovegis.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumMsgPage;
import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.heygis.dao.ForumThreadDAOImpl;
import com.heygis.dao.interfaces.ForumThreadDAO;
import com.lovegis.mapper.ForumThreadMapper;
import com.lovegis.pojo.ForumPost;
@Service
public class ForumsService {
	/*ForumThreadDAO forumThreadDAO = null;
	public ForumsService(){
		forumThreadDAO = new ForumThreadDAOImpl();
	}*/
	@Resource ForumThreadMapper forumThreadMapper;
	public ForumsThreadPage getThreadPage(int fid, int page){
		int begin = (page-1) * 30;
		int end = 30 ;
		List<ForumThread> list = forumThreadMapper.getThreadPage(fid,begin,end);
		ForumsThreadPage threadPage = new ForumsThreadPage(fid,page,list.size(),(ForumThread[]) list.toArray());
		
		threadPage.setTotalThreadNum(forumThreadMapper.countPageNum(fid));//设置页数
		return threadPage;
	}
	public boolean addthread(ForumThread thread, ForumPost post){
		return forumThreadMapper.addThread(thread, post);
	}
	public String getMyThread(int uid, int page){
		int begin = (page-1) * 30;
		int end = 30 ;
		List<ForumThread> list = forumThreadMapper.getThreadPageByUid(uid,begin,end);
		ForumsThreadPage threadPage = new ForumsThreadPage(uid,page,list.size(),(ForumThread[]) list.toArray());
		
	/*	JSONObject tl = new JSONObject();
		JSONArray threadArray = new JSONArray();
		try {
			tl.put("size", threadPage.getSize());
			tl.put("page", threadPage.getPage());
			JSONObject thread;
			for(int i=0;i<threadPage.getSize();i++){
				thread = new JSONObject();
				thread.put("tid", threadPage.getThread(i).getTid());
				thread.put("subject", threadPage.getThread(i).getSubject());
				thread.put("dateline", new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(threadPage.getThread(i).getDateline()));
				thread.put("lastpost", threadPage.getThread(i).getLastpost());
				thread.put("lastposter", threadPage.getThread(i).getLastposter());
				thread.put("views", threadPage.getThread(i).getViews());
				thread.put("replies", threadPage.getThread(i).getReplies());
				thread.put("close", threadPage.getThread(i).getClose());
				thread.put("displayorer", threadPage.getThread(i).getDisplayorer());
				threadArray.put(thread);
			}
			tl.put("threadArray", threadArray);
		*/
		return new Gson().toJson(threadPage);
	}
}
