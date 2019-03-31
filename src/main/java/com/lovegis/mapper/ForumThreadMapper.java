package com.lovegis.mapper;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;

public interface ForumThreadMapper {
	public boolean addThread(ForumThread thread, ForumPost post);
	public boolean delThread(int tid);
	public ForumsThreadPage getThreadPage(int fid, int page);
	public ForumsThreadPage getThreadPageByUid(int uid, int page);
}