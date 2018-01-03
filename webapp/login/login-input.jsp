<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/21
  Time: 11:25
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
    <link href="bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet"/>
    <script src="jquery-3.2.1.js" language="javascript"></script>
    <script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="login/login.css">

</head>
<body>
<div class="container">
    <form class="form-signin" action="login/login!signIn.action" method="post" >
        <h2 class="form-signin-heading">xjd管理系统</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" name="user.name" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="user.password" class="form-control" placeholder="密码" required>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp录</button>
    </form>

</div>
<!-- /container -->
</body>
</html>
