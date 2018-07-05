<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <base href="<%=basePath%>">  
        <title>控制台-新闻发布</title>  
        <meta http-equiv="pragma" content="no-cache">  
        <meta http-equiv="cache-control" content="no-cache">  
        <meta http-equiv="expires" content="0">  
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
        <meta http-equiv="description" content="This is my page">  
        <!-- 配置文件 -->  
        <script type="text/javascript" src="./ueditor/ueditor.config.js"></script>  
        <!-- 编辑器源码文件 -->  
        <script type="text/javascript" src="./ueditor/ueditor.all.js"></script>  
        <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->  
        <script type="text/javascript" src="./ueditor/lang/zh-cn/zh-cn.js"></script> 
        <script type="text/javascript" src="bootstrap/js/ajax.js"></script> 
        <jsp:include page="/console/common/css.jsp" />
		<jsp:include page="/console/common/js.jsp" /> 
    </head>  
    <body>  
   		<jsp:include page="/console/common/console-header.jsp" />
    	<!-- 内容 -->
		<div id="page-wrapper">
    		<div id="page-inner">
    			<div>
    				<ol class="breadcrumb">
 						<li class="active">Home</li>
 						<li class="active">News</li>
  						<li class="active">Release</li>
					</ol>
    			</div>
    			<hr/>
     			<form id="newsReleaseForm" onsubmit="return false">
     				
	      			<!-- 新闻标题 -->
     				<div>
              			<label for="title">标题</label>
                		<input type="text" class="form-control" id="title" name="title" placeholder="请输入新闻标题" required>
            		</div>
            		
            		
            		
            		<!-- 新闻类型 -->
            		<div>
            			<label for="type">类型</label>
            			
            			<select class="form-control" id="type" name="type" required>
            				<option value="t001">学院动态</option>
            				<option value="t002">学术新闻</option>
            				<option value="t003">学风建设</option>
            			</select>          			
            		</div>
            		
            	
            		
	      			 <hr/>
	      			 
	      			<textarea name="content" id="myEditor"></textarea> 
	      			  
	      			 <!-- 实例化编辑器 --> 
	       			<script type="text/javascript">
	       				//实例化编辑器  
	           			var editor = UE.getEditor('myEditor');
	       			</script>
	       			
	       			<hr/>
	       			<!-- 按钮 -->
	       			<div class="text-right">
	       				<button class="btn btn-default btn-danger" type="reset">重置</button>
	       				<button class="btn btn-default btn-info" onclick="newsRelease()">提交</button>
	       			</div>
	       					
        		</form>
        				
    		</div>
    	</div>
    </body>  
</html>  