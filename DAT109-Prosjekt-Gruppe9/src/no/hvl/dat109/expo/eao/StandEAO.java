package no.hvl.dat109.expo.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.expo.entities.Stand;

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
}
