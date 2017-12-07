<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
<a href="login/login.action">login-execute</a>
<a href="login/login!login.action">login-input</a>
<a href="login/login!success.action">login-success</a>
<a href="login/login!json2.action">login-json2</a>
<a href="regist/regist!regist.action">regist-haha</a>
<a href="regist/regist.action">regist-null</a>
<s:form action="login/login!json3.action" method="post">
    <s:textfield name="name" label="mingzi" />
    <s:token></s:token>
<s:submit label="tijiao" />
</s:form>
<a href="login/login!exception.action">login-exception</a>
</body>
</html>
