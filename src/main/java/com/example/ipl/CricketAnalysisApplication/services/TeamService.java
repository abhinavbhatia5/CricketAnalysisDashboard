package com.example.ipl.CricketAnalysisApplication.services;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.model.Team;
import com.example.ipl.CricketAnalysisApplication.repo.MatchRepository;
import com.example.ipl.CricketAnalysisApplication.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    /**
     * Get team details along with the latest matches.
     *
     * @param teamName the name of the team
     * @return the team details with the latest matches
     */
    public Team getTeamWithMatches(String teamName) {
        Team team = teamRepository.getByName(teamName);
        List<Match> matchList = matchRepository.GetMatchInfo(teamName);
        team.setLatestMatches(matchList);
        return team;
    }

    /**
     * Get team details without matches.
     *
     * @param teamName the name of the team
     * @return the team details without matches
     */
    public Team getTeam(String teamName) {
        return teamRepository.getByName(teamName);
    }

    /**
     * Get all teams.
     *
     * @return an iterable of all teams
     */
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
