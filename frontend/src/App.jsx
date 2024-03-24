import { useState } from 'react';

import Header from './Header.jsx';

import { Routes, Route } from "react-router-dom";
import Index from './pages/index/index.jsx';
import Mbti from './pages/mbti/mbti.jsx';
import Quiz from './pages/quiz/quiz.jsx';
import Result from './pages/quiz/result.jsx';
import Admin from './pages/mvc/admin.jsx';
import Login from './pages/login/login.jsx';
import NotFound from './pages/notfound/notfound.jsx';

function App() {

  const [letters, setLetters] = useState('');

  return (
    <>
      <Header />
      <Routes>
        <Route path="/">
          <Route index element={<Index />} />
          <Route path="quiz" element={<Quiz setLetters={setLetters} />} />
          <Route path="mbti" element={<Mbti />} />
          <Route path="result" element={<Result letters={letters}/>} />
          <Route path="admin" element={<Admin />} />
          <Route path="login" element={<Login />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </>
  )
}

export default App