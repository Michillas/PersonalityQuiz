import { Divider, Input, Button } from "@nextui-org/react"
import Question from "./question"

export default function Quiz() {
    const questionTitles = ["No se que poner aqui", "hola1", "hola3", "hola4"];

    return (
        <>
            {questionTitles.map((title, index) => (
                <Question key={index} title={title} />
            ))}
            <div className="flex flex-col items-center mt-6 pb-12">
                <Input type="text" variant="flat" label="Nombre" placeholder="Escribe tu nombre" className="max-w-64"/>
                <Button color="primary" variant="shadow" className="mt-6 w-64">
                    Enviar
                </Button>
            </div>
        </>
    );
}