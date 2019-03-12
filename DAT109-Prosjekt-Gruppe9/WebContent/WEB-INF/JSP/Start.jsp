<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:GenericPage customTitle="EXPO ${expo.year}">
	
		<div id="mid">
			
			<div id="midText">
		
				<p>VELKOMMEN TIL EXPO ${expo.year}</p><br>
		
		
				<hr>
				<h2>TESTING</h2>
				<c:forEach items="${stands}" var="stand">
					<a href="StandServlet?standId=${stand.standId}"><c:out value="${stand.standName}"/></a><br>
				</c:forEach>
				<hr>

                <a href="ResultServlet">Resultatliste</a>
				<br/>
				<a href="RegistrationServlet">Register Stands</a>
			</div>
		</div>
	
</t:GenericPage>