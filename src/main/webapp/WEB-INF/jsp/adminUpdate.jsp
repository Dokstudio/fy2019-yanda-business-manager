<%--
  Created by IntelliJ IDEA.
  User: Dokstudio
  Date: 2019/8/7
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改管理员信息</title>
</head>
<body>


<form action="" method="post">

    <input type="hidden" name="id" value="${userInfo.id}"><br/>
    用户名<input type="text" name="username" value="${userInfo.username}"><br/>
    密码<input type="password" name="password" value="${userInfo.password}"><br/>
    email<input type="text" name="email" value="${userInfo.email}"><br/>
    电话<input type="text" name="phone" value="${userInfo.phone}"><br/>
    密保问题<input type="text" name="question" value="${userInfo.question}"><br/>
    密保问题答案<input type="text" name="answer" value="${userInfo.answer}"><br/>
    IP<input type="text" name="ip" value="${userInfo.ip}"><br/>
    <input type="submit"  value="修改"><br/>

</form>

</body>
</html>
