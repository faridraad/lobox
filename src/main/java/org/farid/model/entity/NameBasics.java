package org.farid.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "name_basics")
public class NameBasics  extends BaseEntity<Long>{

    @Column(name = "nconst")
    String nconst ;// (string) - alphanumeric unique identifier of the title

    @Column(name = "primaryName" , length = 200, nullable = false)
    String primaryName;//(string)– name by which the person is most often credited

    @Column(name = "birthYear")
    String birthYear;//  in YYYY format

    @Column(name = "deathYear" , nullable = true)
    String deathYear;// in YYYY format if applicable, else '\N'

    @Column(name = "primaryProfession")
    String primaryProfession;// (array of strings)– the top-3 professions of the person

    @Column(name = "knownForTitles")
    String knownForTitles;// (array of tconsts) – titles the person is known for

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "nconst", insertable = false ,updatable = false)
    List<Principals> principals;
}
