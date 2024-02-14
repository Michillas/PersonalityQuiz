import HomePage from './pages/home/HomePage.js'
import QuizPage from './pages/quiz/QuizPage.js'
import MbtiPage from './pages/mbti/MbtiPage.js'
import CharactersPage from './pages/characters/CharactersPage.js'

function Content(currentPage) {
    switch (currentPage) {
      case 'home':
        return <HomePage />;
      case 'quiz':
        return <QuizPage />;
      case 'mbti':
        return <MbtiPage />;
      case 'characters':
        return <CharactersPage />;
      default:
        return null;
    }
}

export default Content