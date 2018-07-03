<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="http://www.hyd.com/myTag" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>新闻发布网站</title>
    <meta charset="UTF-8">
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<meta name="keywords" content="新闻发布网站">
	<meta name="description" content="新闻发布网站">

	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
	
	<style>
		ul li{
			list-style:none;
		}
		.time{
		   display:inline-block;
		   height: 46px;
		   white-space: nowrap;
		   line-height: 46px;
		   font-size: 16px;
		   color: #0099FF;
		}
		
		.icon{
			display: inline-block;
		    width: 15px;
		    height: 15px;
		    margin: 14px 0 14px 45px;
		    -webkit-border-radius: 50%;
		    -moz-border-radius: 50%;
		    border-radius: 50%;
		    background: #FFCC33;
		}
		.title{
			width: 15em;
		    white-space: nowrap;
		    -ms-text-overflow: ellipsis;
		    text-overflow: ellipsis;
		    overflow: hidden;
		    height: 44px;
		    line-height: 44px;
		    margin: 0 40px 0 10px;
		    color: #0099FF;
		    font-size: 16px;
		    display:inline-block;
		}
	</style>
  </head>
  
  <body class="home-page">
  	<div>
  		<div id="header"><%@ include file="/front/common/header.jsp" %></div>  		
  	</div>
  	
	<h:module type="t001"></h:module>  	
  	<h:module type="t002"></h:module>
  	<h:module type="t003"></h:module>
 	
 	<div>
 		<div id="footer"><%@ include file="/front/common/footer.jsp" %></div>
 	</div>
  </body>
</html>
