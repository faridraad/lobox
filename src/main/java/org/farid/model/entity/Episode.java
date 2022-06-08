package org.farid.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "episode")
public class Episode extends BaseEntity<Long> {


    @Column(name = "tconst")
    String tconst;// (string) - alphanumeric identifier of episode

    @Column(name = "parentTconst")
    String parentTconst;// (string) - alphanumeric identifier of the parent TV Series

    @Column(name = "seasonNumber")
    Integer seasonNumber;// (integer) – season number the episode belongs to

    @Column(name = "episodeNumber")
    Integer episodeNumber;// (integer) – episode number of the tconst in the TV series

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false ,updatable = false)
    TitleBasics titleBasics;
}
