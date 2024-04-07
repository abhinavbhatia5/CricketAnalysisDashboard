import {React} from 'react';
import { Link } from 'react-router-dom';
import './MatchSmallComponent.scss';
export const MatchSmallComponent = ({teamName,match}) => {

  if (!match) return null;

  const team1route=`/team/${match.team1}`;
  const team2route=`/team/${match.team2}`;
  const winningTeamRoute=`/team/${match.winningTeam}`;
  const isMatchWon=teamName===match.winningTeam ?true:false;
  console.log(match.winningTeam);
  console.log(teamName);
  return (
    <div className={isMatchWon ? 'MatchDetailComponent won-match' : 'MatchDetailComponent lost-match'}>
      <h2><Link to={team1route}>{match.team1}</Link>
       vs
        <Link to={team2route}>{match.team2}</Link></h2>
      <p>{match.winningTeam} won by {match.margin} {match.wonBy}</p>

    </div>
  );
}