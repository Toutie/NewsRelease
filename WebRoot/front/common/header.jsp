  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Header</title>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
	
  </head>
  	<style>
  		nav{
  			box-shadow:4px 4px 10px #778899;
  		}
  	</style>
  <body>
    <div>
    	<div class="logo" id="logo" align="center">
    		<image style="height:125px;width:100%;" src="/NewsRelease/image/myWebTop.jpg"/>
    	</div>
    </div>	

	<nav class="navbar navbar-default">
		<div class="container">
			<!--商标 -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        			<span class="sr-only">Toggle navigation</span>
       				<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
      			</button>
      			<a class="navbar-brand" href="/NewsRelease/front/home.jsp">首 页</a>
			</div>
			
			<!-- 展开收缩式 -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!-- 学院概述 -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							学院概述 
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="/NewsRelease/NewsListServlet?type=t001">学 院 动 态</a>
							</li>
						</ul>
					</li>
					
					<!-- 学术科研 -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							学术科研
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="/NewsRelease/NewsListServlet?type=t002">学 术 新 闻</a>
							</li>
						</ul>
					</li>
					
					<!-- 学风建设 -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							学风建设
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="/NewsRelease/NewsListServlet?type=t003">学 风 建 设</a>
							</li>
						</ul>
					</li>
					
					<!-- 师资队伍 -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							师资队伍
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">教授</a></li>
							<li><a href="#">副教授</a></li>
							<li><a href="#">讲师</a></li>
							<li><a href="#">班主任</a></li>
							<li><a href="#">辅导员</a></li>
							
						</ul>
					</li>
					
					<!-- 本科招生 -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							本科招生
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">2018招生简章</a></li>
							<li><a href="#">2+2国际版</a></li>
							<li><a href="#">专业设置</a></li>
							<li><a href="#">就业情况</a></li>
							<li><a href="#">名师风采</a></li>
							
						</ul>
					</li>
					
					<!-- 学生天地 -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							学生天地
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">大学科技创新管理中心</a></li>
							<li><a href="#">思源工作室</a></li>							
						</ul>
					</li>
					
					<!-- 个人中心 -->
					<li>
						<a href="/NewsRelease/console/main.jsp">个 人 中 心</a>
					</li>
					
				</ul>
			</div>
		
		</div>
	</nav>

  </body>
</html>
