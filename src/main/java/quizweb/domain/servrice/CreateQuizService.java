package quizweb.domain.servrice;

import quizweb.presentation.request.CreateQuizRequest.CreateQuizParam;

public interface CreateQuizService {
    
    public void createQuiz(CreateQuizParam createQuizParam);

}
