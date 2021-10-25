package quizweb.domain.servrice.valueobject;

import java.util.ArrayList;
import java.util.List;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.entity.TaggingInfo;

public class QuizesInfo {
    public QuizesInfo(int count, List<Quiz> quizList, List<TaggingInfo> taggingInfoList) {
        this.count = count;
        this.quizes = new ArrayList<>(quizList);
        this.taggingInfoList = new ArrayList<>(taggingInfoList);
    }

    private int count;

    private List<Quiz> quizes;

    private List<TaggingInfo> taggingInfoList;

    public int getCount() {
        return count;
    }

    public List<Quiz> getQuizes() {
        return new ArrayList<>(quizes);
    }

    public List<TaggingInfo> getTags() {
        return new ArrayList<>(taggingInfoList);
    }
}
