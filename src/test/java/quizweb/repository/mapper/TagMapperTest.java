package quizweb.repository.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import quizweb.domain.repository.entity.Tag;
import quizweb.domain.repository.mapper.TagMapper;

@SpringBootTest
public class TagMapperTest {
    @Autowired
    TagMapper tagMapper;

    @Test
    @Transactional
    public void test1() {
        List<Tag> tagList = new ArrayList<>();
        Tag t1 = new Tag();
        t1.setNum(1l);
        t1.setTag("test");
        tagList.add(t1);

        Tag t2 = new Tag();
        t2.setNum(1l);
        t2.setTag("test2");
        tagList.add(t2);

        int resulNum = tagMapper.insertList(tagList);

        assertEquals(2, resulNum);

    }
}