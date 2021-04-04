package quizweb.domain.servrice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import quizweb.common.properties.TwitterAPIUrlProperties;
import quizweb.domain.instruct.gateway.TwitterRequestTokenGateway;
import quizweb.domain.instruct.valueobject.response.TwitterRequestTokenResponse;
import quizweb.domain.servrice.AuthOnTwitterService;

@Service
public class AuthOnTwitterServiceImpl implements AuthOnTwitterService {

    @Autowired
    public AuthOnTwitterServiceImpl(TwitterRequestTokenGateway twitterRequestTokenGateway,TwitterAPIUrlProperties twitterAPIUrlProperties){
        this.twitterRequestTokenGateway=twitterRequestTokenGateway;
        this.twitterAPIUrlProperties=twitterAPIUrlProperties;
    }

    TwitterRequestTokenGateway twitterRequestTokenGateway;
    TwitterAPIUrlProperties twitterAPIUrlProperties;
    
    @Value("${callback_url}")
    public String callbackURL;

    @Override
    public String generateAuthURL() {
        TwitterRequestTokenResponse requestToken = twitterRequestTokenGateway.fetchAPI(callbackURL ,"");
        String authUrl = twitterAPIUrlProperties.getAuthenticate();
        String urlWithParam = authUrl + "?oauth_token="+requestToken.getOauthToken();

        return urlWithParam;
    }

    
}
