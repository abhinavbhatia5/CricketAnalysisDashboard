import {React} from 'react';
 export const MatchDetailComponent=({match})=>{
  if(!match){
    return null;
  }
  return (
    <div className="MatchDetailComponent">
    <h4>City :{match.city}</h4>
      <p><b>{match.team1} vs {match.team2}</b></p>
      <p><b>Winner:{match.winningTeam}</b></p>
      <p><b>Won by:{match.margin} {match.wonBy}</b></p>

    </div>
  );
}

export default MatchDetailComponent;