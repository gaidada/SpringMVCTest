<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/5/2
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<script type="text/javascript" src="../jquery-1.9.1.min.js"></script>
<body>
<form action="${ctp}/test01" method="post">
    <input name="username" value="root">
    <input name="password" value="root">
    <input type="file" name="file">
    <input type="submit"/>
</form>
<a href="${ctp}/testRequestBody">ajax发送json数据</a>
</body>
<script type="text/javascript">
    $(function () {
        $("a:first").click(function () {
            //点击发送ajax请求，请求带的数据是json
            var emp = {lastName: "张三", email: "aaa@aaa.com", gender: 0};
            var empStr = JSON.stringify(emp);
            $.ajax({
                url: '${ctp}/testRequestBody',
                type: "POST",
                data: empStr,
                contentType: "application/json",
                success: function (data) {
                    alert(data);
                }
            });
            return false;
        });
    });

</script>
</html>
