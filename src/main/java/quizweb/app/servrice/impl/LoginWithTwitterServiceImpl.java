package quizweb.app.servrice.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import quizweb.app.servrice.LoginWithTwitterService;
import quizweb.app.valueobject.UserInfo;
import quizweb.domain.instruct.gateway.TwitterAccessTokenGateway;
import quizweb.domain.instruct.gateway.TwitterVerifyCredentialsGateway;
import quizweb.domain.instruct.valueobject.request.TwitterAccessTokenRequest;
import quizweb.domain.instruct.valueobject.response.TwitterAccessTokenResponse;

@Component
public class LoginWithTwitterServiceImpl implements LoginWithTwitterService {

    @Autowired
    TwitterAccessTokenGateway twitterAccessTokenGateway;

    @Autowired
    TwitterVerifyCredentialsGateway twitterVerifyCredentialsGateway;

    @Override
    public TwitterAccessTokenResponse getAccessToken(String oauthToken,String oauthVerifier) {
        TwitterAccessTokenResponse res = twitterAccessTokenGateway.fetchAPI(oauthToken, oauthVerifier);
   
        return res;
    }

    @Override
    public UserInfo getUserInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSession() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doLogin(String oauthToken, String oauthVerifier) {
        TwitterAccessTokenResponse accessToken = getAccessToken(oauthToken, oauthVerifier);
        

        System.out.println(accessToken.getOauthToken());
    }
    
}
