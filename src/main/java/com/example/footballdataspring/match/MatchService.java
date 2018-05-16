package com.example.footballdataspring.match;

import com.example.footballdataspring.team.Team;

import java.util.Optional;

public interface MatchService {

    Iterable<Match> getAll();

    Optional<Match> getById(Long id);

    void save(Match match);

    void remove(Long id);

    void removeAll();

    Match findMostGoals();

    Iterable<Match> findByDate();
}
