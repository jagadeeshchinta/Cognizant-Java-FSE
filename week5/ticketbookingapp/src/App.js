import React, { useState } from 'react';

function UserGreeting() {
  return (
    <div>
      <h1>Welcome back</h1>
    </div>
  );
}

function GuestGreeting() {
  return (
    <div>
      <h1>Please sign up.</h1>
    </div>
  );
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div style={{ padding: '20px' }}>
      <Greeting isLoggedIn={isLoggedIn} />
      <div style={{ marginTop: '10px' }}>
        {button}
      </div>
    </div>
  );
}

export default App;
