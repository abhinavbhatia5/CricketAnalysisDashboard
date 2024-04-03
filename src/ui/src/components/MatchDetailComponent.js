import { React } from 'react';
import { Link } from 'react-router-dom'
export const MatchDetailComponent = ({ match }) => {
  if (!match) {
    return null;
  }
  const team1route=`/team/${match.team1}`;
  const team2route=`/team/${match.team2}`;
  const winningTeamRoute=`/team/${match.winningTeam}`;
  return (
    <div className="MatchDetailComponent">
      <h4>City :{match.city}</h4>
      <h2>
        <Link to={team1route}>{match.team1}</Link>
         vs 
        <Link to={team2route}>{match.team2}</Link>
      </h2>
      <p><b>Winner:<Link to={winningTeamRoute}>{match.winningTeam}</Link></b></p>
      <p><b>Won by:{match.margin} {match.wonBy}</b></p>

    </div>
  );
}

export default MatchDetailComponent;