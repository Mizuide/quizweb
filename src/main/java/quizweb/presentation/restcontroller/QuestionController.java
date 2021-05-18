package quizweb.presentation.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import quizweb.domain.repository.entity.Quiz;

@RestController
public class QuestionController {
    
    @GetMapping("/getQuestions")
    public List<Quiz> getQuestion(){
        List<Quiz> ret = new ArrayList<>();
            
            Quiz quiz = new Quiz();
            quiz.setId(3l);
            quiz.setTitle("test");
            ret.add(quiz);
            return ret;
    }


}
