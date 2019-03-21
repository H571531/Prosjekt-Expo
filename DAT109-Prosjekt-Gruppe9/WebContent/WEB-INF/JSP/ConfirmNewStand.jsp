<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Stand: ${stand.standName}">
    <div id="mid">
		
        <div id="midText">
        	<h2>Takk! Din stand er registrert!</h2><br>
        	<h1>${stand.standName}</h1>
		
				<div id="poster">
					<img id="posterImg" src="img/standPosters/poster_${expo.expoid}_${stand.standId}.png">
				</div>
				
				<p>Forfattere: <c:out value="${stand.authors}" /></p><br />

				<p>Institutt: ${stand.study.institute.institutename}</p>
						
				<p>Studie: ${stand.study.studyname}</p><br />
							
				<p><a href="QRCodeServlet?stand=${stand.standId}">Hent QR-Kode</a></p>
				
        
        </div>
    </div>


</t:GenericPage>