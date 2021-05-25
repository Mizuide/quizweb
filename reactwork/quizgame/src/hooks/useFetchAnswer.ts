import axios, { AxiosResponse } from 'axios';
import { useState } from "react";
import fetchAnswerParam from "../type/fetchAnswerParam";
import useWaitingContext from "./useWaitingContext"

const ANSWER_URL: string = "/quizWeb/answer";
const useFetchAnswer: () => [number | undefined, (param: fetchAnswerParam) => void] = () => {
    const [answer, setAnswer] = useState<number>();

    const setFetchAnswer = (param: fetchAnswerParam) => {
        useWaitingContext(axios.post<number>(ANSWER_URL, { ...param }).then(res => setAnswer(res.data)));;
    }

    return [answer, setFetchAnswer];
}

export default useFetchAnswer;
