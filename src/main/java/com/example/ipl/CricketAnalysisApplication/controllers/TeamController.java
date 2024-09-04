package com.example.ipl.CricketAnalysisApplication.controllers;

import com.example.ipl.CricketAnalysisApplication.model.Team;
import com.example.ipl.CricketAnalysisApplication.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * Get team details along with the latest matches.
     *
     * @param teamName the name of the team
     * @return the team details with the latest matches
     */
    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        return teamService.getTeamWithMatches(teamName);
    }

    /**
     * Get team details without matches (test method).
     *
     * @param teamName the name of the team
     * @return the team details without matches
     */
    @GetMapping("/{teamName}")
    public Team getTeamTest(@PathVariable String teamName) {
        return teamService.getTeam(teamName);
    }

    /**
     * Get all teams.
     *
     * @return an iterable of all teams
     */
    @GetMapping("/team")
    public Iterable<Team> getAllTeam() {
        return teamService.getAllTeams();
    }
}
