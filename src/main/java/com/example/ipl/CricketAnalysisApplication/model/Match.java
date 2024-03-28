package com.example.ipl.CricketAnalysisApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Ipl")
public class Match {
    @Id
    private Long ID;
    private String City;
    private String date;
    private String Season;
    private String MatchNumber;
    private String Team1;
    private String Team2;
    private String Venue;
    private String TossWinner;
    private String TossDecison;
    private String SuperOver;
    private String WinningTeam;
    private String WonBy;
    private String Margin;
    private String method;
    private String Player_of_Match;
    private String Team1Players;
    private String Team2Players;
    private String Umpire1;
    private String Umpire2;
}
