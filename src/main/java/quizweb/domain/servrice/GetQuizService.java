package quizweb.domain.servrice;

import java.util.List;

import quizweb.domain.repository.entity.Quiz;
import quizweb.presentation.request.GetQuizRequest;

public interface GetQuizService {


    public List<Quiz> getQuizList(GetQuizRequest request);

}
