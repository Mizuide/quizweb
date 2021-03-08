package quizweb.domain.instruct.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import quizweb.common.properties.TwitterAPITokenProperties;
import quizweb.common.properties.TwitterAPIUrlProperties;
import quizweb.domain.instruct.gateway.TwitterRequestTokenGateway;
import quizweb.domain.instruct.valueobject.request.TwitterRequestTokenRequest;
import quizweb.domain.instruct.valueobject.response.TwitterRequestTokenResponse;

@Component
public class TwitterRequestTokenGatewayImpl implements TwitterRequestTokenGateway {
    private RestTemplate restTemplate;
    private TwitterAPITokenProperties twitterAPITokenProperties;
    private TwitterAPIUrlProperties twitterAPIUrlProperties;


    @Autowired
    public TwitterRequestTokenGatewayImpl(RestTemplate restTemplate,
            TwitterAPITokenProperties twitterAPITokenProperties, TwitterAPIUrlProperties twitterAPIUrlProperties) {
        this.restTemplate = restTemplate;
        this.twitterAPITokenProperties=twitterAPITokenProperties;
        this.twitterAPIUrlProperties=twitterAPIUrlProperties;
    }

    @Override
    public TwitterRequestTokenResponse fetchAPI(String oAuthCallback,String xAuthAccessType) {
        TwitterRequestTokenRequest request = new TwitterRequestTokenRequest(twitterAPITokenProperties, twitterAPIUrlProperties, oAuthCallback);
        ResponseEntity<String> responseEntity = restTemplate.exchange(request.getRequetEntity(), String.class);
        
        TwitterRequestTokenResponse response = new TwitterRequestTokenResponse(responseEntity.getBody());
        return response;
    }
    
}
