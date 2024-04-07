package com.example.ipl.CricketAnalysisApplication.controllers;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


    @GetMapping("/{teamName}/matches")
//    public List<Match> getMatchesByYear(@PathVariable String teamName,@PathVariable String year){
//
//        return m.GetMatchesByYear(teamName, year);
//    }

    public List<Match> getMatchesByYear(@PathVariable String teamName, @RequestParam String year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String soy = (year + "-01-01");
        String eoy = year + "-12-31";
        LocalDate startOfYear = LocalDate.parse(soy, formatter);
        LocalDate endOfYear = LocalDate.parse(eoy, formatter);
        return m.getMatchesByYear(teamName, startOfYear, endOfYear);
    }


//    public List<String> getTeams(){
//        return m.GetAllTeams1();
//    }
}