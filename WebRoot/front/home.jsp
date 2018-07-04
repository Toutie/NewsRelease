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

	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
	
	<!-- 轮播 css -->
	<link rel="stylesheet" href="../nivo-slider/nivo-slider.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="../nivo-slider/style.css" type="text/css" media="screen" />
	
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
	<script src="../bootstrap/js/jquery-3.3.1.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body class="home-page">
  	<div>
  		<div id="header"><%@ include file="/front/common/header.jsp" %></div>  		
  	</div>
  	
  	<div id="myCarousel" class="carousel slide container">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   

	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="../nivo-slider/images/pic2.jpg"  alt="First slide">
		</div>
		<div class="item">
			<img src="../nivo-slider/images/pic1.jpg" alt="Second slide">
		</div>
		<div class="item">
			<img src="../nivo-slider/images/pic3.jpg" alt="Third slide">
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
