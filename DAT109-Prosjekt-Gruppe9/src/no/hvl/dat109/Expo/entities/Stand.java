package no.hvl.dat109.Expo.entities;

import no.hvl.dat109.Expo.Interface.StandInterface;

public class Stand implements StandInterface{
	
	String name;
	int id;
	
	
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
