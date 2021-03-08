package quizweb.domain.instruct.gateway;

import quizweb.domain.instruct.valueobject.response.TwitterRequestTokenResponse;

public interface TwitterRequestTokenGateway {
    public TwitterRequestTokenResponse fetchAPI(String oauthCallback, String xAuthAccessType);
}
