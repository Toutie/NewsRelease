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
        <title>ueditorTest</title>  
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
    </head>  
    <body>  
    	<form action="servlet/Test" method="post">
       		<script id="container" name="content" type="text/plain"></script>  
        	<script type="text/javascript">  
            	var editor = UE.getEditor('container');
        	</script>
        	<input type="submit"/>  
        </form>
    </body>  
</html>  