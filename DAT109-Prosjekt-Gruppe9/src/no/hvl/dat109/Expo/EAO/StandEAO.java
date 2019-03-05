package no.hvl.dat109.Expo.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Expo.entities.Stand;

@Stateless
public class StandEAO {

	@PersistenceContext(name = "expoPU")
	private EntityManager em;

	public Stand findStand(int standId) {
		return em.find(Stand.class, standId);
	}

	public boolean standExists(int standId) {
		return (findStand(standId) != null);
	}

	public void addStand(Stand stand) {
		em.persist(stand);
	}
}
