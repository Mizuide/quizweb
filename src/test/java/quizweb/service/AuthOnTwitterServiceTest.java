package quizweb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.servrice.impl.AuthOnTwitterServiceImpl;

@SpringBootTest
public class AuthOnTwitterServiceTest {
    @Autowired
    AuthOnTwitterServiceImpl target;

    @Test
    public void test(){
        System.out.println(target.callbackURL);
    }

}
