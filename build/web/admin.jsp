<%-- 
    Document   : admin
    Created on : Nov 27, 2017, 1:25:29 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="admin.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

    </head>
    <body>
         <h1>Data entry</h1>
         
        <div id="form">
           <p id="pfl">Please fill in all the fields!</p>
        <form action="DataEntry" method="post" enctype="multipart/form-data">
            Name: <input type="text" name="name" id="name" onblur="f()">
            <br>
            Gender: <select name="gender">
                        <option value="0">Men</option>
                        <option value="1">Women</option>
                        <option value="2">Kids</option>
                    </select>
            Category: <select name="category">
                        <option value="0">Jackets</option>
                        <option value="1">Hoodies</option>
                        <option value="2">Shorts</option>
                        <option value="3">Shoes</option>
                      </select>
            <br>
            Price: <input type="number" name="price" id="price" onblur="f();">
            <br>
            Stack: <input type="number" name="stack" id="stack" onblur="f();">
            <br>
            <input name="image" type="file" accept="image/*">
            <br>
            <input type="submit" value="Upload" id="submit" disabled="true">
        </form>
            <h2>${rez}</h2>
            </div>
    </body>
    
    <script>
        function f(){
            if(document.getElementById("name").value.length!==0&&document.getElementById("price").value.length!==0&&document.getElementById("stack").value.length!==0){
            document.getElementById("submit").disabled=false;
            document.getElementById("pfl").style.color="black";
        }else{
            document.getElementById("submit").disabled=true;
            document.getElementById("pfl").style.color="#B81C27";
        }
        }
    </script>
</html>
