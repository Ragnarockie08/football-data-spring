package com.example.footballdataspring.match;


import com.example.footballdataspring.team.Team;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    @Column(name = "goals_home")
    private int goalsHome;
    @Column(name = "goals_away")
    private int goalsAway;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome(int goalsHome) {
        this.goalsHome = goalsHome;
    }

    public int getGoalsAway() {
        return goalsAway;
    }

    public void setGoalsAway(int goalsAway) {
        this.goalsAway = goalsAway;
    }

    public static Comparator<Match> dateComparator = (o1, o2) -> {

        int result;

        if (o1.getDate().equals(o2.getDate())){
            result = 0;
        } else if (o1.getDate().before(o2.getDate())){
            result = -1;
        } else {
            result = 1;
        }

        return result;
    };
}
