<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="EXPO ${expo.expoid}">
    <div id="mid">
		
		
        <div id="midText">
        	<p>Takk! Du er nå logget ut.</p>
        	<br>
        	<p><a href="LoginServlet">Logg inn igjen</a></p>
        </div>
    </div>


</t:GenericPage>