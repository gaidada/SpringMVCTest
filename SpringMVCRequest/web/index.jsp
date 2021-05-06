<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/24
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="hello">hello</a><br/>
<a href="handle01?username=root">handler01</a><br/>
<form action="book" method="post">
    书名：<input name="bookName" type="text"><br/>
    作者：<input name="author" type="text"><br/>
    价格：<input name="price" type="text"><br/>
    库存：<input name="stock" type="text"><br/>
    销量：<input name="sales" type="text"><br/>
    <hr/>
    地址：省：<input name="address.province" type="text">
    市：<input name="address.city" type="text">
    街道：<input name="address.street" type="text">
    <input type="submit">
</form>
</body>
</html>
