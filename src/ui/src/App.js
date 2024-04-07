// import logo from './logo.svg';
import './App.scss';
import {TeamPage} from './pages/TeamPage.js';
import {MatchPage} from './pages/MatchPage.js';
import {BrowserRouter, Route,Routes} from 'react-router-dom';

function App() {
  return (
    <div className="App">

      <BrowserRouter>

      <Routes>
        <Route path='/team/:teamName/year/:year' element={<MatchPage />} ></Route>

        <Route path='/team/:teamName' element={<TeamPage />} >
        </Route>

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
