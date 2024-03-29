package com.example.ipl.CricketAnalysisApplication.controllers;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin
public class MatchController {
    @Autowired
    MatchRepository m;

//    @GetMapping("/read")
//    public String readCSV(){
//        System.out.println("hello");
//        return "test";
//    }
    @GetMapping("/teams")
    public List<Match> getMatches(@RequestParam String teamName){
        return m.GetMatchInfo(teamName);
    }



@GetMapping("/allTeams")
public List<String> getTeams(){
    return m.GetAllTeams1();
}
}
