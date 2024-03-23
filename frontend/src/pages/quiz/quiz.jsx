import { useEffect, useState } from 'react';
import { Input, Button } from "@nextui-org/react";
import Question from "./question";

export default function Quiz() {
    const [questions, setQuestions] = useState([]);
    const [name, setName] = useState('');

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

    const [focus, setFocus] = useState(0);
    const [information, setInformation] = useState(1);
    const [decisions, setDecisions] = useState(1);
    const [outerlife, setOuterlife] = useState(0);

    const handleSendQuiz = async () => {
        try {
            const usuarioData = {
                username: name,
                focus: focus,
                information: information,
                decisions: decisions,
                outerlife: outerlife
            };

            const response = await fetch('http://localhost:8080/usuarios/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(usuarioData)
            });

            if (response.ok) {
                // Handle success (optional)
                console.log('Usuario created successfully');
            } else {
                // Handle error
                console.error('Failed to create Usuario');
            }
        } catch (error) {
            console.error('Error sending quiz:', error);
        }
    };

    return (
        <div className='min-h-[87.4vh]'>
            {questions.map((pregunta, index) => (
                <Question key={index} title={pregunta.question} type={pregunta.type} setFocus={setFocus} setInformation={setInformation} setDecisions={setDecisions} setOuterlife={setOuterlife} />
            ))}
            <div className="flex flex-col items-center mt-6 pb-12">
                <Input id="nombre" type="text" variant="flat" label="Nombre" placeholder="Escribe tu nombre" className="max-w-64" value={name} onChange={(e) => setName(e.target.value)} />
                <Button onClick={handleSendQuiz} color="primary" variant="shadow" className="mt-6 w-64">
                    Enviar
                </Button>
            </div>
        </div>
    );
}
