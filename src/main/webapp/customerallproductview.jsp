<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/11/22
  Time: 2:05 AM
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
        response.sendRedirect("customerlogin.jsp");
    }
%>
<a href = 'welcome.jsp'> Search Product</a>
<h1> Product List</h1>
welcome ${fullName}
welcome ${userId}
<table border='1' width='100%'>
    <tr><th>Id</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Cart</th>
        <th>Like</th></tr>
    <c:forEach var="product" items="${allProducts}">
        <tr><td>${product.getProductId()}</td><td>
                ${product.getName()}</td><td>
                ${product.getCategory()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getPrice()}</td><td>
                <form action="add_product_to_cart" method="get">
                   <button type="submit" name="productId" value="${product.getProductId()}">Add To Cart</button>
                </form>
<%--                <a href='add_product_to_cart'> <button>Add To Cart</button>></a>--%>
<%--                <a href='like_or_unlike?userId=${userId}'> <button>Like</button>--%>
            </td> <td><form action="like_or_unlike" method="get"><button type="submit" name="productId" value="${product.getProductId()}">Like</button></form> </td></tr>
    </c:forEach>
</table><br>

</body>
</html>
