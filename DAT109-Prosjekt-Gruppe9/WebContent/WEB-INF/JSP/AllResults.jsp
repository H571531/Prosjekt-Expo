<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Alle Stands">
	<div id="mid">
		<div id="midUpper">
		
			<a href="ResultServlet">Tilbake til resultater</a>
		
		</div>
		<div id="midText">
			<table id="browseStandsTable">
				<tr>
					<th>Stand ID</th>
					<th>Stand-navn</th>
					<th>Institutt</th>
					<th>Antall Stemmer</th>
				</tr>
				<c:forEach var="result" items="${allResults}" varStatus="i">
				
					<tr>
						<td>${result.key.standId}</td>
						<td><a href="AdminEditStandServlet?standId=${result.key.standId}"><c:out value="${result.key.standName}" /></a></td>
						<td>${result.key.study.institute.institutename}</td>
						<td>${result.value}</td>
					</tr>
				
				</c:forEach> 
			</table>
		</div>
	
	</div>
</t:GenericPage>