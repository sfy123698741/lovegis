package com.lovegis.mapper;

import java.util.List;

import com.heygis.beans.FeedbackMsg;

public interface FeedbackMapper {
	public boolean addMsg(FeedbackMsg feedbackMsg);
	public List<FeedbackMsg> getMsg();
}
