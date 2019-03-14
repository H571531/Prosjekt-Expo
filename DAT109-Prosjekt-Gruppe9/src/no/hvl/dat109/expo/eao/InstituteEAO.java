package no.hvl.dat109.expo.eao;

import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * EAO for Institute
 * @author 
 *
 */
@Stateless
public class InstituteEAO {

    @PersistenceContext(name = "expoPU")
    private EntityManager em;

    /**
     * Henter alle insitutt og returnerer et List objekt over disse.
     * @return List<Institute> liste over alle institutt
     */
    public List<Institute> findAllInstitute(){
        return em.createQuery("SELECT i from Institute i", Institute.class).getResultList();
    }

    /**
     * Finner og returner institutt som matcher med en gitt insituttId
     * @param String instituteId
     * @return Institute institutt som matcher
     */
    public Institute findInstitute(String instituteId) {
        return em.find(Institute.class, instituteId);
    }
    
    /**
     * Sjekker om institutt eksisterer
     * @param String instituteId
     * @return boolean true hvis finnes, false hvis ikke
     */
    public boolean standExists(String instituteId) {
        return (findInstitute(instituteId) != null);
    }

    /**
     * Legger til et angitt institute objekt
     * @param Institute institute som skal legges til
     */
    public void addInstitute(Institute institute) {
        em.persist(institute);
    }
}
