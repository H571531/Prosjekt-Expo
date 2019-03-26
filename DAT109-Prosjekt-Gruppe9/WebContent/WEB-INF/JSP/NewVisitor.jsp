<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Registrer Deg">
    <div id="mid">

        <div id="midText">
        	<p class="errorMessage">${errorMessage}</p>
        	<p>Som en del av vår løsning for å unngå flere stemmer av samme person på en stand ber vi om at du registrerer telefonnummeret ditt.</p>
            <form action="NewVisitorServlet" method="post">
                <span>Telefonnummer: +</span><input type="number" name="telephone" value="47"/>
                <input type = "submit" value = "Registrer" />
            </form>
            <p>Telefonnummeret vil ikke bli brukt til noen markedsføring, og det vil bli slettet fra våre systemer med en gang Expo ${expo.expoid} er ferdig!</p>
        </div>
    </div>


</t:GenericPage>