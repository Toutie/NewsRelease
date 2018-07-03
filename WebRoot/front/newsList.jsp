<%@page import="StringUtil.StringUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>
    	<%session.getAttribute("type"); %>
    </title>

	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
	
  </head>
  
   <body class="home-page">
  	<div>
  		<div id="header"><%@ include file="/front/common/header.jsp" %></div>  		
  	</div>
  
	<!-- 内容 -->
		<div id="page-wrapper">
    		<div id="page-inner">
    			<div>
    				<ol class="breadcrumb">
 						<li class="active"><a href="/NewsRelease/front/home.jsp">首页</a></li>
 						<li class="active"><a href="/NewsRelease/servlet/NewsListServlet?curPage=1&type=${type }">${chineseType }</a></li>
					</ol>
    			</div>
    			<hr/>
     			<!-- 我的通知 -->
        		<div id="myNotice" class="text-center">
        			<table class="table table-hover table-bordered">
        				<!-- 表头  -->
        				<tr>
        					<th>标题</th>
        					<th>作者</th>
        					<th>时间</th>
        					<th>点击量</th>
        				</tr>
        				<c:forEach items="${newsList}" var="list">
        					<tr>
        						<td>
        							<a href="/NewsRelease/servlet/NewsDetailServlet?newsid=${list.newsid}">
        								<c:out value="${list.title}"/>
        							</a>
        						</td>
        						<td><c:out value="${list.username}"/></td>
        						<td><c:out value="${list.time}"/></td>
        						<td><c:out value="${list.click}"/></td>
        					</tr>
        				</c:forEach>
        			</table>	
        		</div>
        		<!-- /我的通知 -->	
        		<!-- 页码导航 -->
        		<div id="pageNavication" class="text-center">
        			<ul class="list-inline">
        				<li>
        					<a href="/NewsRelease/servlet/NewsListServlet?curPage=1&type=${type }">
        						<button class="btn btn-default">	
        						首页
        						</button>
        					</a>
        				</li>
        				<li>
        					<a href="/NewsRelease/servlet/NewsListServlet?curPage=${curPage-1}&type=${type }">
        						<button class="btn btn-default">	
        						前一页
        						</button>
        					</a>
        				</li>
        				
        				<c:forEach var="i" begin="${beginPage}" end="${endPage}">
        					<li>
        					  <c:if test="${i==curPage}">	
        							<c:out value="${i}" ></c:out> 
        					  </c:if>
        					  
        					  <c:if test="${i!=curPage}">
        						<a href="/NewsRelease/servlet/NewsListServlet?curPage=${i}&type=${type }">
        							<button class="btn btn-default">	
        								<c:out value="${i}"></c:out> 
        							</button>
        						</a>
        					  </c:if>
        					</li>
        				</c:forEach>
        				
        				<li>
        					<a href="/NewsRelease/servlet/NewsListServlet?curPage=${curPage+1}&type=${type }">
        						<button class="btn btn-default">	
        						后一页
        						</button>
        					</a>
        				</li>
        				<li>
        					<a href="/NewsRelease/servlet/NewsListServlet?curPage=${newsPage}&type=${type }">
        						<button class="btn btn-default">	
        						尾页
        						</button>
        					</a>
        				</li>
        			</ul>
        		</div>
        		<!-- /页码导航 -->	
    		</div>
    	</div>
 	
 	<div>
 		<div id="footer"><%@ include file="/front/common/footer.jsp" %></div>
 	</div>
  </body>
</html>
