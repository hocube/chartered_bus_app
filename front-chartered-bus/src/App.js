import React from 'react';
import './App.css';
import { Routes, Route } from 'react-router-dom';
import Main from './Main';
import PostForm from './PostForm';
import PostFormDTO from './PostFormDTO';

function App() {
  return (
      <Routes>
          <Route path='/main' element={<Main />} />
          <Route path='/post' element={<PostForm />} />
          <Route path='/postDTO' element={<PostFormDTO />} />
          <Route path='/' element={
            <div className='App'>
              <header className='App-header'>
                <h1 className='App-title'>Home Page</h1>
              </header>
              <p className='App-intro'>
                Welcome to the home page.
              </p>
            </div>
        } />
      </Routes>
  );
}
export default App;
