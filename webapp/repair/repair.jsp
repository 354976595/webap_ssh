<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/23
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>"/>
    <title>Insert title here</title>
</head>
<body>
repair
<%=request.getAttribute("com/xjd/web/juintTestPackage")
%>
<%=session.getAttribute("com/xjd/web/juintTestPackage")
%>
<%=   application.getAttribute("com/xjd/web/juintTestPackage")%>

kuaijiejian :${requestScope.test}
</body>
</html>
