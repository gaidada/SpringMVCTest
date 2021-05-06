<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/28
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表页面</title>

</head>
<body>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<script type="text/javascript" src="${ctp}/jquery-1.9.1.min.js"></script>
<h1>员工列表</h1>
<table border="1" cellspacing="5" cellpadding="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <th>${emp.id}</th>
            <th>${emp.lastName}</th>
            <th>${emp.email}</th>
            <th>${emp.gender ==0?"女":"男"}</th>
            <th>${emp.department.departmentName}</th>
            <th><a href="${ctp}/emp/${emp.id}">Edit</a></th>
            <th>
                <a href="${ctp}/emp/${emp.id}" class="delBtn">Delete</a></th>
            </th>
        </tr>
    </c:forEach>
</table>

<a href="${ctp}/toaddpage">添加员工</a>
<form id="deleteForm" action="${ctp}/emp/${emp.id}" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<script type="text/javascript">
    $(function () {
        $(".delBtn").click(function () {
            //改变表单的action指向
            $("#deleteForm").attr("action", this.href);
            //提交表单
            $("#deleteForm").submit();
            return false;
        })
    });
</script>
</body>
</html>
