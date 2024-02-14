import React from "react";

import { useState } from "react";

import Header from "./Header.js";
import Content from "./Content.js";

function App() {
  
  const [currentPage, setCurrentPage] = useState('home');
  
  const handleNavClick = (page) => setCurrentPage(page);

  return (
    <div className="App">
      <Header handleNavClick={handleNavClick} currentPage={currentPage} />
      <Content currentPage={currentPage} />
    </div>
  );
}

export default App
