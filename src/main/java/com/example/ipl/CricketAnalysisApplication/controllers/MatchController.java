package com.example.ipl.CricketAnalysisApplication.controllers;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/ping")
    public String healthCheck() {
        return "pong";
    }

    @GetMapping("/teams")
    public List<Match> getMatches(@RequestParam String teamName) {
        return matchService.getMatches(teamName);
    }

    @GetMapping("/{teamName}/matches")
    public List<Match> getMatchesByYear(@PathVariable String teamName, @RequestParam String year) {
        return matchService.getMatchesByYear(teamName, year);
    }
}
