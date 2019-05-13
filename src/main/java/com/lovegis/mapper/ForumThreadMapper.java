package com.lovegis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleConstraint.Initially;
import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.lovegis.pojo.ForumPost;

public interface ForumThreadMapper {
	public boolean addThread(@Param("thread") ForumThread thread, @Param("post") ForumPost post);
	public boolean delThread(int tid);
	public List<ForumThread> getThreadPage(int fid, int begin, int end);
	public List<ForumThread> getThreadPageByUid(int uid, int begin, int end);
	public int countPageNum(int fid);
}
