/**
 * 
 */
package no.hvl.dat109.expo.entities;

import javax.persistence.*;

/**
 * @author adria
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
	
	public Vote(String value, Stand stand) {
		this.stand = stand;
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
}
