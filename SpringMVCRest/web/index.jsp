<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/23
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--发起图书的增删改查请求，使用Rest风格的URL地址--%>
<a href="book/1">查询图书</a>
<form action="book" method="post"><br/>
    <input type="submit" value="添加1号图书">
</form>
<br/>
<form action="book/1" method="post"><br/>
    <input name="_method" value="delete">
    <input type="submit" value="删除1号图书">
</form>
<br/>
<form action="book/1" method="post"><br/>
    <input name="_method" value="put">
    <input type="submit" value="更新1号图书">
</form>
<br/>

</body>
</html>
