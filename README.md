# JavaEE新闻发布系统
## 系统简介
本系统为本人课程设计，功能包括：后台的带验证码图片登陆、新闻发布、权限管理、通知发布、我的通知等，前台为新闻轮播、飘窗、近期新闻、所有新闻等。

设计中遵守MVC模式，按要求未采用任何后端框架，前端上采用Bootstrap进行页面编码。具体设计的技术有ajax、json、filter、jstl、自定义标签等，基本涵盖JavaWeb
初级编程的技术，是JavaWeb入门者值得一看的项目。

整个系统已经挂载到http://111.230.105.13:8080/NewsRelease ，后台登陆可使用admin(账号密码一样)。欢迎有兴趣的同学试用并给出意见，杜绝破坏，小白不易。
## 文件组织结
1.WebRoot:这里分为主要分为三个文件夹。
  - 第一个是Bootstrap,里面包含js、css等文件；
  - 第二个是front，这是前台页面的文件夹，里面还有一个common文件夹存放前台通用的头部、脚部等页面；
  - 第三个是console，这是后台控制台页面的文件夹，里面还有一个common文件夹存放后台通用的头部、脚部等页面。
  
2.src:这里是项目源代码的文件夹。
  - DataUtil：数据库工具类，包含开启数据库、关闭数据库、读取配置文件、增删查改等。
  - StringUtil:字符串处理工具类。
  - com.bean:实体类，MVC中的Model。
  - com.servlet:servlet类，MVC中的Controller。
  - com.filter:过滤器类。
  - com.mytag:自定义标签类。
  - com.verify:数据验证类。
  - com.dao:各实体的dao类，继承于DataBaseUtil的BaseDaoImpl。
  
