package quizweb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.repository.entity.Tag;
import quizweb.domain.servrice.GetQuizService;
import quizweb.domain.servrice.constenum.Order;
import quizweb.domain.servrice.valueobject.QuizesInfo;
import quizweb.domain.servrice.valueobject.SearchCondition;
import quizweb.presentation.request.GetQuizRequest;

@SpringBootTest
public class GetQuestionServiceTest {
    @Autowired
    GetQuizService target;

    @Test
    public void searchByTitle() {

        GetQuizRequest request = new GetQuizRequest();
        SearchCondition searchConditions = new SearchCondition("進撃の巨人", Order.newOrder, null);

        request.setSearchConditions(searchConditions);
        request.setPage(1);
        request.setFetchSize(10);

        QuizesInfo result = target.getQuizList(request);

        assertEquals("進撃の巨人クイズ", result.getQuizes().get(0).getTitle());

    }

    @Test
    public void searchByTag() {

        GetQuizRequest request = new GetQuizRequest();
        List<Tag> tags = new ArrayList<>();
        Tag t1 = new Tag();
        t1.setId(1l);
        t1.setNum(2l);
        t1.setTag("漫画");

        tags.add(t1);
        SearchCondition searchConditions = new SearchCondition("", Order.newOrder, tags);

        request.setSearchConditions(searchConditions);
        request.setPage(1);
        request.setFetchSize(10);

        QuizesInfo result = target.getQuizList(request);

        assertEquals("進撃の巨人クイズ", result.getQuizes().get(0).getTitle());

    }
}
