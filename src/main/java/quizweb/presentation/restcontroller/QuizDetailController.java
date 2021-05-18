package quizweb.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quizweb.domain.repository.entity.QuizDetail;
import quizweb.domain.servrice.GetQuizDetailService;

@RestController
public class QuizDetailController {
    @Autowired
    public QuizDetailController(GetQuizDetailService getQuizDetailService) {
        this.getQuizDetailService = getQuizDetailService;
    }

    GetQuizDetailService getQuizDetailService;


    @GetMapping("/quizDetail")
    @ResponseBody
    public QuizDetail getQuestionDetail(@RequestParam("quizId") String id) {
    
        QuizDetail quizDetail = getQuizDetailService.getQuizDeteail(id);
        return quizDetail;
    }

}
