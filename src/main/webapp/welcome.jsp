<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/8/22
  Time: 1:10 AM
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
<h1> welcome ${fullName}</h1>
<form action="customer_get_product">
    Product Name <input type="search" name="productName" placeholder="Product Name">
    <input type="submit" value="Search">
</form><br>
<form action="customer_get_product_category">
    Product Category <input type="search" name="category" placeholder="product category">
    <input type="submit" value="Search">
</form>
<br>
<a href="customer_get_all_product">View All Product</a>

</body>
</html>
