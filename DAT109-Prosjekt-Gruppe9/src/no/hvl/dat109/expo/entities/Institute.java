package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

/**
 * Klasse for entity: Institute
 * @author Gruppe 9
 */
@Entity
@Table(schema="exposystem",name="institute")
public class Institute {
    @Id
    private String instituteid;
    private String institutename;
    
    @OneToMany(mappedBy="institute", fetch=FetchType.EAGER)
    private List<Study> studies;
    
    
    public Institute() {
    	
    }
    
    public Institute(String instituteid, String institutename) {
    	this.instituteid = instituteid;
    	this.institutename = institutename;
    }
    
    public String getInstituteid() {
        return instituteid;
    }

    public String getInstitutename() {
        return institutename;
    }
    
 
    public List<Study> getStudies(){
    	return studies;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instituteid == null) ? 0 : instituteid.hashCode());
		return result;
	}

	// Egen equals metode for institutt objekt
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Institute other = (Institute) obj;
		if (instituteid == null) {
			if (other.instituteid != null)
				return false;
		} else if (!instituteid.equals(other.instituteid))
			return false;
		return true;
	}
    
    
}
