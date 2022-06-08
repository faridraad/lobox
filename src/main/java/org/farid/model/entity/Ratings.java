package org.farid.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Ratings extends BaseEntity<Long> {

    @Column(name = "tconst")
    String tconst ;// (string) - alphanumeric unique identifier of the title
    Double averageRating ;// – weighted average of all the individual user ratings
    Integer numVotes;// - number of votes the title has received

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false ,updatable = false)
    TitleBasics titleBasics;
}
