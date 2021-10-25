package quizweb.domain.servrice.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.common.enums.ChoiceTypeEnum;
import quizweb.common.properties.ApplicationProperties;
import quizweb.common.util.FileUtil;
import quizweb.domain.repository.entity.Choice;
import quizweb.domain.repository.entity.Question;
import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.entity.QuizTagging;
import quizweb.domain.repository.entity.Tag;
import quizweb.domain.repository.mapper.ChoiceMapper;
import quizweb.domain.repository.mapper.QuestionMapper;
import quizweb.domain.repository.mapper.QuizMapper;
import quizweb.domain.repository.mapper.QuizTaggingMapper;
import quizweb.domain.repository.mapper.TagMapper;
import quizweb.domain.servrice.CreateQuizService;
import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam;
import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam.CreateChoiceParam;
import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam.CreateQuestionParam;

@Service
public class CreateQuizServiceImpl implements CreateQuizService {
    @Autowired
    public CreateQuizServiceImpl(QuizMapper quizMapper, QuestionMapper questionMapper, ChoiceMapper choiceMapper,
            ApplicationProperties applicationProperties, TagMapper tagMapper, QuizTaggingMapper quizTaggingMapper) {
        this.quizMapper = quizMapper;
        this.questionMapper = questionMapper;
        this.choiceMapper = choiceMapper;
        this.applicationProperties = applicationProperties;
        this.tagMapper = tagMapper;
        this.quizTaggingMapper = quizTaggingMapper;
    }

    private QuizMapper quizMapper;
    private QuestionMapper questionMapper;
    private ChoiceMapper choiceMapper;
    private TagMapper tagMapper;
    private QuizTaggingMapper quizTaggingMapper;
    private ApplicationProperties applicationProperties;

    @Override
    public void createQuiz(CreateQuizParam createQuizParam) throws IOException {
        TwitterUser loginUser = (TwitterUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Quiz quiz = new Quiz();
        quiz.setCreateUserid(loginUser.getUserId());
        quiz.setCategory(createQuizParam.getCategory());

        String fileName = FileUtil.saveImageByBase64(applicationProperties.getImageThumbnailPath(),
                createQuizParam.getThumbnail());
        quiz.setThumbnail(fileName);

        quiz.setTitle(createQuizParam.getTitle());
        quiz.setDescription(createQuizParam.getDescription());
        // quizmapper.insertが自動採番されたidをとってくれる
        // because useGeneratedKeys="true" on mapper
        quizMapper.insert(quiz);

        List<Tag> tags = insertAndUpdateTags(createQuizParam.getTags());

        insertQuizTagging(quiz.getId(), tags);
        // パラメータが持つquestionをinsert
        insertQuestions(quiz.getId(), createQuizParam.getQuestions());

    }

    private List<Tag> insertAndUpdateTags(List<Tag> tagList) {
        List<Tag> insertTags = tagList.stream().filter(t -> t.getId() == null).collect(Collectors.toList());
        tagMapper.insertList(insertTags);
        List<Tag> updateTags = tagList.stream().filter(t -> t.getId() != null).collect(Collectors.toList());
        for (Tag tag : updateTags)
            tagMapper.updateByPrimaryKey(tag);

        return Stream.concat(insertTags.stream(), updateTags.stream()).collect(Collectors.toList());
    }

    private void insertQuizTagging(Long quizId, List<Tag> tags) {
        List<QuizTagging> quizTaggings = new ArrayList<>();
        for (Tag tag : tags) {
            QuizTagging quizTagging = new QuizTagging();
            quizTagging.setQuizId(quizId);
            quizTagging.setTagId(tag.getId());
        }
        quizTaggingMapper.insertList(quizTaggings);
        
    }

    private void insertQuestions(long quizId, List<CreateQuestionParam> params) throws IOException {
        System.out.println(params);
        for (int i = 0; i < params.size(); i++) {
            CreateQuestionParam questionParam = params.get(i);
            Question question = new Question();
            question.setQuizId(quizId);
            question.setNum(i + 1);
            question.setContent(questionParam.getContent());
            question.setChoiceType(questionParam.getChoiceType().toString());
            questionMapper.insert(question);
            insertChoice(questionParam.getChoiceType(), question.getId(), questionParam.getChoices());
        }

    }

    private void insertChoice(ChoiceTypeEnum choiceType, Long questionId, List<CreateChoiceParam> params)
            throws IOException {
        switch (choiceType) {
            case single:
                insertSingleChoice(questionId, params);
                break;
            case image:
                insertImageChoice(questionId, params);
                break;
        }
    }

    private void insertSingleChoice(long questionId, List<CreateChoiceParam> params) {
        for (int i = 0; i < params.size(); i++) {
            CreateChoiceParam questionParam = params.get(i);

            long choiceId = Long.valueOf(String.valueOf(i) + String.valueOf(questionId));
            Choice choice = new Choice();
            choice.setId(choiceId);
            choice.setQuestionId(questionId);
            choice.setContent(questionParam.getContent());
            choice.setCorrectFlg(questionParam.getCorrectFlg());
            choice.setSelectionNo(i);

            choiceMapper.insert(choice);
        }

    }

    private void insertImageChoice(long questionId, List<CreateChoiceParam> params) throws IOException {
        for (int i = 0; i < params.size(); i++) {
            CreateChoiceParam questionParam = params.get(i);
            long choiceId = Long.valueOf(String.valueOf(i) + String.valueOf(questionId));
            Choice choice = new Choice();
            choice.setSelectionNo(i);
            choice.setId(choiceId);
            choice.setQuestionId(questionId);

            String fileName = FileUtil.saveImageByBase64(applicationProperties.getImageChoicePath(),
                    questionParam.getContent());
            choice.setContent(fileName);

            choice.setCorrectFlg(questionParam.getCorrectFlg());

            choiceMapper.insert(choice);

        }
    }

}
