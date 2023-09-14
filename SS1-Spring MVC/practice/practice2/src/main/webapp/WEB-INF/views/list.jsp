<%--
  Created by IntelliJ IDEA.
  User: mylie
  Date: 9/14/2023
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table style="border: 1px solid">
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Địa chỉ</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="c" items="${customers}" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td>${c.name}</td>
      <td>${c.email}</td>
      <td>${c.address}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
