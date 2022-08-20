<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/9/22
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1><br>
<%
    if (session.getAttribute("password")==null){
        response.sendRedirect("adminlogin.jsp");
    }
%>
welcome ${fullName}
<form action="add_product" method="post">
    Name <input type="text" name="productName">
    Product ID <input type="text" name="productId">
    Category <input type="text" name="category">
    Quantity <input type="text" name="quantity">
    Price <input type="text" name="price">
    <input type="submit" value="Add Product">
</form>
<br>
<a href="get_all_product">view product</a>
</body>
</html>
