// import logo from './logo.svg';
import './App.css';
import {TeamPage} from './pages/TeamPage.js';
import { TestHook } from './pages/TestHook.js';

function App() {
  return (
    <div className="App">
      <h1>IPL Dashboard</h1>
      <TeamPage/>
      <TestHook/>
    </div>
  );
}

export default App;
