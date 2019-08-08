<%--
  Created by IntelliJ IDEA.
  User: Dokstudio
  Date: 2019/8/7
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>查看所有管理员</title>
</head>
<body>
    <table>
        <thead>
        <th>管理员Id</th>
        <th>管理员姓名</th>
        <th>管理员密码</th>
        <th>管理员邮箱</th>
        <th>管理员电话</th>
        <th>管理员密保问题</th>
        <th>管理员密保答案</th>
        <th>管理员IP地址</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>
        <c:forEach items="${userInfoAdminList}" var="userInfo">
            <tr>
                <th>${userInfo.id}</th>
                <th>${userInfo.username}</th>
                <th>${userInfo.password}</th>
                <th>${userInfo.email}</th>
                <th>${userInfo.phone}</th>
                <th>${userInfo.question}</th>
                <th>${userInfo.answer}</th>
                <th>${userInfo.ip}</th>
                <th>${userInfo.createTime}</th>
                <th>${userInfo.updateTime}</th>
                <th>
                    <a href="adminUpdate/${userInfo.id}" >修改</a>
                    <a href="adminDelete/${userInfo.id}" >删除</a>
                </th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>