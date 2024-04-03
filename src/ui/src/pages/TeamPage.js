import {React, useEffect,useState} from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
import { useParams } from 'react-router-dom'


export const TeamPage=()=>{
    const[team,setTeam]=useState({latestMatches:[]});
    const teamName=useParams();

  useEffect(
    ()=>{
      const fetchMatches=async()=>{

//        fetch("http://localhost:8082/team/Chennai Super Kings")
//        .then(response=>response.json())
//        .then(data=>console.log(data));
        const response= await fetch(`http://localhost:8082/team/${teamName.teamName}`);
                const obj= await response.json();
                console.log(obj);
                setTeam(obj);
      };
      fetchMatches();

    },[teamName]
  );
  if(!team || !team.latestMatches) {
  return <h1>Team Not Found</h1>;
  }

  return (
    <div className="TeamPage">
       <h2>{team.teamName}</h2>
      <MatchDetailComponent match={team.latestMatches[0]}/>
      {team.latestMatches.slice(1).map((match) => <MatchSmallComponent match={match}/>)}
      <h4>Total Matches: {team.totalMatches}</h4>
      <h4>Total Wins: {team.totalWins}</h4>


    </div>
  );
}
export default TeamPage;
