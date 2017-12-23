<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2017/12/19
  Time: 14:44
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
    <script src="/jquery-3.0.0/jquery-3.0.0.min.js"></script>
</head>
<body>
<s:form action="mhxy/map/trea-sure-map!saveMapData.action" method="POST">
    <s:textfield label="坐标X" name="map.x"></s:textfield>
    <s:textfield label="坐标Y" name="map.y"></s:textfield>
    <s:select label="挖开结果:" name="map.item" list="{'50','60','70','垃圾装备','垃圾书铁','钱','60书铁','五宝','挖空','挖塌','胀气','妖怪','兽决'}"
              headerKey="-1" headerValue="选择结果"></s:select>
    <s:select label="藏宝点:" name="map.address" id="adress" onchange="selectAddress()"
              list="{'江南野外','北俱芦洲','墨家村','五庄','傲来','国境','普陀','狮驼','朱紫','麒麟','女儿村','花果山','东海湾','长寿村','长寿郊外','境外','建业',''}" headerKey="-1"
                 headerValue="请选择"></s:select>
            <s:submit label="保存"  />
            </s:form>
            <script type="text/javascript">
            function selectAddress() {
//                var selected = $("select option:selected");
//                alert(selected.text());
            }


</script>
</body>
</html>
