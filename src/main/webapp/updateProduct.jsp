<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/9/22
  Time: 9:40 PM
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
<h1>Add Product</h1><br>
<form action="update_product" method="post">
    Product ID<input type='text' name="productId">
    Name <input type="text" name="productName">
    Category <input type="text" name="category">
    Quantity <input type="text" name="quantity">
    Price <input type="text" name="price">
    <input type="submit" value="Update And Save">
</form>

</body>
</html>
