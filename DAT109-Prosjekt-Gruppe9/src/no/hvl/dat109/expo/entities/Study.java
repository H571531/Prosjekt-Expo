package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

/**
 * Klasse for entity: Study
 * @author Gruppe 9
 *
 */
@Entity
@Table(schema="exposystem",name="study")
public class Study {

    @Id
    private String studyid;
    private String studyname;

    @ManyToOne
    @JoinColumn(name="instituteid")
    private Institute institute;


	@OneToMany(mappedBy="study", fetch=FetchType.EAGER)
    private List<Stand> stands;
	
	public Study() {
		
	}
	
	public Study(String studyid, String studyname, Institute institute, List<Stand> stands) {
		this.studyid = studyid;
		this.studyname = studyname;
		this.institute = institute;
		this.stands = stands;
	}

    public String getStudyid() {
        return studyid;
    }

    public String getStudyname() {
        return studyname;
    }

    public List<Stand> getStands() {
        return stands;
    }

    public Institute getInstitute() {
        return institute;
    }
    
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studyid == null) ? 0 : studyid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Study other = (Study) obj;
		if (studyid == null) {
			if (other.studyid != null)
				return false;
		} else if (!studyid.equals(other.studyid))
			return false;
		return true;
	}
}
