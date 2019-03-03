package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.NewMsgService;

public class ReadMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReadMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));
		if(new NewMsgService().makeMsgOld(mid)){
			response.getWriter().println(1);
			return;
		}else{
			response.getWriter().println(0);
			} 
//		response.getWriter().println(1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
