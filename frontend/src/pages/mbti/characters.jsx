/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable no-undef */
/* eslint-disable react/prop-types */
import { useEffect, useState } from 'react';

import {Card, CardBody, CardFooter, Image} from "@nextui-org/react";

export default function Characters(props) {

    const serverIP = process.env.REACT_APP_SERVERIP;

    const [characters, setCharacters] = useState([]);

    useEffect(() => {
        fetchCharacters();
    }, []);

    const fetchCharacters = async () => {
        try {
            const response = await fetch(`${serverIP}/characters/list`);
            const data = await response.json();
            setCharacters(data);
        } catch (error) {
            console.error('Error fetching characters:', error);
        }
    };

    return (
        <div className="gap-2 grid grid-cols-2 sm:grid-cols-3">
            {characters.map((item, index) => (
                item.mbti === props.mbtiType && (
                    <Card shadow="sm" key={index} isPressable onPress={() => console.log("item pressed")}>
                        <CardBody className="overflow-visible p-0">
                            <Image
                                shadow="sm"
                                radius="lg"
                                width="100%"
                                alt={item.name}
                                className="w-full object-cover h-[240px]"
                                src={item.img}
                            />
                        </CardBody>
                        <CardFooter className="text-small justify-between">
                            <b>{item.name}</b>
                            <p className="text-default-500">{item.mbti}</p>
                        </CardFooter>
                    </Card>
                )
            ))}
        </div>
    );
}
