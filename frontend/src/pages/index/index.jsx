import { Divider, Card, CardBody, Image } from '@nextui-org/react'

import Characters from "../mbti/characters";

export default function Index() {
    return ( 
        <div className='min-h-[90.8vh] flex flex-col items-center pb-4'>
            <div className="text-5xl font-bold m-6 mb-4 text-center">Test de personalidad</div>
            <div className="text-slate-400">Made with ❤️ by <a href="https://github.com/Michillas" className="underline">Michillas</a></div>
            <Divider className='w-[100vh] mt-6 mb-6'/>
            <Card>
                <CardBody className='max-w-[100vh]'>
                    <div className="text-3xl font-bold">MBTI - Indicador Myers-Briggs</div>
                    <Divider className='my-2' />
                    <p>El MBTI (Indicador Myers-Briggs) es un test de personalidad creado por Katharine Cook Briggs e Isabel Briggs Myers, basado en las teorías de Carl Jung. Con más de 90 años de desarrollo y avalado por expertos en psicología, el MBTI te ayuda a comprender cómo percibes el mundo y tomas decisiones, revelando tu tipo de personalidad entre 16 posibilidades.</p>
                </CardBody>
            </Card>
            <div className='mt-14 mb-2 text-4xl font-bold text-center'>¡Encuentra figuras famosas con tu mismo MBTI!</div>
            <p className='mb-6 text-1xl text-slate-300 text-center'>¿Eres un INTP como Albert Einstein o un ESFJ como Bob Esponja?</p>
            <Characters mbtiType="ESFP" />
            <div className='mt-12 mb-6 text-4xl font-bold'>Memes</div>
            <div className='flex flex-wrap gap-6'>
                <Image
                    width={325}
                    alt="Meme MBTI"
                    src="https://i.pinimg.com/564x/69/0e/35/690e350a98cd31975686d3fde08d4490.jpg"
                />
                <Image
                    width={400}
                    alt="Meme MBTI"
                    src="https://i.pinimg.com/564x/cb/54/62/cb54625d35b9297717615a3b1207cb5d.jpg"
                />
            </div>
            <div className='mt-12 mb-6 text-4xl font-bold'>Tipos</div>
            <Image
                width={600}
                alt="Meme MBTI"
                src="https://guillemrecolons.com/wp-content/uploads/2020/03/las-16-personalidades.jpg"
            />
            <div className='mt-16 mb-4 text-slate-600'>© 2024 Michillas</div>
        </div>
    )
}