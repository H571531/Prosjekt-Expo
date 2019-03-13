<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Resultatliste">

	<div id="mid">
	
	    <div id="midText">
	
	   		<p>Top 5</p><br>
	        <hr>
			<p>Total:</p>
	        <%--@elvariable id="result" type="no.hvl.dat109.expo.statistics.StandResult"--%>
	        <c:forEach items="${toplist}" var="result">
	            <p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.weightedAverage}"/>
				</p>
	        </c:forEach>
				<%--@elvariable id="study" type="no.hvl.dat109.expo.statistics.StudyResult"--%>
			<c:forEach items="${studies}" var="study">
				<p><c:out value="${study.study.studyname}" /></p>
			<c:forEach items="${study.getTopStands(5)}" var="result">
				<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.weightedAverage}"/>
				</p>
			</c:forEach>
			</c:forEach>
	        <hr>
	
	        <a href="StartServlet">Startside</a>
	    </div>
	</div>
	
</t:GenericPage>
	