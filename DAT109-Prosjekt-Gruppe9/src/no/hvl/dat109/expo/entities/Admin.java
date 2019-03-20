/**
 * 
 */
package no.hvl.dat109.expo.entities;

import javax.persistence.*;

/**
 * @author 
 *
 */
@Entity
@Table(schema = "exposystem", name = "admin")
public class Admin {

	@Id
	private String username;
	
	private String hashedPassword;

	public Admin() {
	}

	/**
	 * Oppretter en ny admin
	 * @param String username
	 * @param String hashedPassord
	 */
	public Admin(String username, String hashedPassword) {
		this.username = username;
		this.hashedPassword = hashedPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}



}
