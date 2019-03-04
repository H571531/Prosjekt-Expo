package no.hvl.dat109.Expo.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Expo.entities.Stand;
import no.hvl.dat109.Expo.entities.Vote;

@Stateless
public class VoteEAO {

	@PersistenceContext(name = "votePU")
	private static EntityManager em;
	
	public static void voteForStand(Vote vote) {
		em.persist(vote);
	}
	
	public List<Vote> getVotesForStand(Stand stand){
		List<Vote>standVotes =em.createQuery("SELECT v FROM Vote v WHERE standId="+stand.getId()+";",Vote.class).getResultList();
		return standVotes;
	}
	
}
