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

	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
	<script src="../bootstrap/js/jquery-3.3.1.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../bootstrap/js/float.js"></script>
	

	
	<style>
	
		#info-panel{
			box-shadow: 0 0 10px #708090;
		}
    
   		.list li * {
   			 float: left;
		}
		
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
		    width: 20em;
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
		
		
		
		.list li .time {
		    display: block;
		    height: 46px;
		    line-height: 46px;
		    font-size: 16px;
		    color: #0099FF;
		}
		
		.home-page{
			background-color:#FFFFFF;
		}
		
		
    </style>
	
	
  </head>
  
  <body class="home-page">
  	<!-- 头部   -->
  	<div>
  		<div id="header"><%@ include file="/front/common/header.jsp" %></div>  		
  	</div>
  	
  	<!-- 浮窗  -->
	<%@ include file="./common/float.jsp" %> 
        
  	<div id="myCarousel" class="carousel slide container">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   

	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active" align="center">
			<img style="height:320px;" src="../image/login.png"  alt="First slide">
		</div>
		<div class="item" align="center">
			<img style="height:320px;" src="../image/logo2.jpg" alt="Second slide">
		</div>
		<div class="item" align="center">
			<img style="height:320px;" src="../image/myWebTop.jpg" alt="Third slide">
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div> 
  	<br/>
  
	<h:module type="t001"></h:module>  	
  	<h:module type="t002"></h:module>
  	<h:module type="t003"></h:module>
 
 	<div>
 		<div id="footer"><%@ include file="/front/common/footer.jsp" %></div>
 	</div>
  </body>
</html>
