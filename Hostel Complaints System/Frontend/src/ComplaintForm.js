// src/ComplaintForm.js
import React, { useState } from 'react';

const ComplaintForm = () => {
  const [complaint, setComplaint] = useState({
    firstName: '',
    lastName: '',
    email: '',
    roomNo: '',
    description: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setComplaint({
      ...complaint,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch('http://localhost:8080/api/complaints', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(complaint)
    })
      .then(response => response.json())
      .then(data => {
        console.log('Complaint created:', data);
        alert('Complaint created successfully!');
        // Reset the form
        setComplaint({
          firstName: '',
          lastName: '',
          email: '',
          roomNo: '',
          description: ''
        });
      })
      .catch(error => {
        console.error('Error creating complaint:', error);
        alert('There was an error creating the complaint.');
      });
  };

  return (
    <div>
      <h2>Submit a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstName">First Name</label>
          <input 
            type="text" 
            id="firstName" 
            name="firstName" 
            value={complaint.firstName} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label htmlFor="lastName">Last Name</label>
          <input 
            type="text" 
            id="lastName" 
            name="lastName" 
            value={complaint.lastName} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label htmlFor="email">Email</label>
          <input 
            type="email" 
            id="email" 
            name="email" 
            value={complaint.email} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label htmlFor="roomNo">Room Number</label>
          <input 
            type="text" 
            id="roomNo" 
            name="roomNo" 
            value={complaint.roomNo} 
            onChange={handleChange} 
            required 
          />
        </div>
        <div>
          <label htmlFor="description">Description</label>
          <textarea 
            id="description" 
            name="description" 
            value={complaint.description} 
            onChange={handleChange} 
            required 
          ></textarea>
        </div>
        <button type="submit">Create</button>
      </form>
    </div>
  );
};

export default ComplaintForm;
