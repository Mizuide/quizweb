package quizweb.domain.servrice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.repository.entity.Choice;
import quizweb.domain.repository.entity.Question;
import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.mapper.ChoiceMapper;
import quizweb.domain.repository.mapper.QuestionMapper;
import quizweb.domain.repository.mapper.QuizMapper;
import quizweb.domain.servrice.CreateQuizService;
import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam;
import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam.CreateChoiceParam;
import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam.CreateQuestionParam;

@Service
public class CreateQuizServiceImpl implements CreateQuizService {
    @Autowired
    public CreateQuizServiceImpl(QuizMapper quizMapper, QuestionMapper questionMapper, ChoiceMapper choiceMapper) {
        this.quizMapper = quizMapper;
        this.questionMapper = questionMapper;
        this.choiceMapper = choiceMapper;
    }

    private QuizMapper quizMapper;
    private QuestionMapper questionMapper;
    private ChoiceMapper choiceMapper;

    @Override
    public void createQuiz(CreateQuizParam createQuizParam) {
        TwitterUser loginUser = (TwitterUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Quiz quiz = new Quiz();
        quiz.setCreateUserid(loginUser.getUserId());
        quiz.setCategory(createQuizParam.getCategory());
        quiz.setTitle(createQuizParam.getTitle());
        quiz.setDescription(createQuizParam.getDescription());
        quizMapper.insert(quiz);
        // パラメータが持つquestionをinsert
        insertQuestions(quiz.getId(), createQuizParam.getQuestions());

    }

    private void insertQuestions(long quizId, List<CreateQuestionParam> params) {
        System.out.println(params);
        for (int i = 0; i < params.size(); i++) {
            CreateQuestionParam questionParam = params.get(i);
            Question question = new Question();
            question.setQuizId(quizId);
            question.setNum(i + 1);
            question.setContent(questionParam.getContent());
            questionMapper.insert(question);
            insertChoice(question.getId(), questionParam.getChoices());
        }

    }

    private void insertChoice(long questionId, List<CreateChoiceParam> params) {
        for (int i = 0; i < params.size(); i++) {
            CreateChoiceParam questionParam = params.get(i);

            long choiceId = Long.valueOf(String.valueOf(i) + String.valueOf(questionId));
            Choice choice = new Choice();
            choice.setId(choiceId);
            choice.setQuestionId(questionId);
            choice.setContent(questionParam.getContent());
            choice.setCorrectFlg(questionParam.getCorrectFlg());

            choiceMapper.insert(choice);

        }

    }
}
