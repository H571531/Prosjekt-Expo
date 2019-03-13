package no.hvl.dat109.expo.eao;


import no.hvl.dat109.expo.entities.Institute;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InstituteEAO {

    @PersistenceContext(name = "expoPU")
    private EntityManager em;

    public List<Institute> findAllInstitute(){
        return em.createQuery("SELECT i from Institute i", Institute.class).getResultList();
    }

    public Institute findInstitute(String instituteId) {
        return em.find(Institute.class, instituteId);
    }

    public boolean instituteExist(String instituteId) {
        return (findInstitute(instituteId) != null);
    }

    public void addInstitute(Institute institute) {
        em.persist(institute);
    }

}
