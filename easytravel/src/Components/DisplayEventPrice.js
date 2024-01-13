import React, { useState } from "react";
import "./style.css";
function App() {
  return (
    <div className="Activity-container">
      <header className="Activity-content">
        <div className="activity">
          <src={require("../path-name")} alt="" />
        </div>
        <div className="desc">
          <h2> </h2>
          <p>
            A description of the activity will go here.
          </p>
          <h3>Price: </h3>
        </div>
      </header>
    </div>
  );
}

export default App;