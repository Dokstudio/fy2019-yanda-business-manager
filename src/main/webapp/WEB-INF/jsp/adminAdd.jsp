<%--
  Created by IntelliJ IDEA.
  User: Dokstudio
  Date: 2019/8/7
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理员</title>
</head>
<body>

    <form action="http://localhost:8080/user/Admin/adminAdd" method="post">

        <span>用户名:</span>
        <input type="text" name="username"/>
        <br/>
        <span>密码:</span>
        <input type="password" name="password"/>
        <br/>
        <span>email:</span>
        <input type="text" name="username"/>
        <br/>
        <span>电话:</span>
        <input type="text" name="username"/>
        <br/>
        <span>密保问题:</span>
        <input type="text" name="username"/>
        <br/>
        <span>密保问题答案:</span>
        <input type="text" name="username"/>
        <br/>
        <input type="submit" value="添加管理员"/>

    </form>
</body>
</html>
