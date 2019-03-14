package no.hvl.dat109.expo.entities;


import no.hvl.dat109.expo.interfaces.ExpoInterface;

/**
 * @author
 *
 */
public class Expo implements ExpoInterface {
	
	int year;
	
	/**
	 * Oppretter et nytt expo
	 * @param int year som expo avholdes
	 */
	public Expo(int year) {
		this.year = year;
	}
	
	/**
	 * Henter aaret som et expo ble avholdt
	 * @return int year til et expo
	 */
	public int getYear() {
		return year;
	}

}
