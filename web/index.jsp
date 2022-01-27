<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小白杨
  Date: 2022/1/14
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    这个动态web工程可真是牛逼呢！！
    <% out.write(97); %>
    <%@include file="/small.jsp"%>
    <% int i = Math.max(1, 2); %>
    <%= i %>
66666
  </body>
</html>
