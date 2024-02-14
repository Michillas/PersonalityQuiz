import React, { useState, useEffect } from "react";

import Header from "./Header.js";
import Content from "./Content.js";

function App() {
  
  const [currentPage, setCurrentPage] = useState('home');

  return (
    <div className="App">
      <Header handleNavClick={setCurrentPage} currentPage={currentPage} />
      <Content currentPage={currentPage} />
    </div>
  );
}

export default App
