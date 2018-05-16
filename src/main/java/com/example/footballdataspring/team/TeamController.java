package com.example.footballdataspring.team;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/team")
public class TeamController {

    private TeamServiceImpl service;

    public TeamController(TeamServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/index")
    public Iterable<Team> getAll(){

        return service.getAll();
    }

    @GetMapping("/index/{id}")
    public Optional<Team> getById(@PathVariable Long id){

        return service.getById(id);
    }

    @GetMapping("/find")
    public Iterable<Team> findBySubString(
            @RequestParam(value = "sub", required = false)
                    String subString){

        return service.findBySubString(subString);
    }

    @GetMapping("/appearance")
    public Iterable<Team> findByAppearance(){

        return service.findByApearences();
    }

    @PostMapping("/add")
    public Team create(@ModelAttribute Team team){
        service.create(team);

        return team;
    }

    @DeleteMapping("/remove/{id}")
    public Team remove(@PathVariable Long id){

        Team team = service.getById(id).get();
        service.remove(id);

        return team;
    }
}
