package quizweb.domain.servrice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizweb.domain.repository.entity.QuizDetail;
import quizweb.domain.repository.mapper.QuizDetailMapper;
import quizweb.domain.servrice.GetQuizDetailService;

@Service
public class GetQuizDetailServiceImpl implements GetQuizDetailService {

    @Autowired
    public GetQuizDetailServiceImpl(QuizDetailMapper quizDetailMapper) {
        this.quizDetailMapper = quizDetailMapper;
    }

    QuizDetailMapper quizDetailMapper;

    @Override
    public QuizDetail getQuizDeteail(String id) {
        quizDetailMapper.getQuizDetail(Long.parseLong(id));
        return quizDetailMapper.getQuizDetail(Long.parseLong(id));
    }

}
