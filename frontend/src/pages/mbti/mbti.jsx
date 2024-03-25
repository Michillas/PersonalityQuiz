import Characters from "./characters";

import { Divider } from "@nextui-org/react";

const mbtiTypes = ["INTJ", "ENTJ", "ISFJ", "ESFJ", "ESFP", "ISFP", "ESTP", "ISTP", "INFJ", "ENFJ", "INFP", "ENFP", "INTP", "ENTP", "ISTJ", "ESTJ"];

export default function Mbti() {
    return (
        <div className='min-h-[90.8vh] flex flex-col items-center pb-4'>
            <div className="text-5xl font-bold m-6">Personajes - MBTI</div>
            <div className="text-slate-400">Más personajes en:</div>
            <a className="mb-4 underline text-sky-400" href="https://www.personality-database.com/profile?pid=1&sort=top">https://www.personality-database.com/profile?pid=1&sort=top</a>
            {mbtiTypes.map((mbtiType) => (
                <div key={mbtiType} className="mb-10">
                    <Divider />
                    <div className="text-5xl font-semibold text-center m-6">{mbtiType}</div>
                    <Characters mbtiType={mbtiType} />
                </div>
            ))}
            <div className='mt-16 mb-4 text-slate-600'>© 2024 Michillas</div>
        </div>
    );
}