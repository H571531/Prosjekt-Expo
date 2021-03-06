package no.hvl.dat109.expo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Klasse for entity: Expo
 * @author Gruppe 9
 *
 */
@Entity
@Table(schema="exposystem", name="expo")
public class Expo  {
	
	@Id
	private String expoid;
	
	private boolean voteRegistrationOpen;
	private boolean statisticsOpenToPublic;
	
	
	//Ikke i bruk i nåværende implementasjon
	@Transient
	private boolean standRegistrationOpen = true;
	@Transient
	private boolean verificationRequired = false;
	
	
	
	/**
	 * Oppretter et nytt expo
	 * @param int year som expo avholdes
	 */
	public Expo(String year, boolean voteRegistrationOpen, boolean statisticsOpenToPublic) {
		this.expoid = year;
		this.voteRegistrationOpen = voteRegistrationOpen;
		this.statisticsOpenToPublic = statisticsOpenToPublic;
	}
	
	public Expo() {
		
	}
	
	/**
	 * Henter året som et expo ble avholdt
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
	
	public boolean isStatisticsOpenToPublic() {
		return statisticsOpenToPublic;
	}

	public void setStatisticsOpenToPublic(boolean statisticsOpenToPublic) {
		this.statisticsOpenToPublic = statisticsOpenToPublic;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expoid == null) ? 0 : expoid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expo other = (Expo) obj;
		if (expoid == null) {
			if (other.expoid != null)
				return false;
		} else if (!expoid.equals(other.expoid))
			return false;
		return true;
	}
	
	

}
