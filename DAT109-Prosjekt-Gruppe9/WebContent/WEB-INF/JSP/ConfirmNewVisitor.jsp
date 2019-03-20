<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Takk!">
    <div id="mid">

        <div id="midText">
        	<p>Takk! Du vil straks motta en SMS med en lenke. Vennligst åpne denne lenken for å stemme!</p> <br />
        	<p><a href="${verificationURL}">${verificationURL}</a></p>
        </div>
    </div>


</t:GenericPage>