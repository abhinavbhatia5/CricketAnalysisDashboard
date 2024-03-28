package com.example.ipl.CricketAnalysisApplication.controllers;

import com.example.ipl.CricketAnalysisApplication.model.Team;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TeamController {

    @GetMapping("/team")
    public Team getTeam(@RequestParam String teamName){
        System.out.println(teamName);
        return null;
    }
}
