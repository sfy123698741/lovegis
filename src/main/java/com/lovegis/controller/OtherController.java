package com.lovegis.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.heygis.beans.FeedbackMsg;
import com.heygis.service.FeedbackService;
import com.lovegis.service.UserInformationService;

@Controller
public class OtherController {
	@Resource UserInformationService userInformationService;
	public String Vtour(Model model ,String htmlURL) {
		//String htmlURL = request.getParameter("html");
		//request.setAttribute("htmlURL", htmlURL);
		model.addAttribute("htmlURL", htmlURL);
		return "forward:/vtourScan.jsp";
//		request.getRequestDispatcher("vtourScan.jsp").forward(request, response);		
	}
	public String feedback(Model model) {
		List<FeedbackMsg> feedbackMsgList = null;
		/*FeedbackService feedbackService = new FeedbackService();
		feedbackMsgList = feedbackService.getMsg();*/
		feedbackMsgList=userInformationService.getMsg();
		model.addAttribute("feedbackMsgList", feedbackMsgList);
		//request.getRequestDispatcher("/feedback.jsp").forward(request, response);
		return "forward:/feedback.jsp";
	}
}
