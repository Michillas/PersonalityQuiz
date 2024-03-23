import {Navbar, NavbarBrand, NavbarContent, NavbarItem, Link as NextLink, Button} from "@nextui-org/react";
import { Link } from 'react-router-dom';
import { MichillasLogo } from "./assets/MichillasLogo";

import { useLocation } from 'react-router-dom';

export default function Header() {
  const location = useLocation();
  
  return (
    <Navbar isBordered>
      <NavbarBrand>
        <MichillasLogo />
        <p className="font-bold text-inherit ml-2">PersonalityQuiz</p>
      </NavbarBrand>
      <NavbarContent className="hidden sm:flex gap-4" justify="center">
        <NavbarItem isActive={location.pathname === "/"}>
          <NextLink color={location.pathname === "/" ? "#" : "foreground"} href="/">
            Inicio
          </NextLink>
        </NavbarItem>
        <NavbarItem isActive={location.pathname === "/quiz"}>
          <NextLink color={location.pathname === "/quiz" ? "#" : "foreground"} href="quiz">
            Quiz
          </NextLink>
        </NavbarItem>
        <NavbarItem isActive={location.pathname === "/mbti"}>
          <NextLink color={location.pathname === "/mbti" ? "#" : "foreground"} href="mbti">
            Mbtis
          </NextLink>
        </NavbarItem>
        <NavbarItem isActive={location.pathname === "/admin"}>
          <NextLink color={location.pathname === "/admin" ? "#" : "foreground"} href="admin">
            Admin
          </NextLink>
        </NavbarItem>
      </NavbarContent>
      <NavbarContent justify="end">
        <NavbarItem className="hidden lg:flex">
          <NextLink href="login">Login</NextLink>
        </NavbarItem>
        <NavbarItem>
          <Button as={Link} color="primary" href="register" variant="flat">
            Sign Up
          </Button>
        </NavbarItem>
      </NavbarContent>
    </Navbar>
  );
}
