package quizweb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.app.servrice.LoginWithTwitterService;

@SpringBootTest
public class LoginWithTwiterTest {
    @Autowired
    LoginWithTwitterService target;


    @Test
    public void getOauthTokenTest(){
        String oAuthToken;
    }

    @Test
    public void getUserInfo(){
        String oAuthToken;
        String oAuthTokenSecret;
    }

    @Test
    public void setSession(){

    }

    //do
    @Test
    public void doLoginTest(){

    }

}
