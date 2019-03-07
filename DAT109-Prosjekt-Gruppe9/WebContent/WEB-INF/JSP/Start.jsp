<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
		<c:forEach items="${stands}" var="stand">
			<a href="StandServlet?standId=${stand.standId}"><c:out value="${stand.standName}"/></a><br>
		</c:forEach>
		<hr>

		<a href="ResultServlet">Resultat Liste</a>

	</div>
</div>


</body>
</html>