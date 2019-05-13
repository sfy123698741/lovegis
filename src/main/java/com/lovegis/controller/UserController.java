package com.lovegis.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.heygis.beans.ForumMsgPage;
import com.heygis.beans.NewMember;
import com.heygis.beans.User;
import com.heygis.service.FillInfoService;
import com.heygis.service.NewMsgService;
import com.lovegis.service.PersonalCenterService;
import com.lovegis.service.UserInformationService;;
@Controller
@SessionAttributes({"loged","user"})
@RequestMapping("/User")
public class UserController {
	
	@Resource PersonalCenterService personalCenterService;
	@Resource UserInformationService  userInformationService;
	@RequestMapping("/selfCenter")
	public String  selfCenter (@SessionAttribute("loged") Boolean loged,@SessionAttribute("uid") Integer uid, Model model) throws IOException, ServletException {
		//request.getAttribute("loged")
		if(!loged){//如果已经登入
			//response.sendRedirect("index.jsp");
			 return "redirect:/index.jsp";
		}
		
		//request.getAttribute("uid").toString()
		//获取参数uid
		ForumMsgPage fMsgPage =  personalCenterService.getMsgPage(uid, 1, 1);//数据操作
		model.addAttribute("fMsgPage", fMsgPage);//绑定参数
		
		/*RequestDispatcher dis =  request.getRequestDispatcher("selfCenter.jsp"); //获取
		dis.forward(request, response);//重定向
		*/
		return "forward:/selfCenter.jsp";
	}
	@RequestMapping("/ReadMsg")
	public void ReadMsg(int mid ,HttpServletResponse response){
		//	int mid = Integer.parseInt(request.getParameter("mid"));
		try {
			if(new NewMsgService().makeMsgOld(mid)){
				response.getWriter().println(1);
				return;
			}else{
				response.getWriter().println(0);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
			
		}
	@RequestMapping("/NewMsg")
public void NewMsg(int nw,int uid ,HttpServletResponse response){
	
		
		try {
			if(nw == 1){
				int num =personalCenterService.howManyNewMsg(uid);
				response.getWriter().println(num);
				return ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	@RequestMapping("/register")
	public String register(String account,String passWord,String nickName,String grade,Model model,HttpServletResponse response) throws IOException, ServletException, NoSuchAlgorithmException {
//		String account = request.getParameter("account1");
//		String passWord = request.getParameter("passWord");
//		String nickName = request.getParameter("nickName");
//		String grade = request.getParameter("grade");
//		RegisterService registerServer = new RegisterService();
		int result = userInformationService.addUser(account, passWord, nickName, grade);
		if(result == 1){
			System.out.println("suce");
//			LoginService loginService = new LoginService();
//			request.getSession().setAttribute("loged",true);
//			request.getSession().setAttribute("user",loginService.getUser(account));//将信息提交到个人中心页面。
			model.addAttribute("loged",true);
			model.addAttribute("user",userInformationService.getUser(account));
//			response.sendRedirect("selfCenterServlet");
			return "redirect:/selfCenter"; 
		}else{
			model.addAttribute("message", "注册失败");
//			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
//			dis.forward(request, response);
			return  "forward:/result.jsp";
		}
	}
	@RequestMapping("/joinUS")
	public String  joinUS(Model model, NewMember member) {
		
		/*System.out.println("in");
		NewMember member = new NewMember();
		member.setName(request.getParameter("name"));
		member.setProfession(request.getParameter("profession"));
		member.setTel(request.getParameter("tel"));
		member.setQQ(request.getParameter("QQ"));
		member.setOther(request.getParameter("other"));
		member.setSelfIntro(request.getParameter("selfIntro"));
		member.setGoal(request.getParameter("goal"));*/
		boolean result = userInformationService.addMember(member);
		if(result){
//			request.getRequestDispatcher("success.jsp").forward(request, response);
		return "forward:/success.jsp";
		}else{
			System.out.println("报名失败！");
			model.addAttribute("message", "你有不规范的填写，请重新填写！！");
//			request.getRequestDispatcher("result.jsp").forward(request, response);
			return "forward:/result.jsp";
		}
			
		}
	@RequestMapping("/fillInfo")
	public String fillInfo( Model model,User user ,@SessionAttribute("user") User Sessionuser) {
		/*User user = new User(
				((User)request.getSession().getAttribute("user")).getUid(),
				request.getParameter("account"),
				request.getParameter("nickName"),
				request.getParameter("grade"),
				request.getParameter("optionsRadios"),
				request.getParameter("QQ"),
				request.getParameter("tel"),
				request.getParameter("selfintroduction"),
				((User)request.getSession().getAttribute("user")).getIconImg());*/
		user.setUid(Sessionuser.getUid());
		user.setIconImg(Sessionuser.getIconImg());
		if(new FillInfoService().fillInfo(user)){
			model.addAttribute("user", user);
			 return "redirect:/selfCenter";
//			response.sendRedirect("selfCenterServlet");
		}else{
			model.addAttribute("message", "修改个人信息错误！");
			return "forward:/result.jsp";
//			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
	@RequestMapping("/userIcon")
	public String userIcon(Model model,@SessionAttribute("user") User Sessionuser,String imgURL) {
//		String base64 = request.getParameter("imgURL");
		String	base64 = imgURL.substring(22,imgURL.length());
		
//		User user = (User)request.getSession().getAttribute("user");
		boolean bool = userInformationService.updateImg(Sessionuser, base64);
		if(bool){
			Sessionuser.setIconImg("/heygis_img/icon/"+Sessionuser.getAccount()+"_img.jpg");
			model.addAttribute("user", Sessionuser);
			 return "redirect:/selfCenter";
//			request.getSession().setAttribute("user", user);
//			response.sendRedirect("selfCenterServlet");
		}else{
			System.out.println("die");
			model.addAttribute("message", "修改个人信息错误！");
			return "forward:/result.jsp";
		}
	}
	@RequestMapping("/selfCenter")
	public void Login(Model model,String account,String password,HttpServletResponse response) throws UnsupportedEncodingException, IOException {
//		String account = request.getParameter("account");
//		String password = request.getParameter("password");
//		LoginService loginService = new LoginService();
		try {
			if(userInformationService.login(account, password))
//			if(loginService.login(account,password)){
			{	model.addAttribute("loged",true);
				model.addAttribute("user",userInformationService.getUser(account));
				response.getWriter().println(1);//这儿是干什么？
			}
//				request.getSession().setAttribute("loged",true);
//				request.getSession().setAttribute("user",loginService.getUser(account) );
//			System.out.println(request.getHeader("referer"));
//			response.sendRedirect(request.getHeader("referer"));
				else{
					response.getWriter().println(0);
				}
			}
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@RequestMapping("/Logout")
	public String Logout( HttpServletRequest request,SessionStatus sessionStatus) {
		System.out.println("logout");
		//request.getSession().invalidate();
		sessionStatus.setComplete();
		
		return "forward:/"+request.getHeader("referer");
//		System.out.println(request.getHeader("referer"));
//		response.sendRedirect(request.getHeader("referer"));
		}
}
