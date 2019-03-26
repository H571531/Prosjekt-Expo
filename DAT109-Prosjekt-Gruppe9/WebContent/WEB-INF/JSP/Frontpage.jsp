<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Logg inn">

	<h1 class="Expo!">Velkommen, her kan du finne din QRkode.</h1>
	<p>
		<font color="red">${loginError}</font>
	</p>
	<form method="post" action="LoginServlet" class="loginForm">
		<fieldset class="loginFieldset">
				<label for="username">Brukernavn:</label> <input type="text" id="username" name="Username" />
				<label for="password">Passord:</label> <input type="password"
					name="password" id="password" />
				<button type="submit">Logg inn!</button>
		</fieldset>
	</form>
	<form method="get" action="HentQR" class="">
		<fieldset class="">
			<label for="StandId">Stand:</label><input type="text" id="standId" name="standId"/>
			<button type="submit">HentQR!</button>
		</fieldset>
	</form>
</t:GenericPage>