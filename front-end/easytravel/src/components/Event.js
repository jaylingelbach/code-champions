import React, { useState } from 'react';




const Event = () => {


  const [search, setSearch] = useState('');

  return (
    <div>
      <h2>Event Page</h2>
      <p>Welcome to easyTravel!</p>
      <form>
        <input id='search'
        name='search'
        type='text'  
        value={search}
        placeholder='Search'
        onChange={event => setSearch(event.target.value)}></input>
        <button>Search</button>

      </form>
    </div>
  );
};

export default Event;
