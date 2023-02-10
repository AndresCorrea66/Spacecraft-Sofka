import React, { useState, useEffect } from "react";

const App = () => {
  const [spacecrafts, setSpacecrafts] = useState([]);
  const [searchResults, setSearchResults] = useState([]);

  useEffect(() => {
    getSpacecrafts();
  }, []);

  const getSpacecrafts = async () => {
    const response = await fetch("http://localhost:8080/spacecrafts");
    const data = await response.json();
    setSpacecrafts(data);
  };

  const searchSpacecrafts = async keywords => {
    const response = await fetch("http://localhost:8080/spacecrafts/search?keywords=${keywords}");
    const data = await response.json();
    setSearchResults(data);
  };

  const searchBySpeed = async (minSpeed, maxSpeed) => {
    const response = await fetch(
      "http://localhost:8080/spacecrafts/search-by-speed?minSpeed=${minSpeed}&maxSpeed=${maxSpeed}"
    );
    const data = await response.json();
    setSearchResults(data);
  };

  const addSpacecraft = async spacecraftType => {
    const response = await fetch("http://localhost:8080/spacecrafts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ "spacecraftType": spacecraftType })
    });
    const data = await response.json();
    setSpacecrafts([...spacecrafts, data]);
  };

  return (
    <div>
      <h1>Spacecrafts</h1>
      <ul>
        {spacecrafts.map(spacecraft => (
          <li key={spacecraft.id}>{spacecraft.name}</li>
        ))}
      </ul>
      <form>
        <input type="text" placeholder="Search by keywords" />
        <button type="submit">Search</button>
      </form>
      <form>
        <input type="text" placeholder="Min speed" />
        <input type="text" placeholder="Max speed" />
        <button type="submit">Search by speed</button>
      </form>
      <form>
        <input type="text" placeholder="Add spacecraft type" />
        <button type="submit">Add spacecraft</button>
      </form>
    </div>
  );
};

export default App;
