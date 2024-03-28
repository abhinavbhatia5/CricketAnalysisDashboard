import {React, useEffect} from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
export const TeamPage = () => {


  useEffect{
    ()=>{
      const fetchMatches=async()=>{
        
        const response=fetch("http://localhost:8080/team/Chennai Super Kings");
        const obj=(await response).json();
      }
    },[]
  }

  return (
    <div className="TeamPage">
      <h2>Team Name</h2>
      <MatchDetailComponent/>
      <MatchSmallComponent/>
      <MatchSmallComponent/>
      <MatchSmallComponent/>

    </div>
  );
}

//export default App;
