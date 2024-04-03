import {React} from 'react';
import { Link } from 'react-router-dom'
export const MatchSmallComponent = ({match}) => {

  const team1route=`/team/${match.team1}`;
  const team2route=`/team/${match.team2}`;
  const winningTeamRoute=`/team/${match.winningTeam}`;
  return (
    <div className="MatchSmallComponent">
      <p><Link to={team1route}>{match.team1}</Link>
       vs
        <Link to={team2route}>{match.team2}</Link></p>
      <p>Winner:<Link to={winningTeamRoute}>{match.winningTeam}</Link></p>
      <p>Won by:{match.margin} {match.wonBy}</p>

    </div>
  );
}