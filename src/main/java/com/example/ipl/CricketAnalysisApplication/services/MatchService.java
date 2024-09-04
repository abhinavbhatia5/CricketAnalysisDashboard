package com.example.ipl.CricketAnalysisApplication.services;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;


    public List<Match> getMatches(String teamName) {
        return matchRepository.GetMatchInfo(teamName);
    }

    public List<Match> getMatchesByYear(String teamName, String year) {
        LocalDate startOfYear = LocalDate.parse(year + "-01-01");
        LocalDate endOfYear = LocalDate.parse(year + "-12-31");
        return matchRepository.getMatchesByYear(teamName, startOfYear, endOfYear);
    }
}
