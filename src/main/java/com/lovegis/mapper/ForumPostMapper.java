package com.lovegis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heygis.beans.ForumPostPage;
import com.lovegis.pojo.ForumPost;


public interface ForumPostMapper extends BaseMapper {
	public int addPost(int pid,@Param("post") ForumPost post);//添加一条评论
		public int CountPid();//查询forum_post的pid不重复总数
		public int UpdateLastpostThread(Long lastpost,String lastposter,int tid);//更新帖子最后一个提交者
		
	public boolean delPost(int pid);
	public ForumPostPage getPostPage(int tid, int page);
	public String getPostMessage(int tid);
	
	public int 	QueryTidCount(int tid);
	public int 	updateView(int tid);
	public List<ForumPost> getForumPost(int tid, int begin, int end);
	
	
	
}
