<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="EXPO ${expo.expoid}">
	<div id="mid">
		<div id="midText">
		
			<p>Dessverre er registrering av nye 
			<c:choose>
				<c:when test="${attemptedRegistration == stand}">stands</c:when>
				<c:when test="${attemptedRegistration == vote}">stemmer</c:when>
			</c:choose>		
			stengt! Vennligst ta kontakt med en administrator hvis du mener dette er feil!
		</div>
	</div>
</t:GenericPage>