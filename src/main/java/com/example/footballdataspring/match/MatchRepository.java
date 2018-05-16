package com.example.footballdataspring.match;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    @Query(
            "select m from Match m ORDER BY (m.goalsAway + m.goalsHome) DESC"
    )
    Iterable<Match> findTop1ByMostGoals();

    @Query("select m from Match m " +
            "where m.date >= :currentDate"
    )
    Iterable<Match> findByDate(@Param("currentDate") Date date);

}
