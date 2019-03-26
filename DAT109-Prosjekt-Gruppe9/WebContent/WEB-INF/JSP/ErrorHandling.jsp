<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="EXPO ${expo.expoid}">
	<div id="mid">
	
		<div id="midText">
			<h2 class="errorMessage">${errorMessage}</h2>
		</div>
	</div>
</t:GenericPage>