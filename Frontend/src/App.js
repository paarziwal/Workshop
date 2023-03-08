import React from 'react';
// import axios from 'axios';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Form from './components/form';
import Table from './components/Table';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Form />} />
        <Route exact path="/table" element={<Table />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App;