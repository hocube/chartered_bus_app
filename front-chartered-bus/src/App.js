import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';

function App() {
  
  const [message, setMessage] = useState('');

  useEffect(() => {        
    fetch('/hello4')            
    .then((response) => {
      return response.json();
    })                     
    .then(data => {
      setMessage(data.message);
  });     
  },[])

  return (
  <div className="App">
    <header className="App-header">
      <img src={logo} className="App-logo" alt="logo"/>
      <h1 className="App-title">{message}</h1>
    </header>
    <p className="App-intro">
      To get started, edit <code>src/App.js</code> and save to reload.
    </p>        
  </div>    
  )
}

export default App;
