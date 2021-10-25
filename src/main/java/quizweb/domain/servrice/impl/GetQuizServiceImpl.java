package quizweb.domain.servrice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.entity.TaggingInfo;
import quizweb.domain.repository.mapper.QuizMapper;
import quizweb.domain.repository.mapper.TaggingInfoMapper;
import quizweb.domain.servrice.GetQuizService;
import quizweb.domain.servrice.valueobject.QuizesInfo;
import quizweb.presentation.request.GetQuizRequest;

@Service
public class GetQuizServiceImpl implements GetQuizService {

    @Autowired
    public GetQuizServiceImpl(QuizMapper quizMapper, TaggingInfoMapper taggingInfoMapper) {
        this.quizMapper = quizMapper;
        this.taggingInfoMapper = taggingInfoMapper;
    }

    QuizMapper quizMapper;

    TaggingInfoMapper taggingInfoMapper;

    @Override
    public QuizesInfo getQuizList(GetQuizRequest request) {

        // String title = request.getSearchCondition().getTitle();
        // Order order = request.getSearchCondition().getOrder();
        // String tag = request.getSearchCondition().getTag();

        // SearchCondition searchCondition = new SearchCondition(title, order, tag);

        int count = quizMapper.count(request.getSearchCondition());
        int limit = request.getFetchSize();
        int offset = request.getFetchSize() * (request.getPage() - 1);

        List<Quiz> quizList = quizMapper.fetchQuizes(request.getSearchCondition(), limit, offset);
        // 内部結合してクイズID含むタグのリストをとる
        List<TaggingInfo> tagList = taggingInfoMapper.getTaggingInfoByQuizId(quizList);

        QuizesInfo quizesInfo = new QuizesInfo(count, quizList, tagList);

        return quizesInfo;
    }

}