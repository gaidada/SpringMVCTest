<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/26
  Time: 21:55
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
    <fmt:message key="username"/> <input type="text"><br>
    <fmt:message key="password"/> <input type="password"> <br>
    <input type="submit" value="<fmt:message key="loginBtn"/>">
</form>
</body>
</html>
