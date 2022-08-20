<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/9/22
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product View</title>
</head>
<body>
<%
    if (session.getAttribute("password")==null){
        response.sendRedirect("adminlogin.jsp");
    }
%>
<a href = 'addProduct.jsp'> Add New Product</a>
<h1> Product List</h1>
<table border='1' width='100%'>
    <tr><th>Id</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Update</th>
        <th>Delete</th></tr>
    <c:forEach var="product" items="${allProducts}">
    <tr><td>${product.getProductId()}</td><td>
            ${product.getName()}</td><td>
            ${product.getCategory()}</td>
        <td>${product.getQuantity()}</td>
        <td>${product.getPrice()}</td><td>
            <a href='updateProduct.jsp'>update</a>
        </td> <td><a href='delete_product?productName=${product.getName()}'>delete</a></td></tr>
    </c:forEach>
</table><br>


<form action="get_product">
    Product Name <input type="search" name="productName" placeholder="Product Name">
    <input type="submit" value="Search">
</form><br>
<form action="get_product_category">
    Product Category <input type="search" name="category" placeholder="product category">
    <input type="submit" value="Search">
</form>


<%--<c:out value="${allProducts}"></c:out>--%>


</body>
</html>
