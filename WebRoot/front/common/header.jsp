  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Header</title>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
	
	<style type="text/css">
		#menu ul li{
			width:250px;
			text-align:center;
			font-size:20px;
		}
	</style>
  </head>
  
  <body>
    <div>
    	<div class="logo" id="logo" align="center">
    		<image style="height:160px;width:100%;" src="/NewsRelease/image/myWebTop.jpg"/>
    	</div>
    </div>	

    <div class="nav-bar" role="navigation" id="menu" style="border:outset;">
    	<div class="container-fluid">
 			<ul class="nav navbar-nav" >
    		<li align="center" ><a href="/NewsRelease/front/home.jsp">首        页</a></li>
    		<li><a href="/NewsRelease/NewsListServlet?type=t001">学 院 动 态</a></li>
    		<li><a href="/NewsRelease/NewsListServlet?type=t002">学 术 新 闻</a></li>
    		<li><a href="/NewsRelease/NewsListServlet?type=t003">学 风 建 设</a></li>
    		<li><a href="/NewsRelease/console/main.jsp">个 人 中 心</a></li>
    	</ul>
    	</div>
    </div>

  </body>
</html>
