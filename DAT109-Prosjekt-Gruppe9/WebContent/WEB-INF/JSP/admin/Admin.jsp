<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Administrasjon av EXPO">
    <div id="mid">
   		<div id="midUpper">
			<h1>ADMINISTRASJON</h1>
			<p>Du er logget inn som: ${Username}</p>
			<h2>${confirmChange}</h2>
			<hr />
		</div>
		
		
        <div id="midText">
        	<p><strong>Legg til ny admin:</strong></p>
			<form method="post" action="AdminServlet">
			<input type="text" name="newAdminName" />
			<input type="text" name="newAdminPass" />
			<button type="submit">Legg til ny admin</button>
			</form>
			
            <p>AKTIV EXPO: ${expo.expoid}</p>
            <hr />
            
            <form id="adminForm" method="post" action="AdminServlet">
	            <table>
	            	<tr>
	            		<th><strong>STATUS</strong></th>
	            	</tr>
	            	
	            	<tr>
	            		<td>Registrering av stands</td>
	            		<td>${(expo.standRegistrationOpen ? "Åpen" : "Lukket") }</td>
	            		<td><button type="submit" name="standRegistration" value="open">Åpne</button></td>
	            		<td><button type="submit" name="standRegistration" value="close">Lukk</button></td>
	            	</tr>
	            	<tr>
	            		<td>Registrering av stemmer</td>
	            		<td>${(expo.voteRegistrationOpen ? "Åpen" : "Lukket") }</td>
	            		<td><button type="submit" name="voteRegistration" value="open">Åpne</button></td>
	            		<td><button type="submit" name="voteRegistration" value="close">Lukk</button></td>
	            	</tr>
	            	
	            </table>
            </form>
            <hr />
            
            <p><a href="AdminBrowseServlet">Se/endre alle stands</a></p>
            <p><a href="ResultServlet">Se foreløpig statistikk</a></p>
            <p><a href="LogoutServlet">Logg ut</a></p>
        </div>
    </div>


</t:GenericPage>