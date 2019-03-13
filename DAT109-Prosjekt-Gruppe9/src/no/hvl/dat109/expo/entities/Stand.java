package no.hvl.dat109.expo.entities;

import javax.persistence.*;

import no.hvl.dat109.expo.interfaces.StandInterface;

@Entity
@Table(schema="exposystem",name="stand")
public class Stand implements StandInterface{
	
	@Id
	String standId;
	private String standName;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="studyid")
    private Study study;



	public Stand() {}
	
	public Stand(String name, String id) {
		this.standName = name;
		this.standId = id;
	}



	public String getStandId() {
		return standId;
	}



	public void setStandId(String standId) {
		this.standId = standId;
	}



	public String getStandName() {
		return standName;
	}



	public void setStandName(String standName) {
		this.standName = standName;
	}

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    @Override
	public String toString() {
		return "Stand [standId=" + standId + ", standName=" + standName + "]";
	}


	

	
}
