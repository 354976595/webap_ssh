<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2017/12/19
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href=<%=basePath%>/>
    <title></title>
</head>
<body>
mhxy default
</body>
</html>
