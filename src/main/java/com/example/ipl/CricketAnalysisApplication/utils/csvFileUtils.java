package com.example.ipl.CricketAnalysisApplication.utils;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import com.example.ipl.CricketAnalysisApplication.model.Team;
import com.example.ipl.CricketAnalysisApplication.repo.MatchRepository;
import com.example.ipl.CricketAnalysisApplication.repo.TeamRepository;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class csvFileUtils {
    MatchRepository matchRepository;
    TeamRepository teamRepository;

    @Autowired
    // public csvFileUtils(MatchRepository matchRepository){
    // this.matchRepository=matchRepository;
    // loacCSVdataIntoDB();
    // }
    public csvFileUtils(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        loacCSVdataIntoDB();
    }

    public List<String[]> readLineByLine(Path filePath) throws Exception {
        List<String[]> list = new ArrayList<>();
        Map<String, Team> m = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

        // List<Match> matches=new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    // list.add(line);
                    Match match = new Match();
                    match.setID(Long.parseLong(line[0]));
                    match.setCity(line[1]);
                    // match.setMatchDate((line[2]));
                    match.setMatchDate(LocalDate.parse(line[2], formatter));
                    // match.setSeason(Integer.parseInt(line[3]));
                    match.setSeason((line[3]));
                    match.setMatchNumber(line[4]);
                    match.setTeam1(line[5]);
                    match.setTeam2(line[6]);
                    match.setVenue(line[7]);
                    match.setTossWinner(line[8]);
                    match.setTossDecison(line[9]);
                    match.setSuperOver(line[10]);
                    match.setWinningTeam(line[11]);
                    match.setWonBy(line[12]);
                    // match.setMargin(Integer.parseInt(line[13]));
                    match.setMargin(line[13]);
                    match.setMethod(line[14]);
                    match.setPlayer_of_Match(line[15]);
                    match.setTeam1Players(String.join(",", line[16]));
                    match.setTeam2Players(String.join(",", line[17]));
                    match.setUmpire1(line[18]);
                    match.setUmpire2(line[19]);
                    matchRepository.save(match);

                    String t1 = match.getTeam1();
                    String t2 = match.getTeam2();
                    String w = match.getWinningTeam();
                    if (!m.containsKey(t1)) {
                        Team t = new Team(t1);
                        m.put(t1, t);
                    }
                    if (!m.containsKey(t2)) {
                        Team t = new Team(t2);
                        m.put(t2, t);
                    }
                    Team temp1 = m.get(t1);
                    Team temp2 = m.get(t2);

                    temp1.setTotalMatches(temp1.getTotalMatches() + 1);
                    temp2.setTotalMatches(temp2.getTotalMatches() + 1);

                    // m.get(t1).setTotalMatches(m.get(t1).getTotalMatches()+1);
                    // m.put(t1,m.get(t1));
                    // m.get(t2).setTotalMatches(m.get(t2).getTotalMatches()+1);
                    // m.put(t2,m.get(t2));

                    if ((temp1.getTeamName()).equals(w)) {
                        temp1.setTotalWins(temp1.getTotalWins() + 1);
                    } else if ((temp2.getTeamName()).equals(w)) {
                        temp2.setTotalWins(temp2.getTotalWins() + 1);
                    }

                    m.put(t1, temp1);
                    m.put(t2, temp2);
                    // if(t1.equals(w)){
                    // m.get(t1).setTotalWins(m.get(t1).getTotalWins()+1);
                    // m.put(t1,m.get(t1));
                    // }

                    // if (t2.equals(w)){
                    // m.get(t2).setTotalWins(m.get(t2).getTotalWins()+1);
                    //
                    // m.put(t2,m.get(t2));
                    // }
                    // f=m.get(t1).getTotalWins();
                    // System.out.println("total matches "+ m.get(t1).getTotalMatches());
                    // System.out.println(m.get(t2).getTotalMatches());

                    // matches.add(match);
                    // matchRepository.save(match);

                }
                // for(String t :m.keySet()){
                // System.out.println(m.get(t));
                // System.out.println(m.values());
                //
                //
                // }
                System.out.println(m.values());
                teamRepository.saveAll(m.values());
            }
            // for(String t:m.keySet()){
            // Team x=m.get(t);
            // teamRepository.save(x);
            // }
            // teamRepository.saveAll(m.values());
            return list;
        }
    }

    public void loacCSVdataIntoDB() {
        try {
            // csvFileUtils csvObj=new csvFileUtils();
            readLineByLine(Path.of("C:/Users/abhin/Downloads/IPL_Matches_2008_2022.csv"));

        } catch (Exception ex) {
            log.error("Error while reading csv file");
        }

    }

    // public List<String> getPlayerListFromLine(String players){
    // players=players.substring(1,players.length()-1);
    // String[] arr=players.split(",");
    // return Arrays.asList(arr);
    // }
}