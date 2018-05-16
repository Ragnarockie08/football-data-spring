package com.example.footballdataspring.match;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/match")
public class MatchController {

    private MatchServiceImpl service;

    public MatchController(MatchServiceImpl service) {
        this.service = service;
    }

    @GetMapping({"/", "/index"})
    public Iterable<Match> index(){
        return service.getAll();
    }

    @GetMapping({"/id/{id}", "/index/{id}"})
    public Optional<Match> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/best")
    public Match getBest(){
        return service.findMostGoals();
    }

    @GetMapping("/date")
    public Iterable<Match> getByDate(){
        return service.findByDate();
    }

    @PostMapping("/add")
    public Match create(@RequestBody Match match){
        service.save(match);
        return match;
    }

    @DeleteMapping("/remove/{id}")
    public Match remove(@PathVariable Long id){

        Optional<Match> match = service.getById(id);
        service.remove(id);

        return match.orElse(null);
    }

    @DeleteMapping("/remove")
    public void removeAll(){
        service.removeAll();
    }
}
