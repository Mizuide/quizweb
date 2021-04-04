package quizweb.app.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import quizweb.app.restcontroller.response.Question;

@RestController
public class QuestionController {
    
    @GetMapping("/getQuestion")
    public Question getQuestion(){
            Question quiz = new Question();
            quiz.setId(3l);
            return quiz;
    }


}
