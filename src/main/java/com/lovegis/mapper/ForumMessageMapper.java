package com.lovegis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumMsgPage;

public interface ForumMessageMapper {
	int howManyMsg(int uid);
	int howManyNewMsg(int uid);
	int howManyOldMsg(int uid);
	boolean addMsg(int type,@Param("forumMsg") ForumMessage forumMsg);
	boolean makeMsgOld(int mid);
	ForumMessage getMsg(int mid);//之前的方法没有写过实现
	List<ForumMessage> getMsgPage(int uid,  int n ,int begin,int end);//修改了参数个数
}
