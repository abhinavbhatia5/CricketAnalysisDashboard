import { React, useEffect, useState } from 'react';
import { MatchDetailComponent } from '../components/MatchDetailComponent';
import { MatchSmallComponent } from '../components/MatchSmallComponent';
import { useParams, Link } from 'react-router-dom';
import './MatchPage.scss';
import { YearSelector } from '../components/YearSelector';

export const MatchPage = () => {
  const [matches, setMatches] = useState([]);
  const { teamName, year } = useParams();

  useEffect(() => {
    const fetchMatches = async () => {
      const response = await fetch(`http://localhost:8082/${teamName}/matches?year=${year}`);
      const obj = await response.json();
      console.log(obj);
      setMatches(obj);
      //        fetch("http://localhost:8082/team/Chennai Super Kings")
          //        .then(response=>response.json())
          //        .then(data=>console.log(data));
    };
    fetchMatches();
  }, [teamName, year]);

  if (!matches) {
    return null;
  }

  return (
    <div className="MatchPage">
      <div className="year-selector">
        <h3>Select Year</h3>
        <YearSelector teamName={teamName} />
        <div className="navigation-buttons">
          <Link to="/">
            <button>Home-></button>
          </Link>
          <Link to={`/team/${teamName}`}>
            <button>{'<- Team page'}</button>
          </Link>
        </div>
      </div>
      <div className="match-details">
        <h1>{teamName} matches in {year}</h1>

        {matches.length === 0 ? (
          <p>{`Team did not exist in ${year}`}</p>
        ) : (
          matches.map((match) => <MatchDetailComponent key={match.id} teamName={teamName} match={match} />)
        )}
      </div>
    </div>
  );
};

export default MatchPage;
