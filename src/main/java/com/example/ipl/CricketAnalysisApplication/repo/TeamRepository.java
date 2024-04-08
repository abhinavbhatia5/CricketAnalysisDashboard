    package com.example.ipl.CricketAnalysisApplication.repo;

import com.example.ipl.CricketAnalysisApplication.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {

    @Query(value = "select * from team_table where team_table.team_name=?1 limit 1;", nativeQuery = true)
    Team getByName(String teams);


    // @Query(value = "select distinct team_name from team_table;", nativeQuery = true)
    // List<String> AllTeams();

    


}