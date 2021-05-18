package quizweb.domain.repository.entity;

import java.util.List;

public class QuizDetail extends Quiz {

    private List<QuestionDetail> questions;

    public List<QuestionDetail> getQuestions() {
        return questions;
    }

}
