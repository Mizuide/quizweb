package quizweb.app.servrice;

import quizweb.app.valueobject.UserInfo;
import quizweb.domain.instruct.valueobject.response.TwitterAccessTokenResponse;


public interface LoginWithTwitterService {

    public TwitterAccessTokenResponse getAccessToken(String oauthToken,String oauthVerifier);

    public UserInfo getUserInfo();

    public void setSession();

    public void doLogin(String oAuthToken, String oauthVerifier);

}
