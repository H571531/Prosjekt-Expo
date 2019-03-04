package no.hvl.dat109.Expo.Utils;

import no.hvl.dat109.Expo.EAO.StandEAO;
import no.hvl.dat109.Expo.entities.Stand;

/**
 * Kun for bruk mens prosjektet er i tidlig fase - skal fjernes
 * 
 *	Siden jeg er lat har jeg bare lagt inn tillegging til databasen her... 
 *		-Adrian
 */
public class ConstructionUtils {
	static StandEAO sEAO=new StandEAO();
	public static Stand setupStand(int i) {
		Stand stand = new Stand("Test-stand " + i, i);
		sEAO.addStand(stand);
		return stand;
	}

}
