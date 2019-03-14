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
	String userName;
	String hashedPassword;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminId;

	public Admin(String userName, String hashedPassord) {
		this.adminId = adminId;
		this.userName = userName;
		this.hashedPassword = hashedPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
