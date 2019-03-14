/**
 * 
 */
package no.hvl.dat109.expo.entities;

import javax.persistence.*;

/**
 * @author adrian
 *
 */
@Entity
@Table(schema="exposystem",name="vote")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int voteId;
	
	private int voteValue;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="standid")
	private Stand stand;
	
	/**
	 * Oppretter en ny stemme
	 * @param String value vekten paa stemmen
	 * @param Stand stand hvilket stand stemmen er for
	 */
	public Vote(String value, Stand stand) {
		this.stand = stand;
		this.voteValue = Integer.parseInt(value);
	}
	
	public Vote() {}
	
	/**
	 * Henter id'en til en stemme
	 * @return String voteId id'en til en stemme
	 */
	public int getVoteId() {
		return voteId;
	}

	/**
	 * Angir en ny id for en stemme
	 * @param String voteId den nye id'en til stemmen
	 */
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	/**
	 * Henter vekten paa stemmen
	 * @return int voteValue vekten paa stemmen
	 */
	public int getVoteValue() {
		return voteValue;
	}

	/**
	 * Angir en ny vekt for en stemme
	 * @param int voteValue den nye vekten
	 */
	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	/**
	 * Henter standen til stemmen
	 * @return Stand stand til stemmen
	 */
	public Stand getStand() {
		return stand;
	}

	/**
	 * Angir en ny stand som stemmen er for
	 * @param Stand stand den nye standen
	 */
	public void setStand(Stand stand) {
		this.stand = stand;
	}
}
