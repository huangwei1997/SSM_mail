<%--
  Created by IntelliJ IDEA.
  User: huangwei
  Date: 2019/7/1
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
    <h3>邮件系统登录</h3>
    <hr/>
    <form action="<%=request.getContextPath() %>/login" method="post">
        用户名：<input type="text" name="uname" value=""/></br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd" value=""><br/>
                <input type="submit" value="登陆">
    </form>
</body>
</html>
