<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:GenericPage customTitle="EXPO ${expo.expoid}">
	
		<div id="mid">
			
			<div id="midText">
		
				<p>VELKOMMEN TIL EXPO ${expo.expoid}</p><br>
				<hr>
				<a href="ResultServlet">Resultatliste</a>
				<br/>
				<a href="RegistrationServlet">Register Stands</a>
				<br/>
				<a href="BrowseServlet">Se alle Stands!</a>
				<hr>
				<a href="AdminServlet">Logg inn som admin</a>
		
				<hr>
				<h2>TESTING</h2>
				<c:forEach items="${stands}" var="stand">
					<a href="StandServlet?standId=${stand.standId}"><c:out value="${stand.standName}"/></a><br>
				</c:forEach>
				<hr>

                
			</div>
		</div>
	
</t:GenericPage>