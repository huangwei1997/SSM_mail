SSM邮件系统

主要功能：用户登录、登录成功后跳转页面同时发送ajax请求获取该用户收件箱中的所有文件、发送邮件（SpringMVC的上传下载）

技能点：WEB-INF下的文件对浏览器不可见，需要在服务器中通过请求转发来访问，通过声明公共的资源跳转的单元方法来实现

登录页面：

![image](https://github.com/huangwei1997/SSM_mail/blob/master/images/1.png)

登录成功后跳转到main.jsp，通过ajax请求获取当前用户的收件箱，可以下载相应的附件：

![image](https://github.com/huangwei1997/SSM_mail/blob/master/images/2.png)

点击发送邮件，填写邮件内容并发送：

![image](https://github.com/huangwei1997/SSM_mail/blob/master/images/3.png)

发送成功后，可以调回到收信箱：

![image](https://github.com/huangwei1997/SSM_mail/blob/master/images/4.png)
