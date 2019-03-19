package no.hvl.dat109.expo.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.expo.entities.Expo;

@Stateless
public class ExpoEAO {
	
	@PersistenceContext(name = "expoPU")
	private EntityManager em;
	
	public Expo findExpo(String expoid) {
		return em.find(Expo.class, expoid);
	}

}
