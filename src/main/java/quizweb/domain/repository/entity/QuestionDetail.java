package quizweb.domain.repository.entity;

import java.util.List;

public class QuestionDetail extends Question {
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }
}
