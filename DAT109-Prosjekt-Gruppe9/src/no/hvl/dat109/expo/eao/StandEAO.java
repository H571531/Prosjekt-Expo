package no.hvl.dat109.expo.eao;

import no.hvl.dat109.expo.entities.Stand;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * EAO for Stand
 * @author
 *
 */
@Stateless
public class StandEAO {

	@PersistenceContext(name = "expoPU")
	private EntityManager em;

	/**
     * Henter alle stand og returnerer et List objekt over disse.
     * @return List<Stand> liste over alle stand
     */
	public List<Stand> findAllStand() {
		return em.createQuery("SELECT s from Stand s", Stand.class).getResultList();
	}

	 /**
     * Finner og returner stand som matcher med en gitt standId
     * @param String standId
     * @return Stand stand som matcher
     */
	public Stand findStand(String standId) {
		return em.find(Stand.class, standId);
	}

	/**
     * Sjekker om stand eksisterer
     * @param String standId
     * @return boolean true hvis finnes, false hvis ikke
     */
	public boolean standExists(String standId) {
		return (findStand(standId) != null);
	}

	/**
	 * Legger til et angitt stand objekt
	 * @param Stand stand som skal legges til
	 */
	public void addStand(Stand stand) {
		em.persist(stand);
	}
	
	public Stand updateStand(Stand stand) {
		return em.merge(stand);
	}

	public void deleteStand(Stand stand) {
		// TODO: Cascading for å fjerne tilhørende stemmer?
		
		stand = em.merge(stand);
		stand.getStudy().getStands().remove(stand);
		
		em.remove(stand);
	}
}
