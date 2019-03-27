<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:GenericPage customTitle="Registrer Stand">


	<div id="mid">
	    <div id="midText">
	    	<p class="errorMessage">${errorMessage}</p>
	        <form action = "RegistrationServlet" method = "post" enctype = "multipart/form-data" accept-charset="UTF-8">
	        	<div class="registrationContainer">
	        		<h1>Registrer Stand</h1>
	        		<p>Vennligst fyll inn dette skjemaet for å registrere en stand til expo</p>
	        		<hr>
	        		<label for="registerstandid"><b>Standid:</b></label>
	            	<input type="text" placeholder="Angi standid" name="registerstandid" required/>
	            	
	            	<label for="registername"><b>Navn:</b></label>
	            	<input type="text" placeholder="Angi standnavn" name="registerstandname" required>

	            	<label for="registerauthors"><b>Forfattere:</b></label>
	            	<textarea rows="3" cols="30" placeholder="Angi forfattere" name="registerauthors" required></textarea>
	            	
	            	<label for="registerimage"><b>Bilde av plakat: </b></label>
	            	<input type = "file" name = "registerimage" required/>
	            	<br>
	            	<br>
	            	<label for="registerstudy"><b>Velg studie: </b></label>
					<select name="registerstudy">

<%--@elvariable id="institutes" type="java.util.List<java.util.Map.Entry<no.hvl.dat109.expo.entities.Institute,java.util.List<no.hvl.dat109.expo.entities.Study>>>"--%>					<c:forEach items="${institutes}" var="institute">
                        <optgroup label="<c:out value="${institute.key.institutename}"/>">
					<c:forEach items="${institute.value}" var="study">
						<option value="${study.studyid}"><c:out value="${study.studyname}"/></option>
                        </c:forEach>
					</optgroup>
					</c:forEach>
				</select>
				<hr>
				<div class="adminBottomButtons">
	            <input type = "submit" value = "Registrer" name="registerbtn"/>
	            <a href="StartServlet" class="adminButtons">Startside</a>
	            </div>
	            </div>
	        </form>
	    </div>
	</div>
	
	
</t:GenericPage>

