<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Logg inn">
	<div id="mid">
		<div id="midText">
			<p>
				<font color="red">${loginError}</font>
			</p>
			<form method="post" action="StartServlet" class="loginForm">
				<fieldset class="loginFieldset">
						<label for="username">Brukernavn:</label> <input type="text" id="username" name="Username" required/>
						<label for="password">Passord:</label> <input type="password"
							name="password" id="password" required/>
						<button type="submit" name="frontLogin">Logg inn!</button>
				</fieldset>
			</form>
			
			<form method="get" action="StartServlet" class="">
				<fieldset class="">
					<label for="StandId">Stand:</label><input type="text" id="standid" name="standid" required/>
					<button type="submit" name="frontQR">HentQR!</button>
				</fieldset>
			</form>
			<p>
				<font color="red">${standError}</font>
			</p>
		</div>
	</div>
</t:GenericPage>