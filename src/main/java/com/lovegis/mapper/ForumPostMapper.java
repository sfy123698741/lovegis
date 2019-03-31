package com.lovegis.mapper;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumPostPage;

public interface ForumPostMapper {
	public int addPost(ForumPost post);
	public boolean delPost(int pid);
	public ForumPostPage getPostPage(int tid, int page);
	public String getPostMessage(int tid);
}
