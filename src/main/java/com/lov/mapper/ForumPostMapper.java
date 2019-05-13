package com.lov.mapper;

import com.heygis.beans.ForumPostPage;
import com.lovegis.pojo.ForumPost;
import com.lovegis.pojo.ForumPostExample;
import com.lovegis.pojo.ForumPostKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumPostMapper {
	public int addPost(ForumPost post);
	public boolean delPost(int pid);
	public List<ForumPostPage> getPostPage(int tid, int page);
	public String getPostMessage(int tid);
	
	
	
}