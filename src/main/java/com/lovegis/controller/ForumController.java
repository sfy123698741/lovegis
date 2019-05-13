package com.lovegis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.heygis.beans.FeedbackMsg;
import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumPostPage;
import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.heygis.beans.User;
import com.lovegis.pojo.ForumPost;
import  com.lovegis.service.ForumsService;
import com.lovegis.service.PersonalCenterService;
import com.lovegis.service.SourceServie;
import com.lovegis.service.UserInformationService;

@SessionAttributes({"loged","user"})
@Controller
public class ForumController {
	@Resource ForumsService forumsService;
	@Resource SourceServie sourceServie;
	@Resource PersonalCenterService personalCenterService;
	@Resource UserInformationService userInformationService;
	public String forums(Model model,Integer page,Integer fid) {
		/*int page,fid = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			fid = Integer.parseInt(request.getParameter("fid"));
		} catch (Exception e) {
			error("版块访问失败",request,response);
			return;
		}*/
	/*	ForumsService fs = new ForumsService();
		ForumsThreadPage threadPage = fs.getThreadPage(fid, page);*/
		ForumsThreadPage threadPage =forumsService.getThreadPage(fid, page);
		if(threadPage.getFid() < 4){
			model.addAttribute("threadPage", threadPage);
			return "forward:/fotums/forums.jsp";
			/*RequestDispatcher dis = request.getRequestDispatcher("/forums/forums.jsp");
			dis.forward(request, response);*/
		}else{
//			error("访问版块不存在",request,response);
			model.addAttribute("message", "访问版块不存在");
			return "forward:/result.jsp";
		}
	}
//	void error(String msg,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		model.addAttribute("message", msg);
//		RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
//		dis.forward(request, response);
//	}
	public String addFeedback(@SessionAttribute("user") User user,  String check ,@PathVariable("content")String feedbackContent) {
		//request.setCharacterEncoding("UTF-8");
		//String check = request.getParameter("check");
		System.out.println(check);
		
		String account = null;
		String nickname = null;
		if(check.equals("2")){
			//判断登录
//			account = ((User)request.getSession().getAttribute("user")).getAccount();
//			nickname = ((User)request.getSession().getAttribute("user")).getNickName();
			account = user.getAccount();
			nickname =user.getNickName();
		}else{
			account = "visitor@163.com";
			nickname = "匿名";
		}
		Date dtime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(dtime);
		
//		String feedbackContent = request.getParameter("content");
		String accountImg = "img/bbs-1.JPG";
		FeedbackMsg feedbackMsg = new FeedbackMsg(account, nickname, time, feedbackContent, accountImg);
		
		//FeedbackService feedbackService = new FeedbackService();
		if(userInformationService.addMsg(feedbackMsg)){
//			response.sendRedirect("feedbackServlet");
			return "redirect:OtherController/feedback";
		}else{
			//返回错误页面；
			return null;
		}
		
	}
	public String replyPost(HttpServletRequest request,int pid,int tid,int fid,int rd_uid,int t_uid,Model model,@SessionAttribute("loged")  Boolean loged,@SessionAttribute("user")  User user,String message,String replyhread,String subject) {
//		request.setCharacterEncoding("utf-8");
		if(loged == null){
			model.addAttribute("message", "请先登录");
			
//			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
//			dis.forward(request, response);
			
			return "forward:/result.jsp";
		}
		
//		String message = request.getParameter("message");
//		String replyhread = request.getParameter("replyhead");
//		String subject = request.getParameter("subject");
		
		/*int pid = Integer.parseInt(request.getParameter("replypid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		int fid = Integer.parseInt(request.getParameter("fid"));
//		int posi = Integer.parseInt(request.getParameter("posi"));
		int t_uid = Integer.parseInt(request.getParameter("t_uid"));
		int rd_uid = Integer.parseInt(request.getParameter("postauthor_uid"));*/
		
//		String replyedaccount = request.getParameter("postauthor_account");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
		//User user = (User)request.getSession().getAttribute("user");
//		ReplyPostService replyPostService = new ReplyPostService();
		String replyedmessage = replyhread +personalCenterService.getPostMessage(pid) + "</blockquote></fieldset>";
		
		ForumPost post = new ForumPost(
				-1, fid, tid, 0, 
				user.getNickName(), user.getUid(), user.getAccount(), "",
				new Date(),replyedmessage+message, request.getRemoteAddr(), attchment, -1);
		ForumMessage fmsg = new ForumMessage(user.getNickName(), rd_uid, subject, new Date().getTime(), 2, fid, tid);
		
		if(personalCenterService.addReplyPost(post,fmsg,t_uid,user.getUid())){
			
//			response.sendRedirect(request.getHeader("referer"));
			return "redirect:/"+request.getHeader("referer");

		}else{
			model.addAttribute("message", "回帖失败");
//			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
//			dis.forward(request, response);
			return "forward:/result.jsp";
		}
		
	}
	public String addPost(HttpServletRequest request,int fid,int tid ,int t_uid,String subject,String message,@SessionAttribute("user") User user,@SessionAttribute("loged") Boolean loged, Model model) {
		if(loged == null){
			model.addAttribute("message", "请先登录");
			return "forward:/result.jsp";
		}
//		int fid = Integer.parseInt(request.getParameter("fid"));
//		int tid = Integer.parseInt(request.getParameter("tid"));
//		int t_uid = Integer.parseInt(request.getParameter("t_uid"));
//		String subject = request.getParameter("subject");
//		String message = request.getParameter("message");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
//		User user = (User)request.getSession().getAttribute("user");
		/*String author = user.getNickName();
		int authorUid = user.getUid();
		String authorAccount = user.getAccount();*/
		ForumPost post = new ForumPost(-1, fid, tid, 0, user.getNickName(),  user.getUid(), user.getAccount(), "",
				new Date(), message, request.getRemoteAddr(), attchment, -1);
//		AddPostService addPostService = AddPostService.getInstance();
		int posi = 0;
	/*这里因为两个方法被合并了，判断放到方法的内部了
	 * 	if(user.getUid() != t_uid){
			posi = personalCenterService.addPostWithMsg(post,t_uid,subject);
		}else{
			posi = personalCenterService.addPost(post,t_uid,subject);
		}//sfy ：这里也被分成两个方法了
		*/
		
		posi = personalCenterService.addPostWithMsg(post,t_uid,subject);
		if(posi != 0){
		//	response.sendRedirect(request.getHeader("referer"));
			return "forward:/"+request.getHeader("referer");
		}else{
			model.addAttribute("message", "发帖失败");
			return "forward:/result.jsp";
		/*	RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);*/
		}
	}
	
	public String addThread(HttpServletRequest request,int fid,String subject,String message ,@SessionAttribute("loged") Boolean loged,@SessionAttribute("user") User user,Model model) {
		if(loged == null){
			model.addAttribute("message", "请先登录");
			return "forward:/result.jsp";
		}
		
		
/*		int fid = Integer.parseInt(request.getParameter("fid")); //获取参数
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");*/
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
		//User user = (User)request.getSession().getAttribute("user"); //从缓存中获取数据
		String author = user.getNickName();
		int authorUid = user.getUid();
		String authorAccount = user.getAccount();
//		System.out.println(author+authorUid+authorAccount);
		ForumThread thread = new ForumThread(0, fid, 0, 0, 
				author, authorUid, authorAccount, subject, 
				new Date(), new Date(), "", 0, 0, 0, 0, 0, 1);  // new一个新的been来存放数据
		ForumPost post = new ForumPost(0, fid, 0, 1, 
				author, authorUid, authorAccount, subject,
				new Date(), message, request.getRemoteAddr(), attchment, 0);
		
		if(forumsService.addthread(thread, post)){  //调用service 添加方法来添加数据，参数是bean
			return "forward:/"+request.getHeader("referer");
		}else{
			model.addAttribute("message", "发帖失败");
			return "forward:/result.jsp";
		}
		}
	public String topics(int fPage,int page,int tid,Model model) {
		/*int fPage = 1,page = 1,tid = 0;
		try {
			if(request.getParameter("fPage") != null){
				fPage = Integer.parseInt(request.getParameter("fPage"));
			}
			page = Integer.parseInt(request.getParameter("page"));
			tid = Integer.parseInt(request.getParameter("tid"));
		} catch (Exception e) {
			error("该帖访问失败", request, response);
			return;
		}*/
//		System.out.println(tid);
		/*TopicsService ts = new TopicsService();
		ForumPostPage postPage = ts.getPostPage(tid, page);*/
		
		ForumPostPage postPage=userInformationService.Topics(tid, page);
		postPage.setfPage(fPage);
//		System.out.println(postPage.getPost_number());
		if(postPage.getSize() != 0){
			model.addAttribute("postPage", postPage);
			/*RequestDispatcher dis = request.getRequestDispatcher("/forums/topics.jsp");
			dis.forward(request, response);*/
			return "forward:/result.jsp";
			
		}else{
			//error("帖子这一页空了,分页系统还需要迭代", request, response);
			model.addAttribute("message", "帖子这一页空了,分页系统还需要迭代");
			return "forward:/result.jsp";
		}
	}
	public void AddCount(String sourceName,String sourceType,HttpServletResponse response) throws IOException {
		System.out.println("in");
		PrintWriter out = response.getWriter();
		//String sourceName = request.getParameter("sourceName");
		if(sourceServie.addCount(sourceName,sourceType)){
			out.print("true");
		}else{
			out.print("false");
		}
	}
}
