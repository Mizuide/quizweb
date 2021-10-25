package quizweb.repository.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.repository.mapper.QuizMapper;

@SpringBootTest
public class QuizMapperTest {
    @Autowired
    QuizMapper quizMapper;

    // @Test
    // public void selectTestOrderNew() {

    // SearchCondition searchCondition = new SearchCondition(Category.all, null,
    // Order.newOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 15);

    // String expectTitle = "進撃の巨人クイズ 中級";

    // assertEquals(expectTitle, quiz.get(0).getTitle());
    // }

    // @Test
    // public void selectTestOrderOld() {

    // SearchCondition searchCondition = new SearchCondition(Category.all, null,
    // Order.oldOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 15);

    // String expectTitle = "進撃の巨人クイズ";

    // assertEquals(expectTitle, quiz.get(0).getTitle());
    // }

    // @Test
    // public void selectTestLimit() {

    // SearchCondition searchCondition = new SearchCondition(Category.all, null,
    // Order.oldOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 1);

    // int expectSize = 1;

    // assertEquals(expectSize, quiz.size());
    // }

    // @Test
    // public void selectTestWhereCategory() {

    // SearchCondition searchCondition = new SearchCondition(Category.study,null,
    // Order.oldOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 1);

    // int expectSize = 0;

    // assertEquals(expectSize, quiz.size());
    // }
    // @Test
    // public void selectTestWhereTitle() {

    // SearchCondition searchCondition = new SearchCondition(Category.all,"進撃の巨人",
    // Order.oldOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 15);

    // String expectTitle = "進撃の巨人クイズ";

    // assertEquals(expectTitle, quiz.get(0).getTitle());
    // }

    // @Test
    // public void selectTestWhereTitle2() {

    // SearchCondition searchCondition = new SearchCondition(Category.all,"中級",
    // Order.oldOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 15);

    // String expectTitle = "進撃の巨人クイズ 中級";

    // assertEquals(expectTitle, quiz.get(0).getTitle());
    // }

    // @Test
    // public void selectTest2() {

    // SearchCondition searchCondition = new SearchCondition(Category.all, null,
    // Order.oldOrder);

    // List<Quiz> quiz = quizMapper.fetchFirstPage(searchCondition, 5);
    // quiz = quizMapper.fetchPage(searchCondition, quiz.get(4), 5);

    // long expectId = 6;

    // assertEquals(expectId, quiz.get(0).getId());
    // }
}
