/* eslint-disable react/prop-types */
import { useState } from 'react';
import { RadioGroup, Radio, Divider } from "@nextui-org/react";

export default function Question(props) {
    const [selectedValue, setSelectedValue] = useState(0);

    const handleValueChange = (value) => {
        setSelectedValue(value);
        switch (props.type) {
            case "focus":
                props.changeValue(props.setFocus, value);
                break;
            case "information":
                props.changeValue(props.setInformation, value);
                break;
            case "decisions":
                props.changeValue(props.setDecisions, value);
                break;
            case "outerlife":
                props.changeValue(props.setOuterlife, value);
                break;
            default:
                break;
        }
    };

    return (
        <>
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
                        <Radio color="success" classNames={{ wrapper: ['h-20 w-20'], control: ['h-20 w-20'] }} value="3" />
                        <Radio color="success" classNames={{ wrapper: ['h-16 w-16'], control: ['h-16 w-16'] }} value="2" />
                        <Radio color="success" classNames={{ wrapper: ['h-12 w-12'], control: ['h-12 w-12'] }} value="1" />
                        <Radio color="default" classNames={{ wrapper: ['h-12 w-12'], control: ['h-12 w-12'] }} value="0" />
                        <Radio color="secondary" classNames={{ wrapper: ['h-12 w-12'], control: ['h-12 w-12'] }} value="-1" />
                        <Radio color="secondary" classNames={{ wrapper: ['h-16 w-16'], control: ['h-16 w-16'] }} value="-2" />
                        <Radio color="secondary" classNames={{ wrapper: ['h-20 w-20'], control: ['h-20 w-20'] }} value="-3" />
                    </RadioGroup>
                    <div className="w-40 text-center">No estoy de acuerdo</div>
                </div>
                <Divider className="mt-12" />
            </div>
        </>
    )
}
