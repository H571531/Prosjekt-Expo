package no.hvl.dat109.expo.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import no.hvl.dat109.expo.entities.Stand;

@Stateless
public class StandEAO {

	@PersistenceContext(name = "expoPU")
	private EntityManager em;
	
	public List<Stand> findAllStand(){
		return em.createQuery("SELECT s from Stand s",Stand.class).getResultList();
	}
	
	public Stand findStand(String standId) {
		return em.find(Stand.class, standId);
	}

	public boolean standExists(String standId) {
		return (findStand(standId) != null);
	}

	public void addStand(Stand stand) {
		em.persist(stand);
	}
}
