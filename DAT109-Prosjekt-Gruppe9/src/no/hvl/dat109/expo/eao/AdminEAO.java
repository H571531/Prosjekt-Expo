package no.hvl.dat109.expo.eao;

import no.hvl.dat109.expo.entities.Admin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * EAO for Admin
 * @author 
 *
 */
@Stateless
public class AdminEAO {

	@PersistenceContext(name = "expoPU")
	private EntityManager em;

	/**
	 * Henter alle admins og returnerer et List objekt over disse.
	 * @return List<Admin>
	 */
	public List<Admin> findAllAdmin() {
		return em.createQuery("SELECT i from Admin i", Admin.class).getResultList();
	}

	/**
	 * Finner og returnerer admin som matcher med en gitt adminId 
	 * @param String adminId
	 * @return Admin admin som matcher
	 */
	public Admin findAdmin(String adminId) {
		return em.find(Admin.class, adminId);
	}

	/**
	 * Sjekker om en admin finnes
	 * @param String adminId
	 * @return boolean true hvis finnes, false hvis ikke
	 */
	public boolean adminExists(String adminId) {
		return (findAdmin(adminId) != null);
	}

	/**
	 * Legger til et angitt admin objekt
	 * @param Admin admin som skal legges til
	 */
	public void addAdmin(Admin admin) {
		em.persist(admin);
	}
}
