package org.farid.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "crew")
public class Crew extends BaseEntity<Long> {

    @Column(name = "tconst")
    String tconst ;// (string) - a alphanumeric unique identifier of the title

    @Column(name = "directors")
    String directors  ;// (array of nconsts) - director(s) of the given title

    @Column(name = "writers")
    String writers ;// (array of nconsts) – writer(s) of the given title

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false ,updatable = false)
    TitleBasics titleBasics;

}
