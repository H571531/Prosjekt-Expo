<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Stand: ${stand.standName}">
    <div id="mid">
		
        <div id="midText">
        
        	<h1>${stand.standName}</h1>
		
				<div id="poster">
					<img id="posterImg" src="img/standPosters/poster_${expo.expoid}_${stand.standId}.png">
				</div>
				
				<p>Forfattere: <c:out value="${stand.authors}" /></p>
				
				<form action="AdminEditStandServlet" method="post" enctype = "multipart/form-data" accept-charset="UTF-8">
					Endre Stand-navn: <input type="text" name="standName" value="${stand.standName}" /><br />
					
					<!--  Last opp ny poster: <input type="file" name="standPoster" /><br /> -->
					
					Endre forfattere: <textarea rows="3" cols="30" name="standAuthors">${stand.authors}</textarea><br />

					Institutt: <!-- Hent alle institutter -->
						<select name="selectedInstitute">
						<c:forEach var="inst" items="${institutes}">
							<option value="${inst.instituteid}" ${((inst == stand.study.institute) ? 'selected="selected"' : '') }>${inst.institutename}</option>
						</c:forEach>
						</select> 
						<br />
					Studie:
						<select name="selectedStudy">
							<option value="all"> -- Alle --</option>
							<c:forEach var="study" items="${ ((empty selectedInst) ? studies : selectedInst.studies)}">
								<option value="${study.studyid}" ${((study == stand.study) ? 'selected="selected"' : '')}>${study.studyname}</option>
							</c:forEach>
					 	</select>
					 	<br />
					<label for="registerimage"><b>Bilde av plakat: </b></label>
					<input type = "file" id="registerimage" name = "standPoster" required/>
					<br>
					<input type="hidden" name="standId" value="${stand.standId}">
					<button type="submit" name="editStand" value="edit">Lagre endringer</button> <button type="submit" name="editStand" value="delete">Slett stand</button> 
				
				
				</form>
				<hr>				
				<p><a href="QRCodeServlet?stand=${stand.standId}">Hent QR-Kode</a></p><br>
				<p><a href="AdminBrowseServlet">Tilbake til oversikt over stands</a></p><br>
				<p><a href="AdminServlet">Tilbake til side for administrasjon</a></p><br>
        
        </div>
    </div>


</t:GenericPage>