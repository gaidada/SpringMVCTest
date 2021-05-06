<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/5/5
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<body>
<a href="${ctp}/handle01?i=10">test1</a><br/>

<a href="${ctp}/handle02?username=admin">test2</a>
<a href="${ctp}/hello">hello</a><br/>
</body>
</html>
