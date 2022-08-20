<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/11/22
  Time: 2:02 AM
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
<c:out value="${productFetched}"></c:out><br>
</body>
</html>
