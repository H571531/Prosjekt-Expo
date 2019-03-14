package no.hvl.dat109.expo.eao;


import no.hvl.dat109.expo.entities.Study;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * EAO for Study
 * @author
 *
 */
@Stateless
public class StudyEAO {

    @PersistenceContext(name = "expoPU")
    private EntityManager em;

    /**
	 * Henter alle study og returnerer et List objekt over disse.
	 * @return List<Admin>
	 */
    public List<Study> findAllStudy(){
        return em.createQuery("SELECT i from Study i", Study.class).getResultList();
    }

    /**
	 * Finner og returnerer study som matcher med en gitt studyId 
	 * @param String studyId
	 * @return Study study som matcher
	 */
    public Study findStudy(String studyId) {
        return em.find(Study.class, studyId);
    }

    /**
	 * Sjekker om et study finnes
	 * @param String studyId
	 * @return boolean true hvis finnes, false hvis ikke
	 */
    public boolean studyExist(String studyId) {
        return (findStudy(studyId) != null);
    }

    /**
     * Legger til et angitt study objekt
     * @param Study study som skal legges til
     */
    public void addStudy(Study study) {
        em.persist(study);
    }

}
