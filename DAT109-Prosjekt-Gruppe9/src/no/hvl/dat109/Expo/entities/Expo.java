package no.hvl.dat109.Expo.entities;


import no.hvl.dat109.Expo.Interface.ExpoInterface;

public class Expo implements ExpoInterface {
	
	int year;
	
	public Expo(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}

}
