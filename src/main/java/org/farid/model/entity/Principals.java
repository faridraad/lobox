package org.farid.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "principals")
public class Principals extends BaseEntity<Long> {


    @Column(name = "tconst")
    String tconst;// (string) - alphanumeric unique identifier of the title

    @Column(name = "ordering")
    Integer ordering;// (integer) – a number to uniquely identify rows for a given titleId

    @Column(name = "nconst")
    String nconst;// (string) - alphanumeric unique identifier of the name/person

    @Column(name = "category")
    String category;// (string) - the category of job that person was in

    @Column(name = "job")
    String job;// (string) - the specific job title if applicable, else '\N'

    @Column(name = "characters")
    String characters;// (string) - the name of the character played if applicable, else '\N'

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst", insertable = false ,updatable = false)
    TitleBasics titleBasics;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nconst", insertable = false ,updatable = false)
    NameBasics nameBasics;
}
