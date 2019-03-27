/**
 * 
 */
package no.hvl.dat109.expo.eao;

import no.hvl.dat109.expo.entities.Visitor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * EAO for Visitor
 * @author Gruppe 9
 *
 */
@Stateless
public class VisitorEAO {
	@PersistenceContext(name = "expoPU")
	private EntityManager em;

	/**
	 * Henter alle Visitors og returnerer et List objekt over disse.
	 * @return List<Visitor>
	 */
	public List<Visitor> findAllVisitor() {
		return em.createQuery("SELECT v from Visitor V", Visitor.class).getResultList();
	}

	/**
	 * Finner og returnerer visitor som matcher med en gitt visitorId 
	 * @param int visitorId
	 * @return Visitor visitor med samme id
	 */
	public Visitor findVisitor(String visitorId) {
		return em.find(Visitor.class, visitorId);
	}

	/**
	 * Sjekker om en visitor finnes
	 * @param int visitorId
	 * @return boolean true hvis finnes, false hvis ikke
	 */
	public boolean visitorExists(String visitorId) {
		return findVisitor(visitorId) != null;
	}

	/**
	 * Legger til et angitt visitor objekt
	 * @param Visitor visitor som skal legges til
	 * @return 
	 */
	public Visitor addVisitor(Visitor visitor) {
		em.persist(visitor);
		return visitor;
	}
}
