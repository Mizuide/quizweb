package quizweb.presentation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.servrice.GetQuizService;
import quizweb.presentation.request.GetQuizRequest;

@RestController
public class QuizController {
    @Autowired
    public QuizController(GetQuizService getQuizService) {
        this.getQuizService = getQuizService;
    }

    GetQuizService getQuizService;

    @PostMapping("/quiz")
    @ResponseBody
    public List<Quiz> getQuestion(@RequestBody GetQuizRequest request) {
    
        List<Quiz> quizList = getQuizService.getQuizList(request);
        return quizList;
    }

    

}
