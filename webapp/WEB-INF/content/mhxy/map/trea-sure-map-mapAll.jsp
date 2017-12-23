<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2017/12/19
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
<div style="width: auto;height: auto;text-align: center;border: solid;">
    <table border="1" cellspacing="0"
        >

        <s:iterator  value="list">
            <tr>
                <td
                        >
                    序号:${id}

                </td><td
                    >地点:${address}</td><td
                    >
                x:${x}
            </td>
                <td
                        >物品:${item}</td>
                <td
                        >y:${y}</td>


            </tr>
            <s:property  value="address"></s:property>
        </s:iterator>




    </table>


</div>




</body>
</html>
