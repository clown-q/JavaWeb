<%--
  Created by IntelliJ IDEA.
  User: 陌路
  Date: 2023/2/21
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lq.com</title>
</head>
<body>
<h3>hello,通过Requestcher转发方式将reques中的数据传递过来，可以通过jsp或者el，jstl标签呈现出来</h3>
<div>
    用户名是:<%=request.getAttribute("username")%>
</div>
</body>
</html>
