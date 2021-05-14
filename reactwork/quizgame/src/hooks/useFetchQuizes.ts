import axios, { AxiosResponse } from 'axios';
import { useState } from "react";
import quiz from "../type/quiz";
import fetchQuizParam from "../type/fetchQuizParam";



const QUIZ_URL: string = "/quizWeb/getQuizes";

function fetchQuizes(param: fetchQuizParam): Promise<AxiosResponse<quiz[]>> {
    return axios.get<quiz[]>(QUIZ_URL, { params: param });

}

const useFetchQuizes: () => [quiz[], (prop: fetchQuizParam) => void] = () => {
    const [quizes, setQuizes] = useState<quiz[]>([]);
    const setFetchQuiz = function (prop: fetchQuizParam) {
        fetchQuizes(prop).
            then(res => {
                if (prop.fetchCount === 0) {
                    return res.data;
                } else {
                    return quizes.concat(res.data);
                }
            }).then(newQuizes => setQuizes(newQuizes));
    }

    return [quizes, setFetchQuiz];
}

export default useFetchQuizes;