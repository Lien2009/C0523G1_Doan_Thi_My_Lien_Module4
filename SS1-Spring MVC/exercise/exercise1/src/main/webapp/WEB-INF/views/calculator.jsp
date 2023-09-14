<%--
  Created by IntelliJ IDEA.
  User: mylie
  Date: 9/14/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chuyển đổi tiền tệ</h1>
<form action="/calculator" method="post">
    <label for="rate">Tỉ giá:</label>
    <input type="number" id="rate" name="rate"><br>
    <label for="usd">Tiền USD:</label>
    <input type="number" id="usd" name="usd"><br>
    <button>Quy đổi</button>
</form>
<h2>Số tiền VND tương ứng là: ${vnd}</h2>
</body>
</html>
