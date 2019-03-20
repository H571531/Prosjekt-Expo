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
						<div class="ratingStars">
							<input class="stjerne stjerne-5" id="stjerne-5" type="radio" name="voteValue" value="5"/>
							<label class="stjerne stjerne-5" for="stjerne-5"></label>
							<input class="stjerne stjerne-4" id="stjerne-4" type="radio" name="voteValue" value="4"/>
							<label class="stjerne stjerne-4" for="stjerne-4"></label>
							<input class="stjerne stjerne-3" id="stjerne-3" type="radio" name="voteValue" value="3"/>
							<label class="stjerne stjerne-3" for="stjerne-3"></label>
							<input class="stjerne stjerne-2" id="stjerne-2" type="radio" name="voteValue" value="2"/>
							<label class="stjerne stjerne-2" for="stjerne-2"></label>
							<input class="stjerne stjerne-1" id="stjerne-1" type="radio" name="voteValue" value="1"/>
							<label class="stjerne stjerne-1" for="stjerne-1"></label>
						</div>
						<br>
						<input type="hidden" name="standId" value="${stand.standId}">
						<button id="sendVoteButton" type="submit">Send inn</button>
					</fieldset>
				</form>
			</div>
		</div>
		<script src="scripts/standJS.js"></script>
</t:GenericPage>