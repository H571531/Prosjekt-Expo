package no.hvl.dat109.Expo.Utils;

import no.hvl.dat109.Expo.entities.Stand;

/**
 * Kun for bruk mens prosjektet er i tidlig fase - skal fjernes
 * 
 *
 */
public class ConstructionUtils {

	public static Stand setupStand(int i) {
		Stand stand = new Stand("Test-stand " + i, i);
		return stand;
	}

}
