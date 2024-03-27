/* eslint-disable react/prop-types */
import { useParams } from 'react-router-dom';

export default function Result() {

    const { mbti } = useParams();
    
    return( 
        <div className="min-h-[90.8vh] flex flex-col justify-center items-center">
            <h2 className="text-3xl">Eres</h2>
            <h1 className="text-9xl mb-32 ml-3">{mbti}</h1>
        </div>
    )
}
