package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.ForumPostPage;
import com.heygis.service.TopicsService;

public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopicsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fPage = 1,page = 1,tid = 0;
		try {
			if(request.getParameter("fPage") != null){
				fPage = Integer.parseInt(request.getParameter("fPage"));
			}
			page = Integer.parseInt(request.getParameter("page"));
			tid = Integer.parseInt(request.getParameter("tid"));
		} catch (Exception e) {
			error("该帖访问失败", request, response);
			return;
		}
//		System.out.println(tid);
		TopicsService ts = new TopicsService();
		ForumPostPage postPage = ts.getPostPage(tid, page);
		postPage.setfPage(fPage);
//		System.out.println(postPage.getPost_number());
		if(postPage.getSize() != 0){
			request.setAttribute("postPage", postPage);
			RequestDispatcher dis = request.getRequestDispatcher("/forums/topics.jsp");
			dis.forward(request, response);
		}else{
			error("帖子这一页空了,分页系统还需要迭代", request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	void error(String msg,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("message", msg);
		RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
		dis.forward(request, response);
	}

}
