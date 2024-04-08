import {React, useEffect,useState} from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
import { useParams } from 'react-router-dom';
import './MatchPage.scss' ;
import { YearSelector } from '../components/YearSelector';

export const MatchPage=()=>{

    const[matches,setMatches]=useState([]);
    const {teamName,year}=useParams();

    useEffect(
        ()=>{
          const fetchMatches=async()=>{

    //        fetch("http://localhost:8082/team/Chennai Super Kings")
    //        .then(response=>response.json())
    //        .then(data=>console.log(data));
            const response= await fetch(`http://localhost:8082/${teamName}/matches?year=${year}`);
                    const obj= await response.json();
                    console.log(obj);
                    setMatches(obj);
          };
          fetchMatches();

        },[teamName,year]
      );

if(!matches){
return null;
}




return (
    <div className="MatchPage">
      <div className="year-selector">
        <h3>Select Year</h3>
        <YearSelector teamName={teamName}/>
      </div>
      
      <div className='match-details'>
      <h1>{teamName} matches in {year}</h1>

        {matches.map((match) => <MatchDetailComponent teamName={teamName} match={match}/>)}

      </div>
      
    </div>
  );
}
export default MatchPage