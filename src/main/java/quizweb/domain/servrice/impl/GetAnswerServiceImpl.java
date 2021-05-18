package quizweb.domain.servrice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizweb.domain.repository.entity.Choice;
import quizweb.domain.repository.mapper.ChoiceMapper;
import quizweb.domain.servrice.GetAnwerService;

@Service
public class GetAnswerServiceImpl implements GetAnwerService {
    @Autowired
    public GetAnswerServiceImpl(ChoiceMapper choiceMapper) {
        this.choiceMapper = choiceMapper;

    }

    ChoiceMapper choiceMapper;

    @Override
    public int getAnswer(long quiestionId) {
       Choice correctChoice = choiceMapper.selectCorrectChoice(quiestionId);

        return correctChoice.getSelectionNo();
    }

}
