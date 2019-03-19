<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:GenericPage customTitle="Registrer Stand">


	<div id="mid">
	
	    <div id="midText">
	
	        <p>Registrer Stand</p><br>
	        <form action = "RegistrationServlet" method = "post"
	              enctype = "multipart/form-data" accept-charset="UTF-8">
	            Stand id:
	            <input type="text" name="standid" />
	            <br/>
	            Navn:
	            <input type="text" name="name">
	            <br/>
	            Forfattere:
	            <textarea rows="3" cols="30" name="authors"></textarea>
	            <br/>
	            Bilde av plakat:
	            <input type = "file" name = "image" />
	            <br />

				<select name="study">

<%--@elvariable id="institutes" type="java.util.List<java.util.Map.Entry<no.hvl.dat109.expo.entities.Institute,java.util.List<no.hvl.dat109.expo.entities.Study>>>"--%>					<c:forEach items="${institutes}" var="institute">
                        <optgroup label="<c:out value="${institute.key.institutename}"/>">
					<c:forEach items="${institute.value}" var="study">
						<option value="${study.studyid}"><c:out value="${study.studyname}"/></option>
                        </c:forEach>
					</optgroup>
					</c:forEach>
				</select>
	            <input type = "submit" value = "Registrer" />
	        </form>
	        <a href="StartServlet">Startside</a>
	    </div>
	</div>
	
	
</t:GenericPage>

