package no.hvl.dat109.expo.entities;

import no.hvl.dat109.expo.interfaces.StandInterface;

import javax.persistence.*;

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


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="studyid")
    private Study study;

	public Stand() {
		
	}
	
	/**
	 * Oppretter en ny stand
	 * @param String name navnet til standen
	 * @param String id id'en til standen
	 * @param Study study hvilken studie standen er fra
	 */
	public Stand(String name, String id,Study study) {
		this.standName = name;
		this.standId = id;
		this.study = study;
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


	

	
}
