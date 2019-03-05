<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>EXPO ${expo.year}</title>
		
		<link rel="stylesheet" type="text/css" href="styles/style.css">
	</head>
	<body>
		<div id="header">
			<img src="img/logo-no.png">
		</div>
	
		<div id="mid">
			<div id="expoLogo">
				<img id="expoLogoImg" src="img/expo_logo.png">
			</div>
			<div id="midText">
				
					<p>VELKOMMEN TIL EXPO ${expo.year}</p><br>
					
					
					<hr>
					<h2>TESTING</h2>
					<a href="StandServlet?standId=1">Test-stand 1</a><br>
					<a href="StandServlet?standId=2">Test-stand 2</a><br>
					<hr>
				
			
			</div>
		</div>
	

	</body>
</html>