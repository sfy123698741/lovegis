package com.heygis.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumThread;
import com.heygis.beans.User;
import com.heygis.service.ForumsService;

/**
 * Servlet implementation class AddThreadServlet
 */
public class AddThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddThreadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loged") == null){
			request.setAttribute("message", "请先登录");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
			return;
		}
		
		/*
		 List<String> parameter = new ArrayList<String>();
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				FileItem item = (FileItem)iter.next();
				item.getInputStream();
				if(!item.isFormField()){
					String desFileName = "C:/myjava/"+item.getName();
					item.write(new File(desFileName));
					//System.out.println("jinlail");
				}else{
					String value = item.getString();
					value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
					parameter.add(value);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 */
		int fid = Integer.parseInt(request.getParameter("fid")); //获取参数
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
		User user = (User)request.getSession().getAttribute("user"); //从缓存中获取数据
		String author = user.getNickName();
		int authorUid = user.getUid();
		String authorAccount = user.getAccount();
//		System.out.println(author+authorUid+authorAccount);
		ForumThread thread = new ForumThread(0, fid, 0, 0, author, authorUid, authorAccount, subject, 
				new Date(), new Date(), "", 0, 0, 0, 0, 0, 1);  // new一个新的been来存放数据
		ForumPost post = new ForumPost(0, fid, 0, 1, author, authorUid, authorAccount, subject,
				new Date(), message, request.getRemoteAddr(), attchment, 0);
		if(new ForumsService().addthread(thread, post)){  //调用service 添加方法来添加数据，参数是bean
			response.sendRedirect(request.getHeader("referer"));
		}else{
			request.setAttribute("message", "发帖失败");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");//错误页面
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);  //本来是get，post分开写，但是一样的代码就直接调用了
	}

}
