<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:GenericPage customTitle="EXPO ${expo.year}">

	<div id="mid">
		<div id="midUpper">
			<form method="get" action="BrowseServlet">
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
				<button type="submit" id="submitButton">Oppdater</button>
			</form>
			<hr>
		</div>
		<div id="midText">
			<table id="browseStandsTable">
				<c:forEach var="stand" items="${currentStands}" varStatus="i">
					<c:choose>
						<c:when test="${i.index % 3 == 0}">
							<tr class="browseStandsRow">
								<td class="browseStandsColumn columnLeft">
									<a href="StandServlet?standId=${stand.standId}">
										<img class="browseStandsStandImg" src="img/standPosters/poster_${expo.year}_${stand.standId}.png" />
										<c:out value="${stand.standName}" />
									</a>
								</td>
						</c:when>
						<c:when test="${i.index % 3 == 1}">
								<td class="browseStandsColumn columnMid">
									<a href="StandServlet?standId=${stand.standId}">
										<img class="browseStandsStandImg" src="img/standPosters/poster_${expo.year}_${stand.standId}.png" />
										<c:out value="${stand.standName}" />
									</a>
								</td>
						</c:when>
						<c:otherwise>
								<td class="browseStandsColumn columnRight">
									<a href="StandServlet?standId=${stand.standId}">
										<img class="browseStandsStandImg" src="img/standPosters/poster_${expo.year}_${stand.standId}.png" />
										<c:out value="${stand.standName}" />
									</a>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
			</table>
		</div>
	
	</div>
	


</t:GenericPage>