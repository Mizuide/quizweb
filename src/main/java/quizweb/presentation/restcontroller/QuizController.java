package quizweb.presentation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.servrice.CreateQuizService;
import quizweb.domain.servrice.GetQuizService;
import quizweb.presentation.request.CreateQuizRequest;
import quizweb.presentation.request.GetQuizRequest;

@RestController
public class QuizController {
    @Autowired
    public QuizController(GetQuizService getQuizService, CreateQuizService createQuizService) {
        this.getQuizService = getQuizService;
        this.createQuizService = createQuizService;
    }

    GetQuizService getQuizService;
    CreateQuizService createQuizService;

    @PostMapping("/quiz/get")
    @ResponseBody
    public List<Quiz> getQuestion(@RequestBody GetQuizRequest request) {

        List<Quiz> quizList = getQuizService.getQuizList(request);
        return quizList;
    }

    @PostMapping("/quiz/create")
    public boolean createQuestion(@RequestBody CreateQuizRequest request) {
        try {
            createQuizService.createQuiz(request.getCreateQuizParam());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
