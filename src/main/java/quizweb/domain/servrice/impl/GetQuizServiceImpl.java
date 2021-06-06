package quizweb.domain.servrice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.mapper.QuizMapper;
import quizweb.domain.servrice.GetQuizService;
import quizweb.domain.servrice.constenum.Category;
import quizweb.domain.servrice.constenum.Order;
import quizweb.domain.servrice.valueobject.SearchCondition;
import quizweb.presentation.request.GetQuizRequest;

@Service
public class GetQuizServiceImpl implements GetQuizService {
    final int fetchSize = 10;

    @Autowired
    public GetQuizServiceImpl(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    QuizMapper quizMapper;

    @Override
    public List<Quiz> getQuizList(GetQuizRequest request) {
        List<Quiz> quizList = null;
        Category category = Category.valueOf(request.getSearchCondition().getCategory());
        String title = request.getSearchCondition().getTitle();
        Order order = Order.valueOf(request.getSearchCondition().getOrder());
        SearchCondition searchCondition = new SearchCondition(category, title, order);
        if (request.getLastQuiz() == null) {
            quizList = quizMapper.fetchFirstPage(searchCondition, fetchSize);
        } else {
            quizList = quizMapper.fetchPage(searchCondition, request.getLastQuiz(), fetchSize);
        }
        return quizList;
    }

}