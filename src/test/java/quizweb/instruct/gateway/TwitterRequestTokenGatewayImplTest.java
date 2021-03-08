package quizweb.instruct.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.instruct.gateway.TwitterRequestTokenGateway;
import quizweb.domain.instruct.valueobject.response.TwitterRequestTokenResponse;

@SpringBootTest
public class TwitterRequestTokenGatewayImplTest {
    @Autowired
    TwitterRequestTokenGateway target;
    
    @Test
    public void fetchAPITest(){
        TwitterRequestTokenResponse actual = target.fetchAPI("https://github.com/", "");
    System.out.println(actual.getOauthToken());
    }
}
