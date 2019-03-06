package no.hvl.dat109.expo.entities;


import no.hvl.dat109.expo.interfaces.ExpoInterface;

public class Expo implements ExpoInterface {
	
	int year;
	
	public Expo(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}

}
