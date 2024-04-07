import { React } from 'react';
import { Link } from 'react-router-dom';
import './MatchDetailComponent.scss';
export const MatchDetailComponent = ({ teamName, match }) => {
  if (!match) {
    return null;
  }
  const team1route = `/team/${match.team1}`;
  const team2route = `/team/${match.team2}`;
  const winningTeamRoute = `/team/${match.winningTeam}`;

  const isMatchWon = teamName === match.winningTeam;
  console.log(match.winningTeam);
  console.log(teamName);
  return (
    <div className={isMatchWon ? 'MatchDetailComponent won-match' : 'MatchDetailComponent lost-match'}>
      <div>
        <h2>
          <Link to={team1route}>{match.team1}</Link>
          vs
          <Link to={team2route}>{match.team2}</Link>
        </h2>
        <h2 className='match-date'>Date: {match.matchDate}</h2>
        <h3 className='match-venue'>At {match.venue}, {match.city}</h3>
        <h3 className='match-result'><b>{match.winningTeam} won by {match.margin} {match.wonBy}</b></h3>
      </div>

      <div className="additional-detail">
        <h3>First Innings</h3>
        <p>{match.team1}</p>
        <h3>Second Innings</h3>
        <p>{match.team2}</p>
        <h3>Man of the match</h3>
        <p>{match.playerOfMatch}</p>
        <h3>Umpires</h3>
        <p>{match.umpire1}, {match.umpire2}</p>
      </div>
    </div>
  );

}

export default MatchDetailComponent;