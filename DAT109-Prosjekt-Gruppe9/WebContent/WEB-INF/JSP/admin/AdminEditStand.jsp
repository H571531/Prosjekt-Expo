<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Stand: ${stand.standName}">
    <div id="mid">
		<div id="midUpper"><c:if test="${not empty confirmEdit}"><h3>Oppdateringene er lagret!</h3><br><p>(Hvis poster er oppdatert kan det ta noen sekunder før oppdatert bilde vises - prøv å oppdater denne siden hvis ny poster ikke vises)</c:if></div>
        <div id="midText">
        	
        	<h1><c:out value="${stand.standName}" /></h1>
				<p>Stand-ID: ${stand.standId}</p>
				<div id="poster">
					<img id="posterImg" src="img/standPosters/poster_${expo.expoid}_${stand.standId}.png?v=${time}">
				</div>
				<p>Forfattere: <c:out value="${stand.authors}" /></p>
				
				<form action="AdminEditStandServlet" method="post" enctype = "multipart/form-data" accept-charset="UTF-8">
					<label for="standName"><b>Endre stand navn</b></label>
					<input type="text" name="standName" placeholder="Angi standnavn" value="<c:out value="${stand.standName}" />"/><br/>
					
					<!--  Last opp ny poster: <input type="file" name="standPoster" /><br /> -->
					<label for="standAuthors"><b>Endre stand forfattere: </b></label>
					<textarea rows="3" cols="30" name="standAuthors" placeholder="Angi forfattere"><c:out value="${stand.authors}"/></textarea><br/>

						<!-- Hent alle institutter -->
						<label for="selectedInstitute"><b>Endre institutt: </b></label>
						<select name="selectedInstitute">
						<c:forEach var="inst" items="${institutes}">
							<option value="${inst.instituteid}" ${((inst == stand.study.institute) ? 'selected="selected"' : '') }>${inst.institutename}</option>
						</c:forEach>
						</select> 
						<br>
						<br>
						<label for="selectedStudy"><b>Endre studie: </b></label>
						<select name="selectedStudy">
							<option value="all"> -- Alle --</option>
							<c:forEach var="study" items="${ ((empty selectedInst) ? studies : selectedInst.studies)}">
								<option value="${study.studyid}" ${((study == stand.study) ? 'selected="selected"' : '')}>${study.studyname}</option>
							</c:forEach>
					 	</select>
					 	<br>
					 	<br>
					<label for="registerimage"><b>Bilde av plakat: </b></label>
					<input type = "file" id="registerimage" name = "standPoster" />
					<br>
					<br>
					<input type="hidden" name="standId" value="${stand.standId}">
					<input type="hidden" name="standToken" value="${stand.token}">
					<button type="submit" name="editStand" value="edit">Lagre endringer</button> <c:if test="${not empty adminLoggedIn}"><button type="submit" name="editStand" value="delete">Slett stand</button> </c:if>
				
				
				</form>
				<hr>
				<br>
				<p><a href="QRCodeServlet?stand=${stand.standId}" class="adminButtons">Hent QR-Kode</a></p>
				<br>
				<c:if test="${not empty adminLoggedIn}">
					<p><a href="AdminBrowseServlet" class="adminButtons">Tilbake til oversikt</a></p>
					<br>
					<p><a href="AdminServlet" class="adminButtons">Tilbake til administrasjon</a></p>	
				</c:if>
        </div>
    </div>


</t:GenericPage>