package quizweb.presentation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quizweb.domain.servrice.GetAnwerService;
import quizweb.presentation.request.AnswerRequest;

@RestController
public class AnswerController {

    @Autowired
    public AnswerController(GetAnwerService getAnwerService) {
        this.getAnwerService = getAnwerService;
    }

    GetAnwerService getAnwerService;

    @PostMapping("/answer")
    @ResponseBody
    public int getAnswer(@RequestBody AnswerRequest request) {
        int correct = getAnwerService.getAnswer(request.getQuestionId());
        return correct;
    }

}
