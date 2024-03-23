import { useEffect, useState } from 'react';
import { Input, Button } from "@nextui-org/react";
import Question from "./question";

export default function Quiz() {
    const [questions, setQuestions] = useState([]);

    useEffect(() => {
        fetchQuestions();
    }, []);

    const fetchQuestions = async () => {
        try {
            const response = await fetch('http://localhost:8080/preguntas/list');
            const data = await response.json();
            setQuestions(data);
        } catch (error) {
            console.error('Error fetching questions:', error);
        }
    };

    return (
        <div className='min-h-[87.4vh]'>
            {questions.map((pregunta, index) => (
                <Question key={index} title={pregunta.question} />
            ))}
            <div className="flex flex-col items-center mt-6 pb-12">
                <Input id="nombre" type="text" variant="flat" label="Nombre" placeholder="Escribe tu nombre" className="max-w-64"/>
                <Button color="primary" variant="shadow" className="mt-6 w-64">
                    Enviar
                </Button>
            </div>
        </div>
    );
}
