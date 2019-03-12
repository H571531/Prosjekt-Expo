package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="exposystem",name="faculty")
public class Faculty {

    @Id
    String facultyId;
    String facultyName;


    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="standid")
    List<Stand> stands;





}
