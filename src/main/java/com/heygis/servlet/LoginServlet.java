package com.heygis.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.LoginService;


public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		try {
			if(loginService.login(account,password)){
				request.getSession().setAttribute("loged",true);
				request.getSession().setAttribute("user",loginService.getUser(account) );
//			System.out.println(request.getHeader("referer"));
//			response.sendRedirect(request.getHeader("referer"));
				response.getWriter().println(1);//这儿是干什么？
			}else{
				response.getWriter().println(0);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
