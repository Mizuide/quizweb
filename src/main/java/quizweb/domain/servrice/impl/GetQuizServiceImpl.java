package quizweb.domain.servrice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.mapper.QuizMapper;
import quizweb.domain.servrice.GetQuizService;
import quizweb.domain.servrice.constenum.Order;
import quizweb.domain.servrice.valueobject.QuizesInfo;
import quizweb.domain.servrice.valueobject.SearchCondition;
import quizweb.presentation.request.GetQuizRequest;

@Service
public class GetQuizServiceImpl implements GetQuizService {
  
    @Autowired
    public GetQuizServiceImpl(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    QuizMapper quizMapper;

    @Override
    public QuizesInfo getQuizList(GetQuizRequest request) {
        
        String title = request.getSearchCondition().getTitle();
        Order order = Order.valueOf(request.getSearchCondition().getOrder());
        SearchCondition searchCondition = new SearchCondition( title, order);
        
        int count = quizMapper.count(searchCondition); 
        int limit = request.getFetchSize();
        int offset = request.getFetchSize() * (request.getPage()-1);

        List<Quiz> quizList = quizMapper.fetchQuizes(searchCondition,limit,offset);
        
        QuizesInfo quizesInfo =new QuizesInfo(count, quizList);

        return quizesInfo;
    }

}