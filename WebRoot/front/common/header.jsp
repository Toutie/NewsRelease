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
		}
	</style>
  </head>
  
  <body>
    <div class="">
    	<div class="logo" id="logo" align="center">
    		<image src="/NewsRelease/image/logo2.jpg"  />
    		
    	</div>
     </div>	
    


    <div class="container-fluid" id="menu">
 			<ul class="nav navbar-nav" >
    		<li align="center" ><a href="/NewsRelease/front/home.jsp">首        页</a></li>
    		<li><a href="/NewsRelease/NewsListServlet?type=t001">学 院 动 态</a></li>
    		<li><a href="/NewsRelease/NewsListServlet?type=t002">学 术 新 闻</a></li>
    		<li><a href="/NewsRelease/NewsListServlet?type=t003">学 风 建 设</a></li>
    		<li><a href="/NewsRelease/login.html">个 人 中 心</a></li>
    	</ul>

    </div>

  </body>
</html>
