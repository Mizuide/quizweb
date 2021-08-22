package quizweb.domain.servrice;

import quizweb.domain.servrice.valueobject.QuizesInfo;
import quizweb.presentation.request.GetQuizRequest;

public interface GetQuizService {

    public QuizesInfo getQuizList(GetQuizRequest request);

}
