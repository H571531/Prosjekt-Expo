package no.hvl.dat109.Expo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import no.hvl.dat109.Expo.Interface.ExpoInterface;
@Entity
@Table(schema="ExpoSystem",name="expo")
public class Expo implements ExpoInterface {
	
	int year;
	
	public Expo(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}

}
