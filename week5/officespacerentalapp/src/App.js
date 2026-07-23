import React from 'react';
import './App.css';

function App() {
  const element = "Office Space , at Affordable Range";
  const imageSrc = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=500&q=80";
  const jsxatt = <img src={imageSrc} width="25%" height="25%" alt="Office Space" />;

  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Regus", Rent: 75000, Address: "Bangalore" },
    { Name: "WeWork", Rent: 45000, Address: "Mumbai" }
  ];

  return (
    <div style={{ textAlign: 'center', padding: '20px' }}>
      <h1>{element}</h1>
      <div>{jsxatt}</div>

      {officeList.map((ItemName, index) => {
        const rentColor = ItemName.Rent <= 60000 ? 'red' : 'green';
        return (
          <div key={index} style={{ marginTop: '20px' }}>
            <h1>Name: {ItemName.Name}</h1>
            <h3 style={{ color: rentColor }}>Rent: Rs. {ItemName.Rent}</h3>
            <h3>Address: {ItemName.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
