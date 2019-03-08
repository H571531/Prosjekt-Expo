<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>Resultatliste</title>
	
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
	
	   		<p>Top 5</p><br>
	        <hr>
	        <%--@elvariable id="result" type="no.hvl.dat109.expo.statistics.StandResult"--%>
	        <c:forEach items="${toplist}" var="result">
	            <p><c:out value="${result.stand.standName}" /> : ${result.totalPoints}</p>
	        </c:forEach>
	        <hr>
	
	        <a href="StartServlet">Startside</a>
	    </div>
	</div>
	
	
	</body>
</html>