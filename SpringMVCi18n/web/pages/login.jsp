<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/5/5
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1><fmt:message key="welcomeinfo"/></h1>
<form action="">
    <fmt:message key="username"/> ：<input><br/>
    <fmt:message key="password"/> ：<input><br/>
    <input type="submit" value="<fmt:message key="loginBtn"/>">
</form>
<a href="toLoginPage?locale=zh_CN">中文</a>
<a href="toLoginPage?locale=en_US">English</a>
</body>
</html>
