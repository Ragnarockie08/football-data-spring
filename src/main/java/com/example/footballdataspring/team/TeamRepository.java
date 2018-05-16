package com.example.footballdataspring.team;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Iterable<Team> findAllByNameContains(String toFind);

    @Query(value = "SELECT t " +
            "FROM " +
            "    Team t LEFT JOIN " +
            "    Match m ON m.awayTeam = t.id OR m.homeTeam = t.id " +
            "  GROUP BY t.id " +
            "  HAVING (COUNT(t.id) > 1) " +
            "  ORDER BY COUNT(t.id) desc")
    Iterable<Team> findByMoreThan1Appearences();


}
