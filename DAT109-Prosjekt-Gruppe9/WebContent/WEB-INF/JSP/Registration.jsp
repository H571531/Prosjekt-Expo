<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Registrer stands</title>

    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<div id="header">
    <div id="headerLeft">
        <a href="http://www.hvl.no"><img id="hvlLogo" src="img/hvl_logo_2.png"></a>
    </div>
    <div id="headerRight">
        <img id="expoLogoImg" src="img/expo_logo_2.png">
    </div>
</div>

<div id="mid">

    <div id="midText">

        <p>Registrer Stand</p><br>
        <form action = "RegistrationServlet" method = "post"
              enctype = "multipart/form-data">
            Stand id:
            <input type="text" name="standid" />
            <br/>
            Navn:
            <input type="text" name="name">
            <br/>
            Bilde av plakat:
            <input type = "file" name = "image" />
            <br />
            <input type = "submit" value = "Registrer" />
        </form>
        <a href="StartServlet">Startside</a>
    </div>
</div>


</body>
</html>