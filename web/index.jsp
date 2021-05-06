<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/20
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="hello">hello world</a>
<h1>测试RequestMapping属性</h1>
<a href="handle02">handle02</a>
<form action="handle02" method="post">
    <input type="submit">
</form>
<a href="handle03">handle03</a>
<a href="handle04">handle04</a>
<hr/>
<a href="handle05">handle04</a>
<hr/>
<h1>RequestMapping-Ant风格的URL</h1>
<a href="antTest01">精确请求地址</a>
<a href="user/admin">测试PathVariable</a>
</body>
</html>
