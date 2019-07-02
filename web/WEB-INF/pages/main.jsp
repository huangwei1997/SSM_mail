<%--
  Created by IntelliJ IDEA.
  User: huangwei
  Date: 2019/7/1
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--引入jquery文件--%>
    <script type="text/javascript" src="/SSM_mail/js/jquery-3.4.1.js"></script>
    <%--声明js代码域--%>
    <script type="text/javascript">
        //页面加载成功请求当前的收件信息
        $(function () {
            //发起ajax请求
            $.get("/SSM_mail/myMails",function (data) {
                //获取tbody标签对象
                var tb = $("#tb");
                //遍历将数据填充到表格中
                for(var i = 0 ; i<data.length;i++){
                    tb.append("<tr>" +
                        "<td>"+data[i].mtitle+"</td>" +
                        "<td>"+data[i].mTime+"</td>" +
                        "<td>"+data[i].user.uname+"</td>" +
                        "<td><img src='images/word.png' /><a href='download?fileNewName="+data[i].fileNewName+"&fileOldName="+data[i].fileOldName+"'>"+data[i].fileOldName+"</a></td>"+
                        "</tr>");
                }
            })
        })
    </script>
</head>
<body>
    <h3>欢迎使用邮件系统</h3>
    <hr/>
    <a href="/SSM_mail/send">发送邮件</a>
    <table border="1px" cellpadding="10px" cellspacing="0px">
        <thead>
            <tr>
                <td>标题</td>
                <td>时间</td>
                <td>发件人</td>
                <td>文件</td>
            </tr>
        </thead>
        <tbody id="tb"></tbody>
    </table>
</body>
</html>
