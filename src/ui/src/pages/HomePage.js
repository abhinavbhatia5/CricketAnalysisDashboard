import { React, useEffect, useState } from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
import { useParams } from 'react-router-dom';
import './HomePage.scss';
import { Link } from 'react-router-dom';
// import { PieChart } from 'react-minimal-pie-chart';
import { PieChart } from '@mui/x-charts/PieChart';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { TeamTile } from '../components/TeamTile';
// import CanvasJSReact from '@canvasjs/react-charts';

export const HomePage = () => {
  const [teams, setTeams] = useState([]);
//   let { teamName } = useParams();

  useEffect(
    () => {
      const fetchAllTeams = async () => {

        //        fetch("http://localhost:8082/team/Chennai Super Kings")
        //        .then(response=>response.json())
        //        .then(data=>console.log(data));
        const response = await fetch(`http://localhost:8082/team`);
        const obj = await response.json();
        console.log(obj);
        setTeams(obj);
      };
      fetchAllTeams();

    }, []
  );

  return (
    <div className="HomePage">
      <div className="Header-section">
        <h1 className="App-name">Cricket Analysis Dashboard</h1>
        </div>
      <div className='team-grid'>
      { teams.map(team => <TeamTile key={team.id} teamName={team} />)}
      </div>
    </div>

  );
}
export default HomePage;
