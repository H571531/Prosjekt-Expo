<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Stand: ${stand.standName}">
	<h1 class="login">Logg inn</h1>
	<p>
		<font color="red">${loginError}</font>
	</p>
	<form method="post" class="loginForm">
		<fieldset class="loginFieldset">
				<label for="Username">Brukernavn:</label> <input type="text" name="Username" />
				<label for="password">Passord:</label> <input type="password"
					name="password" />
				<button type="submit">Logg inn!</button>
		</fieldset>
	</form>
</t:GenericPage>