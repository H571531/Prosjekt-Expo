<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="EXPO ${expo.expoid}">
    <div id="mid">
		<div id="midUpper">
			<p><a href="AdminBrowseServlet?posters=true" class="adminButtons">Browse med posters</a></p>
			<form method="get" action="AdminBrowseServlet">
				Velg institutt: <select name="selectedInstitute">
									
									<option value="all"> -- Alle --</option>
									
									<!-- Hent alle institutter -->
									<c:forEach var="inst" items="${institutes}">
										<option value="${inst.instituteid}" ${((inst == selectedInst) ? 'selected="selected"' : '') }>${inst.institutename}</option>
										
									</c:forEach>
									
								</select>
				Velg studie: <select name="selectedStudy">
								<option value="all"> -- Alle --</option>
								<!-- Hvis institutt er valgt, hent alle studier på institutt - ellers hent alle fag -->
								<c:forEach var="study" items="${ ((empty selectedInst) ? studies : selectedInst.studies)}">
									<option value="${study.studyid}" ${((study == selectedStud) ? 'selected="selected"' : '')}>${study.studyname}</option>
								</c:forEach>
							 </select>
				<button type="submit" id="submitButton" name="adminUpdate">Oppdater</button>
			</form>
			<hr>
		</div>
		<div id="midText">
			<h2>${confirmEdit}</h2>
			<table id="browseStandsTable">
				<tr>
					<th>Stand ID</th>
					<th>Stand-navn</th>
					<th>Institutt</th>
					<th>Studie</th>
				</tr>
				<c:forEach var="stand" items="${currentStands}" varStatus="i">
				
					<tr>
						<td>${stand.standId}</td>
						<td><a href="AdminEditStandServlet?standId=${stand.standId}"><c:out value="${stand.standName}" /></a></td>
						<td>${stand.study.institute.institutename}</td>
						<td>${stand.study.studyname}</td>
					</tr>
				
				</c:forEach> 
			</table>
		</div>
	
	</div>


</t:GenericPage>