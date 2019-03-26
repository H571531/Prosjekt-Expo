package no.hvl.dat109.expo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.dat109.expo.interfaces.StandInterface;

/**
 * @author
 *
 */
@Entity
@Table(schema="exposystem",name="stand")
public class Stand implements StandInterface{
	
	@Id
	String standId;
	private String standName;
	
	@ManyToOne
	@JoinColumn(name="expoid")
	private Expo expo;
	
	private String authors;
	
    @ManyToOne
    @JoinColumn(name="studyid")
    private Study study;

    @OneToMany(mappedBy="stand", fetch=FetchType.EAGER)
    @JoinColumn(name="standid")
    private List<Vote> votes;
    
	public Stand() {
		
	}
	
	/**
	 * Oppretter en ny stand
	 * @param String name navnet til standen
	 * @param String id id'en til standen
	 * @param Study study hvilken studie standen er fra
	 */
	public Stand(String name, String id,Study study, Expo expo, String authors) {
		this.standName = name;
		this.standId = id;
		this.study = study;
		this.expo = expo;
		this.authors = authors;
	}

	/**
	 * Henter en stand sin id
	 * @return String standId id'en til en stand
	 */
	public String getStandId() {
		return standId;
	}

	/**
	 * Gir en stand en ny id
	 * @param String standId den nye id'en til standen
	 */
	public void setStandId(String standId) {
		this.standId = standId;
	}

	/**
	 * Henter et stand sitt navn
	 * @return String standName navnet til standen
	 */
	public String getStandName() {
		return standName;
	}

	/**
	 * Gir en stand et nytt navn
	 * @param String standName det nye navnet til standen
	 */
	public void setStandName(String standName) {
		this.standName = standName;
	}

	/**
	 * Henter studiet et stand er fra
	 * @return Study study studiet til et stand
	 */
    public Study getStudy() {
        return study;
    }

    /**
     * Gir en stand et nytt studie
     * @param Study study det nye studiet
     */
    public void setStudy(Study study) {
        this.study = study;
    }

    // Stand sin egen toString metode
    @Override
	public String toString() {
		return "Stand [standId=" + standId + ", standName=" + standName + "]";
	}

	public Expo getExpo() {
		return expo;
	}

	public void setExpo(Expo expo) {
		this.expo = expo;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	

	public List<Vote> getVotes() {
		return votes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((expo == null) ? 0 : expo.hashCode());
		result = prime * result + ((standId == null) ? 0 : standId.hashCode());
		result = prime * result + ((standName == null) ? 0 : standName.hashCode());
		result = prime * result + ((study == null) ? 0 : study.hashCode());
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
		Stand other = (Stand) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (expo == null) {
			if (other.expo != null)
				return false;
		} else if (!expo.equals(other.expo))
			return false;
		if (standId == null) {
			if (other.standId != null)
				return false;
		} else if (!standId.equals(other.standId))
			return false;
		if (standName == null) {
			if (other.standName != null)
				return false;
		} else if (!standName.equals(other.standName))
			return false;
		if (study == null) {
			if (other.study != null)
				return false;
		} else if (!study.equals(other.study))
			return false;
		return true;
	}
	
	
    
	

	

	
}
