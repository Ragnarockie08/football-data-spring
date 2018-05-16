package com.example.footballdataspring.match;

import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class MatchServiceImpl implements MatchService{

    private MatchRepository repository;

    public MatchServiceImpl(MatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Match> getAll() {

        List<Match> result = new ArrayList<>();
        repository.findAll().forEach(result::add);

        Collections.sort(result, Match.dateComparator);
        return result;
    }

    @Override
    public Optional<Match> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Match match) {
        repository.save(match);
    }

    @Override
    public void remove(Long id) {

        Optional<Match> match = getById(id);

        if (match != null){
            repository.deleteById(id);
        }
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }

    @Override
    public Match findMostGoals() {

        List<Match> target = new ArrayList<>();
        repository.findTop1ByMostGoals().forEach(target::add);

        return target.get(0);
    }

    @Override
    public Iterable<Match> findByDate() {

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date date = cal.getTime();

        return repository.findByDate(date);
    }


}
