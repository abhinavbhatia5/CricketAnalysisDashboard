package com.example.ipl.CricketAnalysisApplication.repo;

import com.example.ipl.CricketAnalysisApplication.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {


    @Query(value="select* from ipl where ipl.team1=:teams or ipl.team2=:teams order by date desc limit 4",nativeQuery = true)
    List<Match> GetMatchInfo(@Param("teams") String teams);

    @Query(value="select distinct ipl.team1 from ipl ",nativeQuery = true)
    List<String> GetAllTeams1();


}