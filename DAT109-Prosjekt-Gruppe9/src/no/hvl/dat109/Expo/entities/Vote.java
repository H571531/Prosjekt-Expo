/**
 * 
 */
package no.hvl.dat109.Expo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	int voteValue;
	int standId;
	
	public Vote(String value, Stand stand) {
		standId=stand.getStandId();
		this.voteValue=Integer.parseInt(value);
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



	public int getStandId() {
		return standId;
	}

	public void setStandId(int standId) {
		this.standId = standId;
	}
	
	
}
