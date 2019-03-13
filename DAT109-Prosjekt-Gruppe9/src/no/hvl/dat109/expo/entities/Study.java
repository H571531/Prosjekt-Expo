package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="exposystem",name="study")
public class Study {

    @Id
    private String studyid;
    private String studyname;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="instituteid")
    private Institute institute;


    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="standid")
    private List<Stand> stands;


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
}
