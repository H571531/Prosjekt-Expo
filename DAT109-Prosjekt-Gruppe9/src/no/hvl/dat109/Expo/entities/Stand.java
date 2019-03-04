package no.hvl.dat109.Expo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import no.hvl.dat109.Expo.Interface.StandInterface;

@Entity
@Table(schema="ExpoSystem",name="stand")
public class Stand implements StandInterface{
	
	@Id
	int id;
	
	String name;

	
	
	public Stand(String name, int id) {
		this.name = name;
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
}
