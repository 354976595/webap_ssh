<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/21
  Time: 10:36
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
    <script type="application/javascript" src="/jquery-3.2.1.js"></script>
</head>
<body>
<script type="text/javascript">
</script>
<div style="width: 500px;height: 300px;background-color: lightcoral">
    <form id="for" name="form1" action="bus/bus!testJquery.action" method="post" accept-charset="utf-8" style="background-color: lawngreen">
        车号:<input class="input1" name="BusEntity.busNo" value="123"/><br>
        线路:<input class="input2" name="BusEntity.busLine" value="pass"/><br>
        <button id="sub" type="submit">按钮1</button>
    </form>
    <button id="sub2">按钮2</button>
    <em>1231231</em>
    <iframe src="bus/bus.action"></iframe>
</div>
<script type="text/javascript">
    $("#for").click(function () {
        alert("form 表单整个onclick")
    });
    $("#sub").click(function () {
        alert("提交按钮")
    });
    $("#sub2").click({width:  $("#sub2").css("width"), value: 321}, function (event) {
        var sub = $(this);
        //alert("[data]中的width=" + event.data.width);
        //alert("sub html标签中的文本="+sub.html());
       // alert($("#sub2").css("width"));
        sub.css({width: function(index,value){
            return parseFloat(value)*1.2;
        }});
        sub.css({color:'red',height:function(index,value){
            return parseFloat(value)*1.2;
        }});
        $("input").prop("name","haha")
    });

</script>
</body>
</html>
