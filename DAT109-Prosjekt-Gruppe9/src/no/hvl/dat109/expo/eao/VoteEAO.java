package no.hvl.dat109.expo.eao;

import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EAO for Vote
 * @author
 *
 */
@Stateless
public class VoteEAO {

	@PersistenceContext(name="expoPU")
	private EntityManager em;
	
	/**
	 * Legger til en vote for en stand
	 * @param Vote vote som skal legges til
	 */
	public void voteForStand(Vote vote) {
		em.persist(vote);
	}
	
	/**
	 * Henter alle stemmene for en stand og returnerer en liste over de
	 * @param Stand stand som skal hente stemmer fra
	 * @return List<Vote> liste over alle stemmene til en stand
	 */
	public List<Vote> getVotesForStand(Stand stand){
		List<Vote>standVotes = em.createQuery("SELECT v FROM Vote v",Vote.class).getResultList();
		standVotes = standVotes
				.stream()
				.filter(v->v.getStand().equals(stand))
				.collect(Collectors.toList());
		return standVotes;
	}

	/**
	 * Henter alle stemmene for alle stands og returnerer en liste over de
	 * @return List<Vote> liste over alle stemmene
	 */
	public List<Vote> findAllVote(){
		return em.createQuery("SELECT v from Vote v",Vote.class).getResultList();
	}
}
