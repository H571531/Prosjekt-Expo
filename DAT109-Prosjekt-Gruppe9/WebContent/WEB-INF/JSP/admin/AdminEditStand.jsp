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
				
				<form action="AdminEditStandServlet" method="post">
					Endre Stand-navn: <input type="text" name="standName" value="${stand.standName}" /><br />
					
					<!--  Last opp ny poster: <input type="file" name="standPoster" /><br /> -->
					
					Endre forfattere: <textarea rows="3" cols="30" name="standAuthors">${stand.authors}</textarea><br />
					<input type="hidden" name="standId" value="${stand.standId}">
					<button type="submit" name="editStand" value="edit">Lagre endringer</button> <button type="submit" name="editStand" value="delete">Slett stand</button> 
				
				
				</form>
				<br>
				<p><a href="AdminBrowseServlet">Tilbake til oversikt over stands</a></p>
				<p><a href="AdminServlet">Tilbake til side for administrasjon</a></p>
        
        </div>
    </div>


</t:GenericPage>