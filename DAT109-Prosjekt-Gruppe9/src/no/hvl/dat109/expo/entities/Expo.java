package no.hvl.dat109.expo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import no.hvl.dat109.expo.interfaces.ExpoInterface;

/**
 * @author
 *
 */
@Entity
@Table(schema="exposystem", name="expo")
public class Expo implements ExpoInterface {
	
	@Id
	String expoid;
	
	/**
	 * Oppretter et nytt expo
	 * @param int year som expo avholdes
	 */
	public Expo(String year) {
		this.expoid = year;
	}
	
	public Expo() {
		
	}
	
	/**
	 * Henter aaret som et expo ble avholdt
	 * @return int year til et expo
	 */
	public String getExpoid() {
		return expoid;
	}

}
