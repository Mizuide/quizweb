package quizweb.domain.instruct.gateway;

import quizweb.domain.instruct.valueobject.response.TwitterAccessTokenResponse;

public interface TwitterAccessTokenGateway {
    public TwitterAccessTokenResponse fetchAPI(String oauthToken,String oauthVerifier);
}
