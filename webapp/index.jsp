<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>"/>
    <title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
<a href="login/login!login.action">login</a>
<a href="regist/regist!regist.action">regist</a>
</body>
</html>
