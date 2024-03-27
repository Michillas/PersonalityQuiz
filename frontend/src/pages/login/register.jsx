import React from "react";
import {Input, Button} from "@nextui-org/react";
import {EyeFilledIcon} from "./icons/EyeFilledIcon";
import {EyeSlashFilledIcon} from "./icons/EyeSlashFilledIcon";

export default function Register() {
    const [isVisible, setIsVisible] = React.useState(false);

    const toggleVisibility = () => setIsVisible(!isVisible);

    return (
        <div className="h-[87.4vh] flex flex-col items-center justify-center mt-6 pb-56">
            <div className="m-6 text-3xl font-semibold">Registrarse</div>
            <Input id="nombre" type="text" variant="bordered" label="Nombre" placeholder="Escribe tu nombre" className="max-w-xs"/>
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
            />
            <Button color="primary" variant="shadow" className="mt-6 w-64">
                Acceder
            </Button>

            <a className="mt-4 underline text-sky-600" href="/login">Ya tengo una cuenta</a>
        </div>
    );
}