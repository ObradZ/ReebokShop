

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
           <div id="content" style="overflow: auto; text-align: center;">
               <div style="float:left">
               <h1 style="margin:20%;">${product.name}</h1>
                <p style="margin:15%;">Price: ${product.price}$</p>
                <p style="margin:15%;">Availible: ${product.stack}</p>
                </div>
                <img src="ProductImages/${product.image}" alt="shoe" style="display:block; float:right; border-radius: 5px; width:50%; height:500px;">
            </div>
            <%@include file="pageParts/footer.jsp"%>
        </div>
    </body>
</html>
