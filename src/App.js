import logo from './logo.svg';
import NavApp from './NavApp.js';

function App() {
  return (
    <div className="App">
      <Nav></Nav>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Test
        </p>
      </header>
    </div>
  );
}

export default App;