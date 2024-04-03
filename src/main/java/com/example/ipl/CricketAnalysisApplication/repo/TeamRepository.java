package com.example.ipl.CricketAnalysisApplication.repo;

import com.example.ipl.CricketAnalysisApplication.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {

    @Query(value="select * from team_table where team_table.team_name=:team limit 1",nativeQuery = true)
    Team getByName(@Param("team") String teams);
}