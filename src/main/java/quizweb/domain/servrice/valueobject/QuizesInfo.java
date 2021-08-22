package quizweb.domain.servrice.valueobject;

import java.util.ArrayList;
import java.util.List;

import quizweb.domain.repository.entity.Quiz;

public class QuizesInfo {
    public QuizesInfo(int count, List<Quiz> quizList) {
        this.count = count;
        this.quizes = new ArrayList<>(quizList);
    }

    private int count;

    private List<Quiz> quizes;

    public int getCount() {
        return count;
    }

    public List<Quiz> getQuizes() {
        return new ArrayList<>(quizes);
    }
}
