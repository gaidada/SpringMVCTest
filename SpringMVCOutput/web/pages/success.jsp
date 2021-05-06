<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/24
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
success<br/>
pageContext:${pageScope.msg}<br/>
request:${requestScope.msg},${requestScope.hh}<br/>
session:${sessionScope.msg}-${sessionScope.hh}<br/>
application:${applicationScope.msg}<br/>
<%System.out.println("来到了页面");%>
</body>
</html>
