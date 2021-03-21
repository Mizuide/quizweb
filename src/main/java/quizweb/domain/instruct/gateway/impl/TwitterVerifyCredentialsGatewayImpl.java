package quizweb.domain.instruct.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import quizweb.common.properties.TwitterAPITokenProperties;
import quizweb.common.properties.TwitterAPIUrlProperties;
import quizweb.domain.instruct.gateway.TwitterVerifyCredentialsGateway;
import quizweb.domain.instruct.valueobject.request.TwitterVerifyCredentialsRequest;
import quizweb.domain.instruct.valueobject.response.TwitterVerifyCredentialsResponse;

@Component
public class TwitterVerifyCredentialsGatewayImpl implements TwitterVerifyCredentialsGateway {
    private RestTemplate restTemplate;
    private TwitterAPITokenProperties twitterAPITokenProperties;
    private TwitterAPIUrlProperties twitterAPIUrlProperties;

    @Autowired
    public TwitterVerifyCredentialsGatewayImpl(RestTemplate restTemplate,
            TwitterAPITokenProperties twitterAPITokenProperties, TwitterAPIUrlProperties twitterAPIUrlProperties) {
        this.restTemplate = restTemplate;
        this.twitterAPITokenProperties = twitterAPITokenProperties;
        this.twitterAPIUrlProperties = twitterAPIUrlProperties;
    }

    @Override
    public TwitterVerifyCredentialsResponse fetchAPI(String oauthToken, String oauthSecretToken) {
        TwitterVerifyCredentialsRequest request = new TwitterVerifyCredentialsRequest(twitterAPITokenProperties,
                twitterAPIUrlProperties, oauthToken, oauthSecretToken);
        
        TwitterVerifyCredentialsResponse responese= restTemplate.exchange(request.getRequetEntity(), TwitterVerifyCredentialsResponse.class).getBody();
        return responese;
    }

}
