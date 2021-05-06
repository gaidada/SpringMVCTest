<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/5/3
  Time: 2:29
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
<a href="${ctp}/test1">test1</a>
</body>
</html>
