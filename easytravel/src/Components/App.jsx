import React from 'react';
import './style.css';

let price;


const App = () => {
  return (
    <div className="Activity-container">
      <header className="Activity-content">
        <div className="activity">
          <src={require('../path-name')} alt= "" />
        </div>
        <div className="desc">
          <h2>Title of the Activity</h2>
          <p>A description of the activity will go here.</p>
          <h3>Price: </h3>
        </div>
      </header>
    </div>
  );
};

export default App;