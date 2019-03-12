<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage>


	<div id="mid">
	
	    <div id="midText">
	
	        <p>Registrer Stand</p><br>
	        <form action = "RegistrationServlet" method = "post"
	              enctype = "multipart/form-data">
	            Stand id:
	            <input type="text" name="standid" />
	            <br/>
	            Navn:
	            <input type="text" name="name">
	            <br/>
	            Bilde av plakat:
	            <input type = "file" name = "image" />
	            <br />
	            <input type = "submit" value = "Registrer" />
	        </form>
	        <a href="StartServlet">Startside</a>
	    </div>
	</div>
	
	
</t:GenericPage>

