package no.hvl.dat109.expo.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.expo.entities.Expo;


/**
 * EAO for Expo
 * @author Gruppe 9
 *
 */
@Stateless
public class ExpoEAO {
	
	@PersistenceContext(name = "expoPU")
	private EntityManager em;
	
	/**
	 * Finner en expo, gitt ved årstall
	 * @param expoid Årstall for expo som skal finnes
	 * @return Expo med gitt årtall hvis funnet, null hvis ikke funnet
	 */
	public Expo findExpo(String expoid) {
		return em.find(Expo.class, expoid);
	}

	/**
	 * Oppdaterer gitt Expo i database
	 * @param expo Expo som skal oppdateres
	 * @return Oppdatert Expo-objekt
	 */
	public Expo updateExpo(Expo expo) {
		return em.merge(expo);
		
	}

	public void createExpo(Expo expo) {
		em.persist(expo);
	}

}
