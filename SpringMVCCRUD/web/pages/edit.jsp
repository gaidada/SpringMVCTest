<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/29
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formk" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<h1>员工修改页面</h1>
<%--指定这个表单所有内容显示绑定的是请求域中employee的值--%>
<formk:form action="${ctp}/emp/${employee.id}" method="post" modelAttribute="employee">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="id" value="${employee.id}">
    email:<form:input path="email"/><br/>
    gender:
    男：<form:radiobutton path="gender" value="1"/>
    女：<form:radiobutton path="gender" value="0"/><br/>
    dept:
    <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id">

    </form:select><br/>
    <input type="submit" value="修改">
</formk:form>
</body>
</html>
