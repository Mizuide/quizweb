import { useEffect, useRef, useState } from "react";
import { Form, Label, Segment, TextArea } from "semantic-ui-react";
import css from "../../css/createQuizForm.module.scss";
import { useAddQuestion, useChangeQuestion, useDeleteQuestion } from "../../hooks/useChangeQuizContext";
import semantic_error from "../../type/semantic_error";
import CreateChoiceForm from "./CreateChoiceForm";
import choiceType from "../../type/choiceType"

type questionFieldProp = {
    questionIndex: number;
    deleteThis: () => void;
    error?: semantic_error;
}

const QuestionFields: React.FC<questionFieldProp[]> = (prop: questionFieldProp[]) => {

    const [values, setValues] = useState<{ questionIndex: number, content: string, comment: string, questionType: string }[]>([])
    const [choiceType,setChoiceType] = useState<choiceType>('single')

    useEffect(() => {
        setValues(prop.map(
            p => { return { questionIndex: p.questionIndex, content: '', comment: '', questionType: 'singleChoice' } })
        );
    }, [prop])

    const changeQuestion = useChangeQuestion();

    function setValue({ questionIndex, content = undefined, comment = undefined }:
        { questionIndex: number, content?: string, comment?: string }) {
        const targetQuestion = values.find(p => p.questionIndex === questionIndex)

        if (targetQuestion === undefined)
            throw new Error('not found questionIndex:' + questionIndex);

        changeQuestion(questionIndex, content || targetQuestion.content, comment || targetQuestion.comment)
        setValues([...values.map(p => {
            if (p.questionIndex === targetQuestion.questionIndex)
                return {
                    questionIndex: questionIndex, content: content ||
                        targetQuestion.content, comment: comment || targetQuestion.comment,
                    questionType: p.questionType
                };
            return p;
        }
        )])
    }

    const questionTypeOptions = [{ key: 'single', text: 'テキスト', value: 'single' },
         { key: 'image', text: '画像', value: 'image' }]
    const fields = prop.map((prop, index) => {
        return (
            <Segment key={prop.questionIndex}>

                <Form.Group unstackable >
                    <Label size={"large"} style={{ fontSize: '1.1rem' }} color='blue' ribbon>
                        問題{index + 1}
                    </Label>
                    <Form.Button size='medium' icon='trash' onClick={() => prop.deleteThis()} content='削除' />
                </Form.Group>
                <Form.Dropdown
                label='問題形式'
                    fluid
                    selection
                    options={questionTypeOptions}
                    defaultValue={questionTypeOptions[0].value}
                    onChange={(e: any, option: any) => setChoiceType(option.value)}
                />
                <Form.Field control={TextArea} placeholder="問題文を入力してください" label='問題文'
                    onChange={(e: any) => setValue({ questionIndex: prop.questionIndex, content: e.target.value })}
                    error={prop.error} />
                <CreateChoiceForm questionIndex={prop.questionIndex} choiceType={choiceType}/>
                <Form.Input label='コメント' placeholder="回答後に表示されるコメントを入力してください"
                    onChange={(e: any) => setValue({ questionIndex: prop.questionIndex, comment: e.target.value })}
                />
            </Segment>
        )
    })
    return (
        <>
            {fields}
        </>
    )
}

type prop = {

}

const CreateQuestionForm: React.FC<prop> = (prop: prop) => {
    const [nextIndex, setNextIndex] = useState<number>(1);

    const [questionFieldProps, setQuestionFieldProps] = useState<questionFieldProp[]>([]);
    //useRef to  define delete functon
    const questionFieldPropsRef = useRef<questionFieldProp[]>(questionFieldProps);
    questionFieldPropsRef.current = questionFieldProps;

    const deleteQuestion = useDeleteQuestion();
    const addQuestionToContext = useAddQuestion();


    useEffect(() => addQuestion(0), [])

    // const zodError = useContext(ZodErrorContext);
    // useEffect(() => {
    //     if (zodError !== undefined) {
    //         const errorOccurQuiz = zodError.issues.filter(is => is.path.length === 1);

    //         for (let issue of errorOccurQuiz) {
    //             if (issue.path.includes('questions'))
    //                 setQuestionNumError({ content: issue.message, pointing: 'above' });
    //         }
    //     }

    // }, [zodError])

    const addQuestion = (nextIndex: number) => {

        //define delete function
        const deleteThis = () => {
            //use '!=' because reactElement.key's type is string
            setQuestionFieldProps(questionFieldPropsRef.current.filter(p => p.questionIndex !== nextIndex));
            deleteQuestion(nextIndex);
        }

        addQuestionToContext({ indexId: nextIndex, content: "", comment: "", choices: [] });


        const newQuestionFieldProp: questionFieldProp = {
            questionIndex: nextIndex,
            deleteThis: deleteThis,
        }

        questionFieldPropsRef.current.push(newQuestionFieldProp);
        setQuestionFieldProps([...questionFieldPropsRef.current]);
    }

    return (
        <>
            {QuestionFields(questionFieldProps)}
            <div className={`${css.btn} ${css['btn-secondary']} ${css.addButton}`} onClick={() => {
                addQuestion(nextIndex);
                setNextIndex(nextIndex + 1);
            }}><i className={css['bi-journal-plus']} /> 問題を追加する</div>
        </>
    )
}

export default CreateQuestionForm;