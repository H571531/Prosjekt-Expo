<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

		
<t:GenericPage>
		<div id="mid">
			
			<div id="midText">
		
				<h1>${stand.standName}</h1>
		
				<div id="poster">
					<img id="posterImg" src="img/standPosters/poster_${expo.year}_${stand.standId}.png">
				</div>
			</div>
		
		
			<div id="voteForm">
				<form method="post" action="VoteServlet">
					<fieldset id="formStars">
						<legend>Stem på standen til publikumsprisen!</legend>
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
						<br>
						<input type="hidden" name="standId" value="${stand.standId}">
						<button id="sendVoteButton" type="submit">Send inn!</button>
					</fieldset>
				</form>
			</div>
		</div>
</t:GenericPage>
	