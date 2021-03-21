package quizweb.domain.instruct.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import quizweb.common.properties.TwitterAPITokenProperties;
import quizweb.common.properties.TwitterAPIUrlProperties;
import quizweb.domain.instruct.gateway.TwitterAccessTokenGateway;
import quizweb.domain.instruct.valueobject.request.TwitterAccessTokenRequest;
import quizweb.domain.instruct.valueobject.response.TwitterAccessTokenResponse;

@Component
public class TwitterAccessTokenGatewayImpl implements TwitterAccessTokenGateway {
    private RestTemplate restTemplate;
    private TwitterAPITokenProperties twitterAPITokenProperties;
    private TwitterAPIUrlProperties twitterAPIUrlProperties;

    @Autowired
    public TwitterAccessTokenGatewayImpl(RestTemplate restTemplate, TwitterAPITokenProperties twitterAPITokenProperties,
            TwitterAPIUrlProperties twitterAPIUrlProperties) {
        this.restTemplate = restTemplate;
        this.twitterAPITokenProperties = twitterAPITokenProperties;
        this.twitterAPIUrlProperties = twitterAPIUrlProperties;
    }

    @Override
    public TwitterAccessTokenResponse fetchAPI(String oauthToken, String oauthVerifier) {
        TwitterAccessTokenRequest request = new TwitterAccessTokenRequest(twitterAPITokenProperties,
                twitterAPIUrlProperties, oauthToken, oauthVerifier);
        TwitterAccessTokenResponse response = null;
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(request.getRequetEntity(), String.class);
            response = new TwitterAccessTokenResponse(responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
