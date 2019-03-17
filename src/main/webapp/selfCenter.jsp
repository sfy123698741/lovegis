<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.heygis.beans.ForumMsgPage"%>
<%@ page import="com.heygis.beans.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getSession().getAttribute("user");
ForumMsgPage fMsgPage = (ForumMsgPage)request.getAttribute("fMsgPage");
SimpleDateFormat formatter = new SimpleDateFormat ("yy-MM-dd HH:mm:ss");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>heygis-个人中心</title>
    
	<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		\		 
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/selfCenterJS.js"></script>
		<script type="text/javascript" src="js/cropbox.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/selfCenterStyle.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
		<div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle newMsgMark hidden" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="badge  hidden">0</span>
					</button>
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><span class="heygis">HeyGIS</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.jsp">首页</a>
						</li>
						<li>
							<a href="index.jsp#bbs">论坛区</a>
						</li>
						<li>
							<a href="sourceServlet">资源区</a>
						</li>
						<li>
							<a href="index.jsp#lkdVR">林科大全景</a>
						</li>
				<%if((Boolean)request.getAttribute("loged")){ %>
						<li>
							<a class="active" href="selfCenterServlet">个人中心<span class="badge hidden">0</span></a>
						</li>
						<li>
							<a class="btn" href="javascript:document:logout.submit()" >退出</a>
						</li>
				<%}else{ %>
						<li>
							<a class="btn theme-login" href="javascript:;">登录</a>
						</li>
						<li>
							<a class="btn " href="javascript:;">注册</a>
						</li>
					<%} %>
					</ul>
				</div>
			</div>
		</div>
		<br /><br /><br /><br />
		<div class="section Top mainbody" id="mainbody">
	      <div class="container">
	      	<h1 class="text-primary"><span class="glyphicon glyphicon-user"></span>个人中心</h1><br />
	        <div class="row ">
	          	<div class="col-sm-12 col-md-5">
		          	<div class="col-sm-5">
	          			<img src="<%=user.getIconImg() %>" class="img-responsive iconImg" /><br />
		          		<a class="btn btn-primary btn-block" id="fillInfo" href="fillInfo.jsp">完善信息</a>
		          		<button class="btn btn-primary btn-block" id="modifyIcon">修改头像</button>
		          	</div>
		          	<div class="col-sm-7 userInfo">
		          		<table class="table">
		          			<th>用户信息</th>
							<tr>
								<td>账号</td>
								<td><%=user.getAccount()%></td>
							</tr>
							<tr>
								<td>个性签名</td>
								<td><%=user.getSelfIntroduction() %></td>
							</tr>
							<tr>
								<td>昵称</td>
								<td><%=user.getNickName() %></td>
							</tr>
							<tr>
								<td>性别</td>
								<td><%=user.getGender() %></td>
							</tr>
							<tr>
								<td>入学年份</td>
								<td><%=user.getGrade() %></td>
							</tr>
							<tr>
								<td>QQ</td>
								<td><%=user.getQQ() %></td>
							</tr>
							<tr>
								<td id="pod">电话</td>
								<td><%=user.getTel() %></td>
							</tr>
						</table>
		          	</div>
	         	</div>
	          	<div class="col-sm-12 col-md-7"">
	          		<div class="tabs">
						<div class="">
							<div class="tabbable" id="tabs">
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#panel-1" data-toggle="tab">未读信息</a>
									</li>
									<li class="">
										<a href="#panel-2" data-toggle="tab" onclick="showOldMsg()">已读信息</a>
									</li>
									<li class="">
										<a href="#panel-3" data-toggle="tab" onclick="showMyThread()">我的发帖</a>
									</li>
								</ul>
							</div>
							<div class="tab-content row">
									<div class="tab-pane active" id="panel-1">
										<div id="newMsgList" class="list">
										<%for(int i=0; i< fMsgPage.getSize();i++){ %>
											<div class="message-cotent">
												<div class="col-md-9 col-xs-9 message-detail">
													<a onclick="return readMsg(<%=fMsgPage.getMsg(i).getMid() %>)" href="topicsServlet?fPage=1&tid=<%=fMsgPage.getMsg(i).getTid() %>&page=<%=fMsgPage.getMsg(i).getPage()%>&seeposi=<%=fMsgPage.getMsg(i).getPosition()%>#position<%=fMsgPage.getMsg(i).getPosition()-1%>">
												<%if(fMsgPage.getMsg(i).getType() == 1){ %>
														<%=fMsgPage.getMsg(i).getAuthor() %><br/>在主题”<%=fMsgPage.getMsg(i).getSubject() %>“中回复了你!												
												<%}else if(fMsgPage.getMsg(i).getType() == 2){ %>
														<%=fMsgPage.getMsg(i).getAuthor() %><br/>回复了你在”<%=fMsgPage.getMsg(i).getSubject() %>“中的回复!
												<%} %>
													</a>
												</div>
												<div class="col-md-3 col-xs-3 message-date">
													<p ><%=formatter.format(new Date(fMsgPage.getMsg(i).getDateline())) %></p>
												</div>
											</div>
										<%} %>
										</div>
										<div id="newMsgInfo">
										<%if(fMsgPage.getSize() == 0){%>
											<p style='color:white;font-size:17px'>没有更多了！</p>
										<%} %>
										</div>
										<a href="javascript:getNewMsg();" class='seemore' onclick="">查看更多</a>
									</div>
									<div class="tab-pane" id="panel-2">
										<div id ="oldMsgList" class="list"></div>
										<div id="oldMsgInfo"></div>
										<a href="javascript:getOldMsg();" class='seemore'>查看更多</a>
									</div>
									<div class="tab-pane" id="panel-3">
										<div id="myThreadList" class="list">
										</div>
										<div id="myThreadInfo"></div>
										<a href="javascript:getMyThread();" class='seemore'>查看更多</a>
									</div>
								</div>
						</div>
					</div>
	          	</div>
	        </div>
	      </div>
	    </div>
		<div class="container-fluid footer">
			<div class="container row-fluid foot">
				<div class="col-md-4  col-sm-6 foot-left">
					<h1 class="footh1">联系我们</h1> Email:heygis@163.com
					<br /> QQ:12345678
					<br /> Address:长沙市韶山南路498号中南林业科技大学
					<br />
				</div>
				<div class="col-md-4  col-sm-6 foot-right">
					<h1 class="footh1">相关链接</h1> 
					<a href="feedbackServlet">意见反馈</a>
					<br /> <a href="aboutWeb.jsp">关于本网站</a>
					<br /> <a href="aboutMaker.jsp"> 关于制作者</a>
					<br />
				</div>
				<div class="col-md-4  col-sm-12 shenming">
					<span>注意：本站资源均来源于原创或网络,如有侵权请联系站长清除。</span>
					<br />
					<a href="http://www.miibeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">湘ICP备16006264</a>

				</div>
			</div>
		</div>
		<div class="theme-popover col-md-12">
			<div class="theme-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<h3>登录 是一种态度</h3>
			</div>
			<div class="theme-popbod dform">
				<form id="loginForm" class="theme-signin" name="loginform"  method="post" onsubmit="return login()">
					<ol>
						<li>
							<h4 id="loginMessage">你必须先登录！</h4>
						</li>
						<li><strong>用户名：</strong>
							<input class="ipt" type="text" name="account" value="" size="20" placeholder="账号（邮箱）"/>
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="password" value="" size="20" placeholder="密码"/>
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" value=" 登 录 " />
						</li>
					</ol>
				</form>
				<form id="logout" method="post" action="logoutServlet">
					<INPUT TYPE="submit" name="test" value = "go" style="display:none"> 
				</form>
			</div>
		</div>
		<div id="changeIcon" class="col-md-12">
			<div class="theme-poptit" id="theme">
				<a href="javascript:;" title="关闭" id="close" class="close">×</a>
				<h3>修改头像</h3>
			</div>
			<div class="">
				<div class="imageBox">
					<div class="thumbBox"></div>
					<div class="spinner" style="display: none">Loading...</div>
				</div>
				<div class="action">
					<input type="file" id="file" class="btn btn-primary">
					<div class="col-xs-4 iconbtn">
						<button id="btnZoomIn" class="btn btn-primary btn-block">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</div>
					<div class="col-xs-4 iconbtn">
						<button id="btnZoomOut" class="btn btn-primary btn-block">
							<span class="glyphicon glyphicon-minus"></span>
						</button>
					</div>
					<div class="col-xs-4 iconbtn">
						<form id="form1" action="userIconServlet" method="post">
							<input type="button" id="btnCrop" value="确定" class="btn btn-primary btn-block">
							<textarea class="rrr" form="form1" name="imgURL"></textarea>
						</form>	
					</div>
				</div>
			</div>
		</div>
		<div class="theme-popover-mask"></div>
	</body>
	<!--<script type="text/javascript" src="js/newMsg.js"></script>-->
	<script>
		var loged = <%=request.getAttribute("loged") %>;
		var uid = <%=request.getAttribute("uid")%>
	</script>
</html>
