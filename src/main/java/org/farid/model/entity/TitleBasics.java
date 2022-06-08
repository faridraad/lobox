package org.farid.model.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "title_basics")
public class TitleBasics extends BaseEntity<Long>{

    @Column(name = "tconst")
    String tconst;// (string) - alphanumeric unique identifier of the title

    @Column(name = "titleType")
    String titleType;// (string) – the type/format of the title (e.g. movie, short, tvseries, tvepisode, video, etc)

    @Column(name = "primaryTitle")
    String primaryTitle;// (string) – the more popular title / the title used by the filmmakers on promotional materials at the point of release

    @Column(name = "originalTitle")
    String originalTitle;// (string) - original title, in the original language

    @Column(name = "isAdult")
    Boolean isAdult;// (boolean) - 0: non-adult title; 1: adult title

    @Column(name = "startYear")
    String startYear;// (YYYY) – represents the release year of a title. In the case of TV Series, it is the series start year

    @Column(name = "endYear")
    String endYear;// (YYYY) – TV Series end year. ‘\N’ for all other title types

    @Column(name = "runtimeMinutes")
    String runtimeMinutes;// – primary runtime of the title, in minutes

    @Column(name = "genres")
    String genres;// (string array) – includes up to three genres associated with the title

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", insertable = false ,updatable = false)
    List<Principals> principals;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", insertable = false ,updatable = false)
    List<Akas> akas;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false ,updatable = false)
    //@OneToOne(mappedBy = "crew",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Crew crews;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false ,updatable = false)
    Episode episode;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false ,updatable = false)
    Ratings ratings;
}
