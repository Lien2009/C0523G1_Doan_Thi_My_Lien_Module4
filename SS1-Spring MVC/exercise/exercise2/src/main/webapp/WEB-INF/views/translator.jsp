<%--
  Created by IntelliJ IDEA.
  User: mylie
  Date: 9/14/2023
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tra cứu từ Anh - Việt</h1>
<form action="/translator" method="post">
    <label for="english">Nhập từ Tiếng Anh:</label>
    <input type="text" id="english" name="english">
    <button>Tra:</button>
</form>
<h2>${vietnamese}</h2>
</body>
</html>
