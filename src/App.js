import React from "react";
import {Navbar, NavbarBrand, NavbarMenuToggle, NavbarMenu, NavbarMenuItem, NavbarContent, NavbarItem, Link, Button} from "@nextui-org/react";

import logo from './logo.svg';
import HomePage from './pages/home/HomePage.js'
import QuizPage from './pages/quiz/QuizPage.js'
import MbtiPage from './pages/mbti/MbtiPage.js'
import CharactersPage from './pages/characters/CharactersPage.js'

function App() {
  const [currentPage, setCurrentPage] = React.useState('home');
  
  const handleNavClick = (page) => {
    console.log("page: " + page)
    setCurrentPage(page);
  };

  const [isMenuOpen, setIsMenuOpen] = React.useState(false);

  const menuItems = [
    "Test",
    "Personality Types",
    "MBTI Characters",
  ];

  return (
    <div className="App">
      <Navbar
        isBordered
        isMenuOpen={isMenuOpen}
        onMenuOpenChange={setIsMenuOpen}
      >
        <NavbarContent className="sm:hidden" justify="start">
          <NavbarMenuToggle aria-label={isMenuOpen ? "Close menu" : "Open menu"} />
        </NavbarContent>
  
        <NavbarContent className="sm:hidden pr-3" justify="center">
          <NavbarBrand>
            <p className="font-bold text-inherit">PersonalityQuiz</p>
          </NavbarBrand>
        </NavbarContent>
  
        <NavbarContent className="hidden sm:flex gap-4" justify="center">
          <NavbarBrand>
            <p className="font-bold text-inherit">PersonalityQuiz</p>
          </NavbarBrand>
          <NavbarItem onClick={() => handleNavClick('home')} isActive={currentPage === 'home'}>
            <Link color={currentPage === 'home' ? "" : "foreground"} href="home">
                Home
            </Link>
          </NavbarItem>
          <NavbarItem onClick={() => handleNavClick('quiz')} isActive={currentPage === 'quiz'}>
            <Link color={currentPage === 'quiz' ? "" : "foreground"}  href="quiz">
                Test
            </Link>
          </NavbarItem>
          <NavbarItem onClick={() => handleNavClick('mbti')} isActive={currentPage === 'mbti'}>
            <Link color={currentPage === 'mbti' ? "" : "foreground"} href="mbti">
                Personality Types
            </Link>
          </NavbarItem>
          <NavbarItem onClick={() => handleNavClick('characters')} isActive={currentPage === 'characters'}>
            <Link color={currentPage === 'characters' ? "" : "foreground"}  href="characters">
                MBTI Characters
            </Link>
          </NavbarItem>
        </NavbarContent>
  
        <NavbarContent justify="end">
          <NavbarItem className="hidden lg:flex">
            <Link href="#">Login</Link>
          </NavbarItem>
          <NavbarItem>
            <Button as={Link} color="warning" href="#" variant="flat">
              Sign Up
            </Button>
          </NavbarItem>
        </NavbarContent>
  
        <NavbarMenu>
          {menuItems.map((item, index) => (
            <NavbarMenuItem key={`${item}-${index}`}>
              <Link
                className="w-full"
                color={
                  index === 2 ? "warning" : index === menuItems.length - 1 ? "danger" : "foreground"
                }
                href="#"
                size="lg"
              >
                {item}
              </Link>
            </NavbarMenuItem>
          ))}
        </NavbarMenu>
      </Navbar>
      {currentPage === 'home' && <HomePage />}
      {currentPage === 'quiz' && <QuizPage />}
      {currentPage === 'mbti' && <MbtiPage />}
      {currentPage === 'characters' && <CharactersPage />}
    </div>
  );
}

export default App;
