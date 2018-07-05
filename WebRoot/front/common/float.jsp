<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style type="text/css">
   	/* 给飘窗添加一些基础样式，如宽度，高度和背景颜色等等 */
	.automv{width: 200px;height: 200px;z-index:10;}
</style>
<script src="/NewsRelease/bootstrap/js/jquery-3.3.1.min.js"></script>
<script src="/NewsRelease/bootstrap/js/float.js"></script>

<!-- 浮窗   -->
<div class="automv"><img alt="浮窗" src="/NewsRelease/image/float.jpg"></div>
<script type="text/javascript">
		$('.automv').moveAuto({angle:-Math.PI/4, speed:120});
</script>  