import React from 'react';

export const ListofPlayers = ({ players }) => {
  return (
    <ul>
      {players.map((item, index) => (
        <li key={index}>
          Mr. {item.name} <span>{item.score}</span>
        </li>
      ))}
    </ul>
  );
};

export const Scorebelow70 = ({ players }) => {
  const players70 = players.filter((item) => item.score <= 70);
  return (
    <ul>
      {players70.map((item, index) => (
        <li key={index}>
          Mr. {item.name} <span>{item.score}</span>
        </li>
      ))}
    </ul>
  );
};
