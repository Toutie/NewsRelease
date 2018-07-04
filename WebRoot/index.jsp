<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="h" uri="http://www.hyd.com/myTag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    
    <style>
    	.list li{
    		list-style-type:none;
    	}
    	.list li .icon {
		    display: block;
		    width: 15px;
		    height: 15px;
		    margin: 14px 0 14px 45px;
		    -webkit-border-radius: 50%;
		    -moz-border-radius: 50%;
		    border-radius: 50%;
		    background: #FFCC33;
		}
		
		.list li a {
		    width: 280px;
		    white-space: nowrap;
		    -ms-text-overflow: ellipsis;
		    text-overflow: ellipsis;
		    overflow: hidden;
		    height: 44px;
		    line-height: 44px;
		    margin: 0 40px 0 10px;
		    color: #0099FF;
		    font-size: 16px;
		}
		
		.list li * {
   			 float: left;
		}
		
		.list li .time {
		    display: block;
		    height: 46px;
		    line-height: 46px;
		    font-size: 16px;
		    color: #0099FF;
		}
    </style>
  </head>
  
  <body>
    
	<h:module type="t001"></h:module>  	
  	<h:module type="t002"></h:module>
  	<h:module type="t003"></h:module>
	
  </body>
</html>
