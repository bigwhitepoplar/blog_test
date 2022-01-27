<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: 小白杨
  Date: 2022/1/19
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/blog_test/"/>
</head>
<body>

    <%
//        从请求头中获取语言种类（从accept-language中获取）
        Locale locale = null;
        String country = request.getParameter("country");
        if("zh_CN".equals(country)) {
            locale = Locale.CHINA;
        } else if("en_US".equals(country)) {
            locale = Locale.US;
        } else {
            locale = request.getLocale();
        }
        ResourceBundle i18n = ResourceBundle.getBundle("i18n", locale);

        System.out.println(i18n.getString("username"));
    %>
    <fmt:setLocale value="${param.country}"/>
    <fmt:setBundle basename="i18n"/>

    <a href="i18n.jsp?country=zh_CN">中文</a>|
    <a href="i18n.jsp?country=en_US">英文</a>
    <p><%= i18n.getString("username") %></p>
    <p><fmt:message key="username"/></p>
</body>
</html>
