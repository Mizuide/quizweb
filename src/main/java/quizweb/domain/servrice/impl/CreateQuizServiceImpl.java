package quizweb.domain.servrice.impl;

import java.util.Calendar;

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
        //TODO: too big
        long quizId = Long.valueOf(
                String.valueOf(Calendar.getInstance().getTimeInMillis()) + String.valueOf(loginUser.getUserId()));

        Quiz quiz = new Quiz();
        quiz.setId(quizId);
        quiz.setCreateUserid(loginUser.getUserId());
        quiz.setCategory(createQuizParam.getCategory());
        quiz.setTitle(createQuizParam.getTitle());
        quiz.setDescription(createQuizParam.getDescription());
        quizMapper.insert(quiz);
        //quizが持つquestionをinsert
        insertQuestions(quizId, createQuizParam.getQuestionParams());
        
    }

    private void insertQuestions(long quizId,CreateQuestionParam[] params){
        for (int i = 0; i < params.length; i++) {
            CreateQuestionParam questionParam = params[i];
            
            long questionId = Long.valueOf(String.valueOf(i)+String.valueOf(quizId));
            Question question = new Question();
            question.setId(questionId);
            question.setQuizId(quizId);
            question.setNum(i + 1);
            question.setContent(questionParam.getContent());
            questionMapper.insert(question);
            insertChoice(quizId, questionParam.getChoiceParams());            
        }

    }

    private void insertChoice(long questionId,CreateChoiceParam[] params){
        for (int i = 0; i < params.length; i++) {
            CreateChoiceParam questionParam = params[i];
            
            long choiceId = Long.valueOf(String.valueOf(i)+String.valueOf(questionId));
            Choice choice = new Choice();
            choice.setId(choiceId);
            choice.setQuestionId(questionId);
            choice.setContent(questionParam.getContent());
            choice.setCorrectFlg(questionParam.getCorrectFlg());
            
            choiceMapper.insert(choice);

        }

    }
}
