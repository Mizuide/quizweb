package quizweb.repository.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.repository.entity.QuizDetail;
import quizweb.domain.repository.mapper.QuizDetailMapper;

@SpringBootTest
public class QuizDetailMapperTest {
  @Autowired
  QuizDetailMapper quizDetailMapper;

  @Test
  public void test() {
    QuizDetail qd = quizDetailMapper.getQuizDetail(1l);
    System.out.println(qd.getQuestions().get(0).getContent());
  }
}
