import Header from "./Header.jsx";

import { Routes, Route } from "react-router-dom";
import Index from "./pages/index/Index.jsx";
import Mbti from "./pages/mbti/Mbti.jsx";
import Quiz from "./pages/quiz/Quiz.jsx";
import Result from "./pages/quiz/Result.jsx";
import Admin from "./pages/mvc/Admin.jsx";
import Login from "./pages/login/Login.jsx";
import Register from "./pages/login/Register.jsx";
import NotFound from "./pages/notfound/NotFound.jsx";

import { AuthProvider } from "./components/auth/AuthContext.jsx";

function App() {
  return (
    <AuthProvider>
      <Header />
      <Routes>
        <Route path="/" element={<Index />} />
        <Route path="/quiz" element={<Quiz />} />
        <Route path="/mbti" element={<Mbti />} />
        <Route path="/result/:mbti" element={<Result />} />
        <Route path="/admin" element={<Admin />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </AuthProvider>
  );
}

export default App;
