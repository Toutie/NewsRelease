<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${news.title }</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
  </head>
  
    <body class="home-page">
  	<div>
  		<div id="header"><%@ include file="/front/common/header.jsp" %></div>  		
  	</div>
  	
	<div id="body">
		<div id="newsTitle" class="text-center">
			<h1>${news.title }</h1>
		</div>
		<div id="newsAttr" class="text-center">
			新闻类型：${news.type }&nbsp;&nbsp;编辑作者：${news.username }&nbsp;&nbsp;发布时间：${news.time }&nbsp;&nbsp;点击量：${news.click }
		</div>
		<hr />
		<div id="newsContent" class="container">
			${news.content }
		</div>
	</div>
 	
 	<div>
 		<div id="footer"><%@ include file="/front/common/footer.jsp" %></div>
 	</div>
  </body>
</html>
