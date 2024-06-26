/* eslint-disable react/prop-types */
import { useState, useEffect } from 'react';
import { RadioGroup, Radio, Divider } from "@nextui-org/react";

export default function Question(props) {
    const [selectedValue, setSelectedValue] = useState(0);
    const [initialValue, setInitialValue] = useState(0);

    useEffect(() => {
        setInitialValue(props.initialValue);
    }, [props.initialValue]);

    const handleValueChange = (value) => {
        setSelectedValue(value);
        switch (props.type) {
            case "attitude":
                props.changeValue(props.setAttitude, initialValue, value);
                break;
            case "perception":
                props.changeValue(props.setPerception, initialValue, value);
                break;
            case "orientation":
                props.changeValue(props.setOrientation, initialValue, value);
                break;
            case "behavior":
                props.changeValue(props.setBehavior, initialValue, value);
                break;
            default:
                break;
        }
    };

    return (
        <div className="flex flex-col items-center justify-center p-6">
            <div className="text-center text-3xl font-semibold mt-2">{props.title}</div>
            <div className="flex flex-row items-center justify-center gap-6 mt-6">
                <div className="w-40 text-center">Estoy de acuerdo</div>
                <RadioGroup
                    color="secondary"
                    orientation="horizontal"
                    onValueChange={handleValueChange}
                    value={selectedValue}
                >
                    <Radio color="success" classNames={{ wrapper: ['lg:h-20 lg:w-20 sm:h-10 sm:w-10'], control: ['lg:h-20 lg:w-20 sm:h-10 sm:w-10'] }} value="3" />
                    <Radio color="success" classNames={{ wrapper: ['lg:h-16 lg:w-16 sm:h-8 sm:w-8'], control: ['lg:h-16 lg:w-16 sm:h-8 sm:w-8'] }} value="2" />
                    <Radio color="success" classNames={{ wrapper: ['lg:h-12 lg:w-12 sm:h-6 sm:w-6'], control: ['lg:h-12 lg:w-12 sm:h-6 sm:w-6'] }} value="1" />
                    <Radio color="default" classNames={{ wrapper: ['lg:h-12 lg:w-12 sm:h-6 sm:w-6'], control: ['lg:h-12 lg:w-12 sm:h-6 sm:w-6'] }} value="0" />
                    <Radio color="secondary" classNames={{ wrapper: ['lg:h-12 lg:w-12 sm:h-6 sm:w-6'], control: ['lg:h-12 lg:w-12 sm:h-6 sm:w-6'] }} value="-1" />
                    <Radio color="secondary" classNames={{ wrapper: ['lg:h-16 lg:w-16 sm:h-8 sm:w-8'], control: ['lg:h-16 lg:w-16 sm:h-8 sm:w-8'] }} value="-2" />
                    <Radio color="secondary" classNames={{ wrapper: ['lg:h-20 lg:w-20 sm:h-10 sm:w-10'], control: ['lg:h-20 lg:w-20 sm:h-10 sm:w-10'] }} value="-3" />
                </RadioGroup>
                <div className="w-40 text-center">No estoy de acuerdo</div>
            </div>
            <Divider className="mt-12" />
        </div>
    )
}
