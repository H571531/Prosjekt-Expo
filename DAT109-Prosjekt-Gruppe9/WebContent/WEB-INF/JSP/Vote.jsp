<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage customTitle="Stand: ${stand.standName}">
		<div id="mid">
			
			<div id="midText">
		
				<h1>${stand.standName}</h1>
				
				<!--  Trigger the Modal -->
				<img id="posterImg" src="img/standPosters/poster_${expo.expoid}_${stand.standId}.png" alt='${stand.standName}'>
				
				<!--  The Modal -->
				<div id="imgModal" class="modal">
				
					<!-- The close button -->
					<span class="close">&times;</span>
					
					<!-- Modal content (the image) -->
					<img class="modal-content" id="img01">
					
					<!-- Modal caption (image text) -->
					<div id ="caption"></div>
				</div>
			</div>
			<div id="voteForm">
				<form method="post" action="VoteServlet">
					<fieldset id="formStars">
						<legend><b>Stem på standen til publikumsprisen!</b></legend>
						<br>
						<c:choose>
						<c:when test="${alreadyVotedCheck == true}">
						<input type="hidden" name="standId" value="${stand.standId}">
						<button id="sendVoteButton" type="submit" name="votedAlready" disabled>STEMT</button>
						</c:when>
						<c:otherwise>
						<input type="hidden" name="standId" value="${stand.standId}">
						<button id="sendVoteButton" type="submit" name="notVotedButton">STEM</button>
						</c:otherwise>
						</c:choose>
					</fieldset>
				</form>
			</div>
		</div>
		<script src="scripts/standJS.js"></script>
</t:GenericPage>