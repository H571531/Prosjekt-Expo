package no.hvl.dat109.expo.utils;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.entities.Vote;
import no.hvl.dat109.expo.interfaces.StandInterface;

public class VoteUtils {

	public static String handleVote(String standId, HttpServletRequest request, StandEAO sEAO, VoteEAO vEAO, Expo expo) {
		String redirect = "";
		// Midlertidig l�sning
		String voteValue = "1";
		Optional <Visitor> visitor=VerificationUtils.getVisitor(request);
		
		if(expo.isVoteRegistrationOpen()){
			if(visitor.isPresent()) {
				Stand stand = sEAO.findStand(standId);
				
				if(!visitorHasAlreadyVotedForStand(visitor, stand, vEAO)) {
					Vote vote = new Vote(voteValue,stand,visitor.get());
					vEAO.voteForStand(vote);
					
					redirect = "VoteServlet?voteCastedFor=" + standId;
				} else {
					redirect = "StandServlet?standId=" + standId;
				}
				
				
				
				
			} else if(!visitor.isPresent()) {
				redirect = "NewVisitorServlet";
			} 
		} else {
			redirect = "RegistrationClosedServlet?registration=vote";
		}
		
		
		return redirect;
	}

	public static boolean visitorHasAlreadyVotedForStand(Optional<Visitor> visitor, Stand stand, VoteEAO voteEAO) {
		List<Vote> votes = visitor.get().getVotedfor();
		boolean alreadyVoted = votes.stream()
			.map(v -> v.getStand())
			.anyMatch(v -> v.equals(stand));
		return alreadyVoted;
		

	}
}
