/* eslint-disable react/prop-types */
export default function Result(props) {
    
    return( 
        <div className="min-h-[90.8vh] flex flex-col justify-center items-center">
            <h2 className="text-3xl">Eres</h2>
            <h1 className="text-9xl mb-32 ml-3">{props.letters}</h1>
        </div>
    )
}
