<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Registrer Deg">
    <div id="mid">

        <div id="midText">
        	<p class="errorMessage">${errorMessage}</p>
        	<p>For å unngå juks må vi be deg registrere ditt telefonnummer! Telefonnummeret vil ikke bli brukt til noen markedsføring, og det vil bli slettet fra våre maskiner med en gang Expo ${expo.expoid} er ferdig!</p>
            <form action="NewVisitorServlet" method="post">
                Telefonnummer: +
                <input type="number" name="telephone" value="47"/>
                <input type = "submit" value = "Registrer" />
            </form>
        </div>
    </div>


</t:GenericPage>