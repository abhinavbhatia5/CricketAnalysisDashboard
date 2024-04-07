package com.example.ipl.CricketAnalysisApplication.repo;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {


    @Query(value = "select* from ipl where ipl.team1=:teams or ipl.team2=:teams order by ipl.match_Date desc limit 4", nativeQuery = true)
    List<Match> GetMatchInfo(@Param("teams") String teams);

//    @Query(value="select distinct ipl.team1 from ipl ",nativeQuery = true)
//    List<String> GetAllTeams1();


    @Query(value = "SELECT * FROM ipl WHERE (ipl.team1 = :team OR ipl.team2 = :team) AND (ipl.match_Date >= :startOfYear AND ipl.match_Date <= :endOfYear)", nativeQuery = true)
    List<Match> getMatchesByYear(@Param("team") String team, @Param("startOfYear") LocalDate startOfYear, @Param("endOfYear") LocalDate endOfYear);


//    public List<Match> getMatchesByYear(String team, String year) {
//        String startOfYear = year + "-01-01";
//        String endOfYear = year + "-12-31";
//        return matchRepository.getMatchesByYear(team, startOfYear, endOfYear);
//    }



}