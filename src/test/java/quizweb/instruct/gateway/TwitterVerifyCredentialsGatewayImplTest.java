package quizweb.instruct.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.domain.instruct.gateway.TwitterVerifyCredentialsGateway;
import quizweb.domain.instruct.valueobject.response.TwitterVerifyCredentialsResponse;

@SpringBootTest
public class TwitterVerifyCredentialsGatewayImplTest {
    @Autowired
    TwitterVerifyCredentialsGateway target;

    @Test
    public void test(){
        String oauthToken = "715097467914571776-cklRXhzUgITlhLLppbOVJuFL6IBovij";
        String oauthSecretToken="fGgTOihXdmylzlBVHpysu1bv7hWF2YXqi4JBMtGPtwo1v";

       TwitterVerifyCredentialsResponse result = target.fetchAPI(oauthToken, oauthSecretToken);
        System.out.println(result.getProfileImageUrl());
    }

}
