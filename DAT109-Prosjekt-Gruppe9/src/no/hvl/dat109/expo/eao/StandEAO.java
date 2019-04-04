package no.hvl.dat109.expo.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;
import no.hvl.dat109.expo.entities.Vote;

/**
 * EAO for Stand
 * @author Gruppe 9
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
		return findStand(standId) != null;
	}

	/**
	 * Legger til et angitt stand objekt
	 * @param Stand stand som skal legges til
	 */
	public void addStand(Stand stand) {
		em.persist(stand);
	}
	
	/**
	 * Oppdaterer gitt Stand i database
	 * @param stand Stand som skal oppdateres
	 * @return oppdatert Stand-objekt
	 */
	public Stand updateStand(Stand stand) {
		Study study = em.find(Study.class, stand.getStudy());
		if(!study.getStands().contains(stand)) {
			study.getStands().add(stand);
		}
		
		return em.merge(stand);
	}
	
	
	/**
	 * Fjerner gitt Stand fra database
	 * @param stand Stand som skal fjernes
	 */
	public void deleteStand(Stand stand) {
		stand = em.merge(stand);
		stand.getStudy().getStands().remove(stand);
		
		em.remove(stand);
	}
}
