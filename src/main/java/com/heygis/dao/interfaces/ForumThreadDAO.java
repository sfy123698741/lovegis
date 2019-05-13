package com.heygis.dao.interfaces;

import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.lovegis.pojo.ForumPost;

public interface ForumThreadDAO {
	public boolean addThread(ForumThread thread, ForumPost post);
	public boolean delThread(int tid);
	public ForumsThreadPage getThreadPage(int fid, int page);
	public ForumsThreadPage getThreadPageByUid(int uid, int page);
}
