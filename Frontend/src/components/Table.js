import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import "./Table.css" ;

export default function Table1() {
    const [data, setData] = useState([]);
    const [id, setId] = useState('');
    const [name, setName] = useState('');
    const [departure, setDeparture] = useState('');
    const [arrival, setArrival] = useState('');
    const [date, setDate] = useState('');

    const handleIdChange = (e) => {
        setId(e.target.value);
      };
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

    function init() {
        axios.get('http://localhost:8080/findall')
            .then(response => {
                setData(response.data);
                console.log(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const chuma = { "id":id,"name" : name , "start" : departure , "destination" : arrival , "date" : date };
        axios.put("http://localhost:8080/update",chuma);
        window.location.reload();
        console.log('Form updated');
      };

    const handleDelete = async (Id) => {
      await axios.delete("http://localhost:8080/deleteById/" + Id);
      window.location.reload();
       console.log(123);
    };

    useEffect(() => { init() }, [])
    return (
        <div>
        <table border={1}>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Date</th>
                    
                </tr>
            </thead>
            <tbody>
                {data.map(user => (
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.name}</td>
                        <td>{user.start}</td>
                        <td>{user.destination}</td>
                        <td>{user.date}</td>
                        <td><button className="btn btn-danger" onClick={() => handleDelete(user.id)}>Delete</button></td>
                        
                     
                    </tr>

                ))}
            </tbody>
        </table>

<div className="container1">
<form className="booking-form" onSubmit={handleSubmit}>
  <h2>Update Your Train Tickets</h2>
  <div className="form-group">
    <label htmlFor="Id">Id</label>
    <input
      type="text"
      id="id"
      name="id"
      value={id}
      onChange={handleIdChange}
    />
  </div>
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
  <button type="submit">Update</button>
</form>
</div>
</div>
); }
