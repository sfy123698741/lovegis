package com.lovegis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.heygis.beans.ForumMsgPage;
import com.heygis.service.LoginService;
import com.heygis.service.NewMsgService;
import com.heygis.service.RegisterService;

@Controller
public class UserController {
	
	public void selfCenter (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		if(!(Boolean)request.getAttribute("loged")){
			response.sendRedirect("index.jsp");
			return;
		}
		int uid = Integer.parseInt(request.getAttribute("uid").toString());//获取uid
		ForumMsgPage fMsgPage = new NewMsgService().getMsgPage(uid, 1, 1);
		request.setAttribute("fMsgPage", fMsgPage);
		RequestDispatcher dis =  request.getRequestDispatcher("selfCenter.jsp");
		dis.forward(request, response);
	}
	public void register(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String account = request.getParameter("account1");
		String passWord = request.getParameter("passWord");
		String nickName = request.getParameter("nickName");
		String grade = request.getParameter("grade");
		RegisterService registerServer = new RegisterService();
		int result = registerServer.addUser(account, passWord, nickName, grade);
		if(result == 1){
			System.out.println("suce");
			LoginService loginService = new LoginService();
			request.getSession().setAttribute("loged",true);
			request.getSession().setAttribute("user",loginService.getUser(account));//将信息提交到个人中心页面。
			response.sendRedirect("selfCenterServlet");
//			RequestDispatcher dis =  request.getRequestDispatcher("/selfCenter.html");
//			dis.forward(request, response);
		}else{
			request.setAttribute("message", "注册失败");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
		}
	}
	public void joinUS() {
			
		}
	public void fillInfo() {
		
	}
	public void userIcon() {
		
	}
	public void Login() {
			
		}
	public void Logout() {
			
		}
}
