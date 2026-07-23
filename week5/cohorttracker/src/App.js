import React from 'react';
import { CohortDetails } from './CohortDetails';

const cohorts = [
  {
    id: 1,
    name: 'INTADMFD10 -.NET FSD',
    startDate: '22-Feb-2022',
    status: 'Scheduled',
    coach: 'Aathma',
    trainer: 'Jojo Jose'
  },
  {
    id: 2,
    name: 'ADM21JF014 -Java FSD',
    startDate: '10-Sep-2021',
    status: 'Ongoing',
    coach: 'Apoorv',
    trainer: 'Elisa Smith'
  },
  {
    id: 3,
    name: 'CDBJF21025 -Java FSD',
    startDate: '24-Dec-2021',
    status: 'Ongoing',
    coach: 'Aathma',
    trainer: 'John Doe'
  }
];

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Cohorts Details</h1>
      {cohorts.map((cohort) => (
        <CohortDetails key={cohort.id} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
