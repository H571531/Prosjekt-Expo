/**
 * 
 */
package no.hvl.dat109.expo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 *
 * Visitor class
 */
@Entity
@Table(schema="exposystem",name="visitor")
public class Visitor {
	
	@Id
	String visitorId;
	
	String visitorToken;
	
	@OneToMany(mappedBy="visitor", fetch=FetchType.EAGER)
    private List<Vote> votedfor;


	public Visitor() {
	}

	public Visitor(String visitorId,String visitorToken) {
		this.visitorId=visitorId;
		this.visitorToken=visitorToken;
	}
	
	public void addVote(Vote vote) {
		votedfor.add(vote);
	}
	

	public String getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorToken() {
		return visitorToken;
	}

	public void setVisitorToken(String visitorToken) {
		this.visitorToken = visitorToken;
	}

	public List<Vote> getVotedfor() {
		return votedfor;
	}

	public void setVotedfor(List<Vote> votedfor) {
		this.votedfor = votedfor;
	}
	
	
}
