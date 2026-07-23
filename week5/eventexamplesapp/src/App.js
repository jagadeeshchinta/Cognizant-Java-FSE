import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('80');
  const [currency, setCurrency] = useState('Euro');

  const handleSubmit = (e) => {
    e.preventDefault();
    const convertedAmount = parseFloat(amount || 0) * 80;
    alert(`Converting to Euro Amount is ${convertedAmount}`);
  };

  return (
    <div>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Amount: </label>
          <input
            type="text"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Currency: </label>
          <textarea
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
            rows={1}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

function App() {
  const [counter, setCounter] = useState(5);

  const sayHello = () => {
    alert('Hello! Member1');
  };

  const handleIncrement = () => {
    setCounter((prev) => prev + 1);
    sayHello();
  };

  const handleDecrement = () => {
    setCounter((prev) => prev - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleSyntheticClick = (e) => {
    alert('I was clicked');
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>{counter}</h2>
      <div style={{ marginBottom: '5px' }}>
        <button onClick={handleIncrement}>Increment</button>
      </div>
      <div style={{ marginBottom: '5px' }}>
        <button onClick={handleDecrement}>Decrement</button>
      </div>
      <div style={{ marginBottom: '5px' }}>
        <button onClick={() => sayWelcome('welcome')}>Say welcome</button>
      </div>
      <div style={{ marginBottom: '20px' }}>
        <button onClick={handleSyntheticClick}>Click on me</button>
      </div>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
