package no.hvl.dat109.Expo.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import no.hvl.dat109.Expo.entities.Stand;

@Stateless
public class StandEAO {

	@PersistenceContext(name = "expoPU")
	private EntityManager em;
	
	public List<Stand> findAllStand(){
		List<Stand> all =em.createQuery("SELECT s FROM Kill s",Stand.class).getResultList();
		return all;
	}
	
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
