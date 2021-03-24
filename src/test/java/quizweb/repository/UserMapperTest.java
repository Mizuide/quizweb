package quizweb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.repository.mapper.UserMapper;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper target;

    @Test
    public void test(){
 
        System.out.println(target.find(0));
    }


}
