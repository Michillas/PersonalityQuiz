import {Navbar, NavbarBrand, NavbarContent, NavbarItem, Link as NextLink, Button} from "@nextui-org/react";
import { Link } from 'react-router-dom';
import { AcmeLogo } from "./assets/AcmeLogo";

export default function Header() {
  return (
    <Navbar>
      <NavbarBrand>
        <AcmeLogo />
        <p className="font-bold text-inherit text-white">ACME</p>
      </NavbarBrand>
      <NavbarContent className="hidden sm:flex gap-4" justify="center">
        <NavbarItem isActive>
          <NextLink color="foreground" href="home">
            Inicio
          </NextLink>
        </NavbarItem>
        <NavbarItem>
          <NextLink color="foreground" href="quiz">
            Quiz
          </NextLink>
        </NavbarItem>
        <NavbarItem>
          <NextLink color="foreground" href="mbti">
            Mbtis
          </NextLink>
        </NavbarItem>
      </NavbarContent>
      <NavbarContent justify="end">
        <NavbarItem className="hidden lg:flex">
          <NextLink href="#">Login</NextLink>
        </NavbarItem>
        <NavbarItem>
          <Button as={Link} color="primary" href="#" variant="flat">
            Sign Up
          </Button>
        </NavbarItem>
      </NavbarContent>
    </Navbar>
  );
}
