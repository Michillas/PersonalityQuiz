/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable no-undef */
/* eslint-disable react/prop-types */
import { Card, CardBody, Divider } from '@nextui-org/react';
import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';

import Characters from "../mbti/characters";

export default function Result() {

    const serverIP = process.env.REACT_APP_SERVERIP;

    const { mbti } = useParams();

    const [mbtiType, setMbtiType] = useState({ letters: '', name: '', description: '' });
    
    useEffect(() => {
        fetchMbti();
    }, []);

    const fetchMbti = async () => {
        try {
            const response = await fetch(`http://${serverIP}/mbtis/` + mbti);
            const data = await response.json();
            setMbtiType(data);
        } catch (error) {
            console.error('Error fetching mbtis:', error);
        }
    };
    
    return( 
        <div className="min-h-[90.8vh] flex flex-col justify-center items-center">
            <div className='flex flex-col justify-center items-center mt-40'>
                <h2 className="text-3xl">Eres</h2>
                <h1 className="text-9xl mb-8 ml-3">{mbti}</h1>
                <Divider />
            </div>
            <Card className='mt-8'>
                <CardBody className='max-w-[100vh] flex flex-col'>
                    <div className='text-2xl'>- {mbtiType.name}</div>
                    <Divider className='my-2'/>
                    <p>{mbtiType.description}</p>
                </CardBody>
            </Card>

            <div className='my-8 text-4xl font-bold text-center'>Personajes famosos</div>
            <Characters mbtiType={mbti} />

            <div className='mt-16 mb-4 text-slate-600'>© 2024 Michillas</div>
        </div>
    )
}
