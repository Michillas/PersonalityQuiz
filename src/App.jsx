import Header from './Header.jsx'

import { Routes, Route} from "react-router-dom";
import Index from './pages/index/index.jsx';
import Mbti from './pages/mbti/mbti.jsx';
import Quiz from './pages/quiz/quiz.jsx';

function App() {

  return (
    <>
      <Header />
      <Routes>
        <Route path="/">
          <Route index element={<Index />} />
          <Route path="quiz" element={<Quiz />} />
          <Route path="mbti" element={<Mbti />} />
        </Route>
      </Routes>
    </>
  )
}

export default App