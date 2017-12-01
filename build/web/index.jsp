<%-- 
    Document   : index
    Created on : Nov 25, 2017, 6:41:14 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/icon.png" type="image/png">
        <title>ReebokShop</title>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet"> 
    </head>
    <body>
        <div id="wrapper">
            <%@include file="pageParts/topBar0.jsp" %>
            <%@include file="pageParts/navigation.jsp" %>
            <a href="#"><div id="content">
                <img id="img" src='images/zig.jpg'>   
            </div></a>
            <%@include file="pageParts/footer.jsp"%>
        </div>
    </body>
</html>
