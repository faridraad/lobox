package org.farid.model.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "akas")
public class Akas extends BaseEntity<Long> {

    @Column(name = "titleid")
    String titleId;// (string) - a tconst, an alphanumeric unique identifier of the title

    @Column(name = "ordering")
    Integer ordering ;// (integer) – a number to uniquely identify rows for a given titleId

    @Column(name = "title")
    String title ;// (string) – the localized title

    @Column(name = "region")
    String region;// (string) - the region for this version of the title

    @Column(name = "language")
    String language;// (string) - the language of the title

    @Column(name = "types")
    String types;// (array) - Enumerated set of attributes for this alternative title. One or more of the following: "alternative", "dvd", "festival", "tv", "video", "working", "original", "imdbDisplay". New values may be added in the future without warning

    @Column(name = "attributes")
    String attributes ;//(array) - Additional terms to describe this alternative title, not enumerated

    @Column(name = "isOriginalTitle")
    Boolean isOriginalTitle;// (boolean) – 0: not original title; 1: original title

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titleid", insertable = false ,updatable = false)
    TitleBasics titleBasics;
}
