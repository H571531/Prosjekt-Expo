/**
 * 
 */
package no.hvl.dat109.expo.entities;

import javax.persistence.*;

/**
 * Klasse for entity: Vote
 * @author Gruppe 9
 *
 */
@Entity
@Table(schema="exposystem",name="vote")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int voteId;
	
	private int voteValue;
	@ManyToOne
	@JoinColumn(name="standid")
	private Stand stand;
	
	@ManyToOne
	@JoinColumn(name="visitorId")
	private Visitor visitor;
	
	
	/**
	 * Oppretter en ny stemme
	 * @param String value vekten paa stemmen
	 * @param Stand stand hvilket stand stemmen er for
	 */
	public Vote(String value, Stand stand, Visitor visitor) {
		this.stand = stand;
		this.visitor=visitor;
		this.voteValue = Integer.parseInt(value);
	}
	
	public Vote() {}
	
	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public int getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public Visitor getVisitor() {
		return visitor;
	}
	
	
}
