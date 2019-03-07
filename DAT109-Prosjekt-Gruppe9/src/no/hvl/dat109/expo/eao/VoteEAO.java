package no.hvl.dat109.expo.eao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;

@Stateless
public class VoteEAO {

	@PersistenceContext(name="expoPU")
	private EntityManager em;
	
	public void voteForStand(Vote vote) {
		em.persist(vote);
	}
	
	public List<Vote> getVotesForStand(Stand stand){
		List<Vote>standVotes = em.createQuery("SELECT v FROM Vote v",Vote.class).getResultList();
		standVotes = standVotes
				.stream()
				.filter(v->v.getStand().equals(stand))
				.collect(Collectors.toList());
		return standVotes;
	}

	public List<Vote> findAllVote(){
		return em.createQuery("SELECT v from Vote v",Vote.class).getResultList();
	}
	
}
