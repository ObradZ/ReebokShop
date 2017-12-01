<%-- 
    Document   : products
    Created on : Nov 26, 2017, 9:08:10 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/icon.png" type="image/png">
        <title>Products</title>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet"> 
    </head>
    <body>
        <div id="wrapper">
            <%@include file="pageParts/topBar0.jsp" %>
            <%@include file="pageParts/navigation.jsp" %>
            <div id="contentPr">
                <h1>${h1}</h1>
                <c:forEach items="${products}" var="prod">
                    <div class="product" style="height:300px">
                        <a href="Product1?id=${prod.id}">
                            <p>${prod.name}</p>
                            <img src="ProductImages/${prod.image}">
                            <p id="oneP">${prod.price}$</p>
                        </a>  
                    </div>
                </c:forEach>
            </div>
            <%@include file="pageParts/footer.jsp"%>
        </div>
    </body>
</html>
