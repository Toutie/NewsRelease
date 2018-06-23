<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div id="wrapper">
  <!--顶部  -->
  <nav class="navbar navbar-default top-navbar" role="navigation">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp"><i class="fa fa-gear"></i> <strong>返回首页</strong></a>
      </div>

      <ul class="nav navbar-top-links navbar-right">
		<li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                  <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
              </a>
              <ul class="dropdown-menu dropdown-messages">
                  <li>
                      <a href="#">
                          <div>
                              <strong>张三</strong>
                              <span class="pull-right text-muted">
                                  <em>今天</em>
                              </span>
                          </div>
                          <div>你好,欢迎使用本系统，这是测试消息</div>
                      </a>
                  </li>
                  <li class="divider"></li>
                  <li>
                      <a class="text-center" href="#">
                          <strong>Read All Messages</strong>
                          <i class="fa fa-angle-right"></i>
                      </a>
                  </li>
              </ul> 
		</li>
        <!-- /.dropdown-messages -->
    	<li class="dropdown">
               <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                   <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
               </a>
               <ul class="dropdown-menu dropdown-user">
                   <li><a href="#"><i class="fa fa-user fa-fw"></i>个人信息</a>
                   </li>
                   <li><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a>
                   </li>
                   <li class="divider"></li>
                   <li><a href="/servlet/LogoutServlet"><i class="fa fa-sign-out fa-fw"></i>登出</a>
                   </li>
               </ul>
               <!-- /.dropdown-user -->
          </li>
          <!-- /.dropdown -->
 		</ul>
   </nav>
	<!-- 侧边栏 -->
	<nav  class="navbar-default navbar-side" role="navigation">
		<div id="sideNav"><button onclick="collapseSide()" class="btn"><i class="fa fa-caret-right"></i></button></div>
           <div class="sidebar-collapse">
               <ul class="nav" id="main-menu">
               	   <!-- 控制台 -->
               	   <li>
               	   		<a class="active-menu" href="console/main.jsp"><i class="fa fa-desktop"></i>控制台</a>	
               	   </li>
				   <!-- 新闻 -->
                   <li>
                       <a href="#"><i class="fa fa-dashboard"></i>新闻<span class="fa arrow"></span></a>
                       <ul class="nav nav-second-level">
                            <li>
                                <a href="#">发布新闻</a>
                            </li>
                           	<li>
                                <a href="#">新闻审批</a>
                            </li>
                        </ul>
                   </li>
                   
                   <!-- 个人中心 -->
                   <li>
                        <a href="#"><i class="fa fa-qrcode"></i>个人中心<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">我的通知</a>
                            </li>
                           	<li>
                                <a href="#">我的留言</a>
                            </li>
                        </ul>
                   </li>
                   
                   <!-- 附加功能 -->
                   <li>
                   		<a href="#"><i class="fa fa-sitemap"></i>附加功能<span class="fa arrow"></span></a>
                   		<ul class="nav nav-second-level">
                            <li>
                                <a href="#">其他</a>
                            </li>
                        </ul>	
                   </li> 
				</ul>
		</div>
	</nav>
</div>




              