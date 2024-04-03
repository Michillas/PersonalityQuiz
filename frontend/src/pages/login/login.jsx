/* eslint-disable no-undef */
import React from "react";
import {Input, Button} from "@nextui-org/react";
import {EyeFilledIcon} from "./icons/EyeFilledIcon";
import {EyeSlashFilledIcon} from "./icons/EyeSlashFilledIcon";

import { useAuth } from "../../components/auth/AuthContext";

export default function Login() {
    const [isVisible, setIsVisible] = React.useState(false);
    const [username, setUsername] = React.useState("");
    const [password, setPassword] = React.useState("");
    const [error, setError] = React.useState("");

    const { login } = useAuth();

    const toggleVisibility = () => setIsVisible(!isVisible);

    const serverIP = process.env.REACT_APP_SERVERIP;

    const handleLogin = async () => {
        try {
            const usuarioData = {
                name: username,
                password: password,
            };

            const response = await fetch(`${serverIP}/admins/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(usuarioData)
            });

            if (response.ok) {
                console.log('User authenticated successfully');
                login();
            } else {
                const data = await response.json();
                setError(data.message || 'Failed to authenticate user');
            }
        } catch (error) {
            console.error('Error:', error);
            setError('An error occurred. Please try again.');
        }
    };

    return (
        <div className="h-[87.4vh] flex flex-col items-center justify-center mt-6 pb-56">
            <div className="m-6 text-3xl font-semibold">Iniciar Sesión</div>
            <Input 
                id="nombre" 
                type="text" 
                variant="bordered" 
                label="Nombre" 
                placeholder="Escribe tu nombre" 
                className="max-w-xs"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />
            <Input
                label="Contraseña"
                variant="bordered"
                placeholder="Escribe tu contraseña"
                endContent={
                    <button className="focus:outline-none" type="button" onClick={toggleVisibility}>
                        {isVisible ? (
                            <EyeSlashFilledIcon className="text-2xl text-default-400 pointer-events-none" />
                        ) : (
                            <EyeFilledIcon className="text-2xl text-default-400 pointer-events-none" />
                        )}
                    </button>
                }
                type={isVisible ? "text" : "password"}
                className="max-w-xs mt-6"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            {error && <div className="text-red-600 mt-2 mb-[-2vh]">{error}</div>}
            <Button color="primary" variant="shadow" className="mt-6 w-64" onClick={handleLogin}>
                Acceder
            </Button>

            <a className="mt-4 underline text-sky-600" href="/register">No tengo una cuenta</a>
        </div>
    );
}