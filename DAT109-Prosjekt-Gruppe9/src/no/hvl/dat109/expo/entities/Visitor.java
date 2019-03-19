/**
 * 
 */
package no.hvl.dat109.expo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 
 *
 */
@Entity
@Table(schema="exposystem",name="visitor")
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int visitorId;
	
	@OneToMany(mappedBy="visitor", fetch=FetchType.EAGER)
    private List<Vote> votedfor;

	public  Visitor() {
		votedfor =new ArrayList<Vote>();
	}
	
	public void addVote(Vote vote) {
		votedfor.add(vote);
	}
	
	
	public boolean haveVoted(Vote vote) {
		return votedfor.stream().anyMatch(v->v.getVoteId()==vote.getVoteId());
	}
	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	
	public List<Vote> getVotedfor() {
		return votedfor;
	}

	public void setVotedfor(List<Vote> votedfor) {
		this.votedfor = votedfor;
	}
	
	
	

	
	
	
	
	
}
