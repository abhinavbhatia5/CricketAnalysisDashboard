import {React} from 'react';
export const MatchSmallComponent = ({match}) => {
  return (
    <div className="MatchSmallComponent">
      <p>{match.team1} vs {match.team2}</p>
      <p>Winner:{match.winningTeam}</p>
      <p>Won by:{match.margin} {match.wonBy}</p>

    </div>
  );
}