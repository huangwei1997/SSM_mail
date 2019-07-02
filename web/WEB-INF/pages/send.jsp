<%--
  Created by IntelliJ IDEA.
  User: huangwei
  Date: 2019/7/1
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>send email</title>
</head>
<body>
    <h3>请填写发送邮件信息</h3>
    <hr/>
    <form action="<%= request.getContextPath() %>/sendMail" method="post" enctype="multipart/form-data">
        收件人：<input type="text" name="receiveId" value=""/><br/>
        标&nbsp;&nbsp;&nbsp;题：<input type="text" name="mtitle" value=""/><br/>
        内&nbsp;&nbsp;&nbsp;容:<br/><textarea rows="8" cols="20" name="mcontent"></textarea><br/>
        附&nbsp;&nbsp;&nbsp;件:<input type="file" name="file"/><br/>
        <input type="submit" value="发送" />
    </form>
</body>
</html>
