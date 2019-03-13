package no.hvl.dat109.expo.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="exposystem",name="institute")
public class Institute {
    @Id
    private String instituteid;
    private String institutename;
    
    @OneToMany(mappedBy="institute", fetch=FetchType.EAGER)
    private List<Study> studies;
    

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
