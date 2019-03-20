package no.hvl.dat109.expo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	//TODO: Forandre til false før lansering, legge til database

	@Transient
	private boolean standRegistrationOpen = true;
	
	@Transient
	private boolean voteRegistrationOpen = true;
	
	@Transient
	private boolean verificationRequired = false;
	
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

	public boolean isStandRegistrationOpen() {
		return standRegistrationOpen;
	}

	public void setStandRegistrationOpen(boolean standRegistrationOpen) {
		this.standRegistrationOpen = standRegistrationOpen;
	}

	public boolean isVoteRegistrationOpen() {
		return voteRegistrationOpen;
	}

	public void setVoteRegistrationOpen(boolean voteRegistrationOpen) {
		this.voteRegistrationOpen = voteRegistrationOpen;
	}

	public boolean isVerificationRequired() {
		return verificationRequired;
	}

	public void setVerificationRequired(boolean verificationRequired) {
		this.verificationRequired = verificationRequired;
	}
	
	

}
