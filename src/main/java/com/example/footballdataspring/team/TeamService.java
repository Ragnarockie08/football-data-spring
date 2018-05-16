package com.example.footballdataspring.team;

import java.util.Optional;

public interface TeamService {

    Iterable<Team> getAll();

    Optional<Team> getById(Long id);

    void create(Team team);

    void remove(Long id);

    Iterable<Team> findBySubString(String subString);

    Iterable<Team> findByApearences();

}
