import { React, useEffect, useState } from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
import { useParams } from 'react-router-dom';
import './TeamPage.scss';
import { Link } from 'react-router-dom';
// import { PieChart } from 'react-minimal-pie-chart';
import { PieChart } from '@mui/x-charts/PieChart';
import { createTheme, ThemeProvider } from '@mui/material/styles';
// import CanvasJSReact from '@canvasjs/react-charts';

// Define your custom theme
const theme = createTheme({
  components: {
    MuiLegend: {
      styleOverrides: {
        root: {
          color: '#ffffff', // Set legend text color to white
        },
      },
    },
  },
});

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
                { title: 'Losses', value: team.totalMatches - team.totalWins, label: 'Losses', color: '#3f37c9' },
                { title: 'Wins', value: team.totalWins, label: 'Wins', color: '#4895ef' },
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


      <div className="more-link-section">
        <Link to={`/team/${teamName}/year/${process.env.REACT_APP_DATA_END_YEAR}`}>More-{'>'}</Link>
      </div>
    </div>

  );
}
export default TeamPage;
