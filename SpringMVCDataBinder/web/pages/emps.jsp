<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 92311
  Date: 2021/5/2
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<script type="text/javascript" src="../jquery-1.9.1.min.js"></script>
<html>
<head>
    <title>emps</title>
</head>
<body>
<%=new Date()%>
<a href="${ctp}/getallajax">ajax获取所有员工</a>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function () {
        //发送ajax获取所有员工
        $.ajax({
            url: "${ctp}/getallajax",
            type: "GET",
            success: function (data) {
                console.log(data);
                $.each(data, function () {
                    var empInfo = this.lastName + "-->" + this.birth + "->>" + this.gender;
                    $("div").append(empInfo + "<br>");
                })
            }
        })
        return false;
    });
</script>
</body>
</html>
