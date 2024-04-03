// import logo from './logo.svg';
import './App.css';
import {TeamPage} from './pages/TeamPage.js';
import {BrowserRouter, Route,Routes} from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <h1>IPL Dashboard</h1>

      <BrowserRouter>

      <Routes>

        <Route path='/team/:teamName' element={<TeamPage />} >
        </Route>

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
