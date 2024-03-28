package com.example.ipl.CricketAnalysisApplication.repo;

import com.example.ipl.CricketAnalysisApplication.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
}
