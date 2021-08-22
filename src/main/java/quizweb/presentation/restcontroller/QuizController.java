package quizweb.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quizweb.domain.servrice.CreateQuizService;
import quizweb.domain.servrice.GetQuizService;
import quizweb.domain.servrice.valueobject.QuizesInfo;
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
    public QuizesInfo getQuestion(@RequestBody GetQuizRequest request) {

        QuizesInfo quizesInfo = getQuizService.getQuizList(request);
        return quizesInfo;
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
