/**
 * 
 */
package no.hvl.dat109.Expo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author adria
 *
 */
@Entity
@Table(schema="ExpoSystem",name="vote")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int value;
	int standId;
	
	public Vote(String value, Stand stand) {
		standId=stand.getId();
		this.value=Integer.parseInt(value);
	}

	public int getId() {
		return id;
	}
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getStandId() {
		return standId;
	}

	public void setStandId(int standId) {
		this.standId = standId;
	}
	
	
}
