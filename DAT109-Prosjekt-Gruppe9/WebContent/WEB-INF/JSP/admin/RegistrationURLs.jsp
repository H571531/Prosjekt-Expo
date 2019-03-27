<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="EXPO ${expo.expoid}">
	<div id="mid">
		<div id="midUpper">
			<p>Opprett ny stand</p>
			<form method="post" action="AdminRegistrationURLServlet">
				<p>Skriv ID for stand som skal genereres: <input type="text" placeholder="Angi stand-ID" name="newStandId" required></p>
				<button type="submit" value="registerNewStand" name="registerbtn">Opprett ny Stand</button>
			</form>
			<c:if test="${not empty newUrl}">
				<p>Ny stand opprettet. URL for registrering: <a href="${newUrl}">${newUrl}</a></p>
			</c:if>
			<hr>
		</div>
		<div id="midText">
			<p>Hent registrerings-URL til stand</p>
			<form method="get" action="AdminRegistrationURLServlet">
				<p>Skriv ID for Stand: <input type="text" placeholder="Angi stand-ID" name="standId" required></p>
				<button type="submit" value="getStandURL" name="getURLbtn">Hent URL</button>
			</form>
			<c:if test="${not empty oldUrl}">
				<p>Hentet stand. URL for registrering: <a href="${oldUrl}">${oldUrl }</a></p>
			</c:if>
			
		</div>
	</div>
</t:GenericPage>