/**
 * 
 */
package no.hvl.dat109.expo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mirnes
 *
 */
@Entity
@Table(schema = "exposystem", name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminId;
	
	String userName;
	String hashedPassword;

	public Admin() {
	}

	/**
	 * Oppretter en ny admin
	 * @param String userName
	 * @param String hashedPassord
	 */
	public Admin(String userName, String hashedPassord) {
		this.userName = userName;
		this.hashedPassword = hashedPassword;
	}

	/**
	 * Henter brukernavnet til en admin
	 * @return String userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Gir en admin et nytt brukernavn
	 * @param String userName det nye brukernavnet
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Henter det hashede passordet til en admin
	 * @return String hashedPassword passordet til en admin
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * Gir en admin et nytt hashet passord
	 * @param String hashedPassword det nye passordet
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	/**
	 * Henter id til en admin
	 * @return int adminId id til en admin
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * Gir en admin en ny id
	 * @param int adminId den nye id'en
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
