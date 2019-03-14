package no.hvl.dat109.expo.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.expo.entities.Admin;
import no.hvl.dat109.expo.entities.Institute;

@Stateless
public class AdminEAO {

	@PersistenceContext(name = "expoPU")
	private EntityManager em;

	public List<Admin> findAllAdmin() {
		return em.createQuery("SELECT i from Admin i", Admin.class).getResultList();
	}

	public Admin findAdmin(String adminId) {
		return em.find(Admin.class, adminId);
	}

	public boolean adminExists(String adminId) {
		return (findAdmin(adminId) != null);
	}

	public void addAdmin(Admin admin) {
		em.persist(admin);
	}
}
