package quizweb.presentation.request;

public class AnswerRequest {
    private long questionId;
    private long selecselectiionNo;

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public void setSelecselectiionNo(long selecselectiionNo) {
        this.selecselectiionNo = selecselectiionNo;
    }

    public long getQuestionId() {
        return questionId;
    }

    public long getSelecselectiionNo() {
        return selecselectiionNo;
    }

}
