package com.example.ipl.CricketAnalysisApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Slf4j
@Setter
@NoArgsConstructor
@ToString
@Entity
//@GenericGenerator(name = "native_generator", strategy = "native")
@Table( name="TeamTable")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String teamName;
    private int totalMatches;
    private int totalWins;

    @Transient
    private List<Match> latestMatches;
    public Team(String teamName) {

        this.teamName=teamName;
//        this.totalDraws=0.0;
        this.totalWins=0;
        this.totalMatches=0;
//        this.totalLoss=0.0;
    }
}