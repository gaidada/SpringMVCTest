<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/5/3
  Time: 1:39
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
${msg}<br/>
<form action="${ctp}/mulUpload" method="post" enctype="multipart/form-data">
    用户头像：<input name="headerimg" type="file"><br/>
    用户头像：<input name="headerimg" type="file"><br/>
    用户头像：<input name="headerimg" type="file"><br/>
    用户头像：<input name="headerimg" type="file"><br/>
    用户名：<input type="text" name="username">
    <input type="submit">
</form>
</body>
</html>
