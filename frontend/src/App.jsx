import Header from "./Header";

import { Routes, Route } from "react-router-dom";
import Index from "./pages/index/Index";
import Mbti from "./pages/mbti/Mbti";
import Quiz from "./pages/quiz/Quiz";
import Result from "./pages/quiz/Result";
import Admin from "./pages/mvc/Admin";
import Login from "./pages/login/Login";
import Register from "./pages/login/Register";
import NotFound from "./pages/notfound/NotFound";

import { AuthProvider } from "./components/auth/AuthContext";

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
