<%--
  Created by IntelliJ IDEA.
  User: 小白杨
  Date: 2022/1/17
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/blog_test/upload" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        头像：<input type="file" name="photo"><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
