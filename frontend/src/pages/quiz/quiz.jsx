/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable no-undef */
/* eslint-disable react/prop-types */
import { useEffect, useState } from 'react';

import { useNavigate } from 'react-router-dom';

import { Input, Button, Divider } from "@nextui-org/react";
import Question from "./question";

export default function Quiz() {

    const serverIP = process.env.REACT_APP_SERVERIP;

    const [questions, setQuestions] = useState([]);
    const [name, setName] = useState('');

    const navigate = useNavigate();
    
    useEffect(() => {
        fetchQuestions();
    }, []);

    const fetchQuestions = async () => {
        try {
            const response = await fetch(`${serverIP}/preguntas/list`);
            const data = await response.json();
            setQuestions(data);
        } catch (error) {
            console.error('Error fetching questions:', error);
        }
    };

    const [focus, setFocus] = useState(0);
    const [information, setInformation] = useState(0);
    const [decisions, setDecisions] = useState(0);
    const [outerlife, setOuterlife] = useState(0);

    const changeValue = (setState, value) => {
        setState(prevState => {
            // Parse prevState as a number to ensure correct arithmetic operation
            const parsedPrevState = parseInt(prevState, 10);
            // Parse value as a number to ensure correct arithmetic operation
            const parsedValue = parseInt(value, 10);
            // Perform arithmetic operation and return the new state
            return parsedPrevState + parsedValue;
        });
    };

    const calculateMbti = () => {
        
        const focusSum = focus;
        const informationSum = information;
        const decisionsSum = decisions;
        const outerlifeSum = outerlife;
    
        const mbtiType = [
            focusSum >= 0 ? 'E' : 'I',
            informationSum >= 0 ? 'N' : 'S',
            decisionsSum >= 0 ? 'T' : 'F',
            outerlifeSum >= 0 ? 'P' : 'J'
        ].join('');
        
        console.log(mbtiType)
        return mbtiType;
    }

    const handleSendQuiz = async () => {

        const mbtiType = calculateMbti();

        try {
            const usuarioData = {
                username: name,
                mbti: mbtiType,
                focus: focus,
                information: information,
                decisions: decisions,
                outerlife: outerlife
            };

            const response = await fetch(`${serverIP}/usuarios/create`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(usuarioData)
            });

            if (response.ok) {
                console.log('MBTI saved');
            } else {
                console.error('Failed to save MBTI');
            }
        } catch (error) {
            console.error('Error sending quiz:', error);
        }

        navigate('/result/' + mbtiType);

        window.scrollTo(0, 0);
        
    };

    return (
        <div className='min-h-[87.4vh]'>
            <div className="flex flex-col items-center mt-6">
                <div className="text-5xl font-bold m-6 mb-4 text-center">Quiz de personalidades MBTI</div>
                <div className="text-slate-400">¿Quieres saber tu tipo de personalidad?</div>
                <Divider className='w-[100vh] mt-6'/>
            </div>

            {questions.map((pregunta, index) => (
                <Question key={index} title={pregunta.question} type={pregunta.type} changeValue={changeValue} setFocus={setFocus} setInformation={setInformation} setDecisions={setDecisions} setOuterlife={setOuterlife} />
            ))}
            <div className="flex flex-col items-center mt-6 pb-4">
                <Input id="nombre" type="text" variant="flat" label="Nombre" placeholder="Escribe tu nombre" className="max-w-64" value={name} onChange={(e) => setName(e.target.value)} />
                <Button onClick={handleSendQuiz} color="primary" variant="shadow" className="mt-6 w-64">
                    Enviar
                </Button>
                <div className='mt-16 mb-4 text-slate-600'>© 2024 Michillas</div>
            </div>
        </div>
    );
}
