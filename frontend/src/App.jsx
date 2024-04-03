import Header from "./Header.jsx";

import { Routes, Route } from "react-router-dom";
import Index from "./pages/index/index.jsx";
import Mbti from "./pages/mbti/mbti.jsx";
import Quiz from "./pages/quiz/quiz.jsx";
import Result from "./pages/quiz/result.jsx";
import Admin from "./pages/mvc/admin.jsx";
import Login from "./pages/login/login.jsx";
import Register from "./pages/login/register.jsx";
import NotFound from "./pages/notfound/notfound.jsx";

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
