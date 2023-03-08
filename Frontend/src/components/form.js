import React, { useState } from 'react';
import axios from 'axios';
import './form.css';
import { useNavigate } from 'react-router-dom';

function Form() {
  const nav = useNavigate();
  const [name, setName] = useState('');
  const [departure, setDeparture] = useState('');
  const [arrival, setArrival] = useState('');
  const [date, setDate] = useState('');

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleDepartureChange = (e) => {
    setDeparture(e.target.value);
  };

  const handleArrivalChange = (e) => {
    setArrival(e.target.value);
  };

  const handleDateChange = (e) => {
    setDate(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const chuma = { "name" : name , "start" : departure , "destination" : arrival , "date" : date };
    axios.post("http://localhost:8080/savedata",chuma);

    console.log('Form submitted');
    nav("/table");
  };

  return (
    <div className="container">
      <form className="booking-form" onSubmit={handleSubmit}>
        <h2>Book Your Train Tickets</h2>
        <div className="form-group">
          <label htmlFor="name">Full Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={name}
            onChange={handleNameChange}
          />
        </div><div className="form-group">
          <label htmlFor="departure">Departure:</label>
          <input
            type="text"
            id="departure"
            name="departure"
            value={departure}
            onChange={handleDepartureChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="arrival">Destination:</label>
          <input
            type="text"
            id="arrival"
            name="arrival"
            value={arrival}
            onChange={handleArrivalChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="date">Date:</label>
          <input
            type="date"
            id="date"
            name="date"
            value={date}
            onChange={handleDateChange}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Form;