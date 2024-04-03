package com.example.ipl.CricketAnalysisApplication.controllers;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.model.Team;
import com.example.ipl.CricketAnalysisApplication.repo.MatchRepository;
import com.example.ipl.CricketAnalysisApplication.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TeamController {

    TeamRepository teamRepository;
    MatchRepository matchRepository;

    @Autowired
    TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository=teamRepository;
        this.matchRepository=matchRepository;
    }
    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team t=teamRepository.getByName(teamName);
        List<Match> matchList=matchRepository.GetMatchInfo(teamName);
        t.setLatestMatches(matchList);

//        System.out.println("hi");
//        System.out.println(t);
        return t;
    }
}