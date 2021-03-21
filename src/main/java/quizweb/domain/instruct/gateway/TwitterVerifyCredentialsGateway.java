package quizweb.domain.instruct.gateway;

import quizweb.domain.instruct.valueobject.response.TwitterVerifyCredentialsResponse;

public interface TwitterVerifyCredentialsGateway {
    public TwitterVerifyCredentialsResponse fetchAPI(String oauthToken, String oauthSecretToken);
}
