package org.farid.repository;

import org.farid.model.entity.Principals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PrincipalsRepository extends JpaRepository<Principals, Long> {

    @Query(value =
            "select\n" +
                    "    tb.title_type , primary_title from title_basics tb\n" +
                    "left join\n" +
                    "    PRINCIPALS p\n" +
                    "on\n" +
                    "    p.tconst= tb.tconst\n" +
                    "left join\n" +
                    "    name_basics nb\n" +
                    "on\n" +
                    "    nb.nconst = p.nconst\n" +
                    "where\n" +
                    "      tb.TCONST in (select TCONST from PRINCIPALS where CATEGORY in( 'director','writer') group by NCONST having count(NCONST)=2)\n" +
                    "  and\n" +
                    "      nb.death_year <> '\\N'", nativeQuery = true)
    List<Object[]> getTitleDirectorWriterAreSame();

}
