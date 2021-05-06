<%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/4/28
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工添加</title>
</head>
<body>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<form:form action="${ctp}/emp" method="post" modelAttribute="employee">
    <%--path指定的每一属性，请求域中必须有一个对象，拥有这个属性--%>
    lastName:<form:input path="lastName"/><br/>
    email:<form:input path="email"/><br/>
    gender:男：<form:radiobutton path="gender" value="1"/><br/>
    女：<form:radiobutton path="gender" value="0"/><br/>
    dept:
    <form:select path="department.id" items="${depts}" itemValue="id" itemLabel="departmentName">
    </form:select>
    <input type="submit" value="保存">
</form:form>
<%--<form action="">

    lastName:<input name="lastName" type="text"><br/>
    email:<input name="email" type="text"><br/>
    gender:男：<input name="gender" value="1" type="radio"><br/>
    女：<input name="gender" value="0" type="radio"><br/>
    dept:
    <select name="department.id">
        <c:forEach items="${depts}" var="deptItem">
            <option value="${deptItem.id}">${deptItem.departmentName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="提交">
</form>--%>
</body>
</html>
