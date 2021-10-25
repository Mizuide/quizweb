package quizweb.domain.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import quizweb.domain.repository.entity.Quiz;
import quizweb.domain.repository.entity.TaggingInfo;

@Mapper
public interface TaggingInfoMapper {
    List<TaggingInfo> getTaggingInfoByQuizId(List<Quiz> quizList);
    
}
