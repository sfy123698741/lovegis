package com.lovegis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heygis.beans.FeedbackMsg;

public interface FeedbackMapper {
	public int addMsg(@Param("feedbackMsg") FeedbackMsg feedbackMsg);
	public List<FeedbackMsg> getMsg();
}
