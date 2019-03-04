package no.hvl.dat109.Expo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import no.hvl.dat109.Expo.Interface.StandInterface;

@Entity
@Table(schema="exposystem",name="stand")
public class Stand implements StandInterface{
	
	@Id
	int standId;
	
	String standName;

	
	
	public Stand(String name, int id) {
		this.standName = name;
		this.standId = id;
	}



	public int getStandId() {
		return standId;
	}



	public void setStandId(int standId) {
		this.standId = standId;
	}



	public String getStandName() {
		return standName;
	}



	public void setStandName(String standName) {
		this.standName = standName;
	}


	

	
}
