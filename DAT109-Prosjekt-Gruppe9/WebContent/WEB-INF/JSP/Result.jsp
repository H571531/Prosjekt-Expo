<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Resultatliste">

	<div id="mid">
	
	    <div id="midText">
	
	   		<h1>Topp 5</h1><br>
	        <hr>
			<p><strong>Total:</strong></p>
	        <%--@elvariable id="result" type="no.hvl.dat109.expo.statistics.StandResult"--%>
	        <c:forEach items="${toplist}" var="result" varStatus="vinnerListCount">
	        	<c:choose>
	        		<c:when test="${vinnerListCount.count == 1}">
	        		<div class="gold">
	        		<h3>Førsteplass:</h3>
	        		<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</div>
	        		</c:when>
	        		<c:when test="${vinnerListCount.count == 2}">
	        		<div class="silver">
	        		<h3>Andreplass:</h3>
	        		<p class="silver"><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</div>
	        		</c:when>
	        		<c:when test="${vinnerListCount.count == 3}">
	        		<div class="bronze">
	        		<h3>Tredjeplass:</h3>
	        		<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</div>
	        		</c:when>
	        		<c:when test="${vinnerListCount.count == 4}">
	        		<div>
	        		<h3>Fjerdeplass:</h3>
	        		<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</div>
	        		</c:when>
	        		<c:when test="${vinnerListCount.count == 5}">
	        		<div>
	        		<h3>Femteplass:</h3>
	        		<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</div>
	        		</c:when>
	        		<c:otherwise>
	        		<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</p>
	        		</c:otherwise>
	        	</c:choose>
	        </c:forEach>
				<%--@elvariable id="institute" type="no.hvl.dat109.expo.statistics.InstituteResult"--%>
			<c:forEach items="${institutes}" var="institute">
				<p><strong><c:out value="${institute.institute.institutename}" /></strong></p>
			<c:forEach items="${institute.getTopStandsTotal(5)}" var="result">
				<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
				</p>
			</c:forEach>
			</c:forEach>
	        <hr>
	
	        <a href="StartServlet">Startside</a>
	    </div>
	</div>
	
</t:GenericPage>
	