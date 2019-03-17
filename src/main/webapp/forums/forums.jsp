<%@page import="com.heygis.beans.ForumThread"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.heygis.beans.ForumsThreadPage" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	ForumsThreadPage threadPage = (ForumsThreadPage)request.getAttribute("threadPage");
	SimpleDateFormat formatter = new SimpleDateFormat ("yy-MM-dd HH:mm:ss"); 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
		<script type="text/javascript" src="js/forums.js"></script>
		<!--script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script-->
		<script type="text/javascript" src="forums/google-code-prettify/prettify.js"></script>
		<link href="forums/google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
		<!--link rel="stylesheet" type="text/css" href="css/css.css"-->
		<link rel="stylesheet" type="text/css" href="css/loginStyle.css" />
		<link rel="stylesheet" type="text/css" href="css/forums.css" />
		<link rel="stylesheet" type="text/css" href="css/navCSS.css" />
	</head>

	<body>
		<div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle newMsgMark hidden" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="badge">0</span>
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
						<li class="active">
							<a href="###">论坛区</a>
						</li>
						<li>
							<a href="sourceServlet?index=panel-1">资源区</a>
						</li>
						<li>
							<a href="index.jsp#lkdVR">林科大全景</a>
						</li>
				<%if((Boolean)request.getAttribute("loged")){ %>
						<li>
							<a href="selfCenterServlet">个人中心<span class="badge hidden">0</span></a>
						</li>
						<li>
							<a class="btn" href="javascript:document:logout.submit()" >退出</a>
						</li>
				<%}else{ %>
						<li>
							<a class="btn theme-login" href="javascript:;">登录</a>
						</li>
						<li>
							<a class="btn " href="register.jsp">注册</a>
						</li>
					<%} %>
					</ul>
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
							<input class="ipt" type="password" name="password" value="" placeholder="密码" size="20" />
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" value=" 登 录    " />
							<a href="register.jsp">&nbsp;注册</a>
						</li>
					</ol>
				</form>
				<form id="logout" method="post" action="logoutServlet">
					<INPUT TYPE="submit" name="test" value = "go" style="display:none"> 
				</form>
			</div>
		</div>
		<div class="theme-popover-mask">
		</div>
		<div class="forums_wraper container">
			<div class="row">
				<div class="forums_title col-md-10 col-sm-12 col-center-block">
					<h1 style="font-size: 30px;">
					<%if(threadPage.getFid()==1){ %>>
						<span>论坛-课堂区</span>
					<%}else if(threadPage.getFid()==2){ %>>
						<span>论坛-讨论区</span>
					<%}else if(threadPage.getFid()==3){ %>>
						<span>论坛-灌水区</span>
					<%}%>
					</h1>
				</div>
				<div  class="col-md-10 col-sm-12 col-center-block thread_path">
						<p>前往 ： </p>
						<a href="index.jsp"> 主页  >  </a>
						<a href="forumsServlet?fid=1&page=1">课堂区 </a>
						<a href="forumsServlet?fid=2&page=1">讨论区 </a>
						<a href="forumsServlet?fid=3&page=1">灌水区 </a>
						<div class="clear"></div>
				</div>
				<div class="thread_list col-md-10 col-sm-12 col-center-block">
					<div class="thread_content">
						<table class="table table-striped thread">
						    <thead>
							   	<tr class="hidden-xs">
	    					        <th style="padding-left: 20px;" class="col-md-6 col-sm-6 thread_th">标题</th>
							        <th style="text-align: center;" class="col-md-2 hidden-xs">发帖人</th>
							        <th style="text-align: center;" class="col-md-2 hidden-xs">回复数</th>
							        <th style="text-align: center;" class="col-md-2 hidden-xs">最后回复</th>
							    </tr>
						    </thead>
						    <tbody>
						    	<%
						    	ForumThread thread = null;
							    for(int i=0;i<30;i++){
									if(threadPage.getThread(i) == null)
										break;
									thread = threadPage.getThread(i);
								%>
								<tr>
									<td style="padding-left: 20px;" class="thread_title">
										<a href='topicsServlet?fPage=<%=threadPage.getPage() %>&tid=<%=thread.getTid() %>&page=1'>
								    		<%=thread.getSubject() %>
								    	</a>
								    	<hr class="visible-xs phon-visible-hr"/>
								    	<span class="visible-xs phone-visable-author">
								    		<%=thread.getAuthor()%>
								    	</span><nobr/>
								    	<span class="visible-xs phone-visable-authorralies">
								    		<%=formatter.format(thread.getDateline()) %> | 回复：<%=thread.getReplies() %>
								    	</span>
								    </td>
							        <td class="threa_author hidden-xs">
							         	<%=thread.getAuthor()%>
							         	<br>
							         	<span>
							         		<%=formatter.format(thread.getDateline()) %>
							         	</span>
							        </td>
							        <td class="replies hidden-xs">
							        	<%=thread.getReplies() %>
							        </td>
							        <td class="last_post hidden-xs">
							         	<span>
							         		<%=formatter.format(thread.getLastpost()) %>
							         	</span>
							         	<br>
							         	by:<%=thread.getLastposter() %>
							        </td>
							    </tr>
							    <tr class="visible-xs"><td style="background-color: #CCCCCC;"></td></tr>
							    <tr class="visible-xs"><td  style="padding :0px;"></td></tr>
								<%} %>
						    </tbody>
						</table>
					</div>
				</div>
				<div class="col-md-10 col-sm-12  col-center-block">
					<div style="float:left;padding:5px 10px 15px 10px">
						<a style="color:white" href="javascript:last();">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a style="color:white" href="javascript:next();">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a style="color:white;">共<%=threadPage.getTotalPageNum()%>页</a>
					</div>
				</div>
			</div>
		</div>
		
		<a id="anchor_scroll" href="#pos" style="display:none"></a>
		<div id="pos"></div>
		<div id="thread_public" class="thread_public_wraper container hidden-xs">
				<div class="row">
				<form action='addThreadServlet?fid=<%=threadPage.getFid() %>' method="post" id="threadpublic"> 
					<div class="thread_public_content col-center-block col-md-10 col-sm-12">
						<div style="height: auto;">
							<div class="thread_subject col-md-9 col-sm-12">
								<textarea id="thread_subTextarea" name='subject' placeholder="发表新帖：标题" required></textarea>
							</div>
							<div class="clear"></div>
						</div>
						<div id="textarea" style="height: auto;">
							<div class="post_reply_textarea col-md-9 col-sm-12">
								<!--<a herf="#">添加表情</a>-->
								<p>|</p>
								<a onclick="openCode()" class="codeA">添加代码
									<div id="codeDiv">
										<textarea class="codetext form-control" id="code-text" ></textarea>
										<div>
											<a class="btn btn-xs btn-primary codebtn" onclick="addCode()">确定</a>
											<a class="btn btn-xs btn-danger codebtn" onclick="closeCode()">取消</a>
										</div>
									</div>
								</a>
								<p>|</p>
								<a onclick="openImg()" class="codeA">添加图片
									<div id="imgDiv">
										<input type="file" id="file" value="选择图片" class="btn-sm btn-primary myfile"/>
										<a  class="btn btn-sm btn-primary imgbtn" onclick="javascript:alert('sorry,该功能还未上线')">确定</a>
										<a  onclick="closeImg()" class="btn btn-sm btn-danger imgbtn" >取消</a>
									</div>
								</a>
								<textarea id="post_textarea" name='message' placeholder="发表新帖：标题" required></textarea>
							</div>	
							<div class="clear"></div>
						</div>
						<div id="submit">
							<input type="button" class="post_reply_submit btn btn-primary" value="发表" onclick="threadpublic()"/>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
		<div class="visible-xs phone-visible-margine"></div>
		<div id="footer" class="visible-xs container">
			<nav class="navbar navbar-default navbar-fixed-bottom">
			    <div class="navbar-inner navbar-content-center">
			        <button type="button" onclick="public()" id="public" class="thread_public_button visible-xs btn btn-primary btn-lg btn-block">
						发帖
					</button>
			    </div>
			</nav>
		</div>
	</body>
	<script type="text/javascript" src="js/newMsg.js"></script>
	<script>
		var loged = <%=request.getAttribute("loged") %>;
		var uid = <%=request.getAttribute("uid")%>
		var totalPage = <%=threadPage.getTotalPageNum()%>;
	</script>
</html>