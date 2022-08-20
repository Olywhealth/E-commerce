<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/10/22
  Time: 4:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("password")==null){
        response.sendRedirect("adminlogin.jsp");
    }
%>
<h1>Product Category Result</h1>
<table border='1' width='100%'>
    <tr><th>Id</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Price</th></tr>
<c:forEach var="product" items="${productByCategory}">
    <tr><td>${product.getProductId()}</td><td>
    ${product.getName()}</td><td>
    ${product.getCategory()}</td>
    <td>${product.getQuantity()}</td>
    <td>${product.getPrice()}</td><td></tr>
</c:forEach>
</table><br>
</body>
</html>
