package com.lov.mapper;

import com.heygis.beans.FeedbackMsg;
import com.lovegis.pojo.Feedback;
import com.lovegis.pojo.FeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {
	public boolean addMsg(FeedbackMsg feedbackMsg);
	public List<FeedbackMsg> getMsg();
}