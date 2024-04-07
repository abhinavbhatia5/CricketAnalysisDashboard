import { React, useEffect, useState } from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
import { useParams } from 'react-router-dom';
import './TeamPage.scss';
// import { PieChart } from 'react-minimal-pie-chart';
import { PieChart } from '@mui/x-charts/PieChart';
// import CanvasJSReact from '@canvasjs/react-charts';

export const TeamPage = () => {
  const [team, setTeam] = useState({ latestMatches: [] });
  let { teamName } = useParams();

  useEffect(
    () => {
      const fetchMatches = async () => {

        //        fetch("http://localhost:8082/team/Chennai Super Kings")
        //        .then(response=>response.json())
        //        .then(data=>console.log(data));
        const response = await fetch(`http://localhost:8082/team/${teamName}`);
        const obj = await response.json();
        console.log(obj);
        setTeam(obj);
      };
      fetchMatches();

    }, [teamName]
  );
  if (!team || !team.latestMatches) {
    return <h1>Team Not Found</h1>;
  }
  console.log(teamName);

  return (
    <div className="TeamPage">
      <div className="Team-name-section">
        <h1 className="Team-name-heading">{team.teamName}</h1></div>
      <div className="win-loss-section">
        Wins / Losses
        <PieChart
          series={[
            {
              data: [
                { title: 'Losses', value: team.totalMatches - team.totalWins, label: 'Losses', color: '#a34d5d' },
                { title: 'Wins', value: team.totalWins, label: 'Wins', color: '#4da375' },
              ]
            }
          ]}
          width={400}
  height={200}
        />

      </div>
      <div className="Match-Detail-Component-section">
        <h3>Latest Matches</h3>
        <MatchDetailComponent teamName={teamName} match={team.latestMatches[0]} /></div>
      {team.latestMatches.slice(1).map((match) => <MatchSmallComponent teamName={teamName} match={match} />)}
      <h4>Total Matches: {team.totalMatches}</h4>
      <h4>Total Wins: {team.totalWins}</h4>

      <div className='more-link-section'>
        <a href="#">More</a>

        </div>


    </div>
  );
}
export default TeamPage;
