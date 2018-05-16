package com.example.footballdataspring.team;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Team> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Team> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Team> findBySubString(String subString) {
        return repository.findAllByNameContains(subString);
    }

    @Override
    public Iterable<Team> findByApearences() {
        return repository.findByMoreThan1Appearences();
    }

    @Override
    public void create(Team team) {
        repository.save(team);
    }

    @Override
    public void remove(Long id) {

        if (getById(id) != null){
            repository.deleteById(id);
        }
    }

}
