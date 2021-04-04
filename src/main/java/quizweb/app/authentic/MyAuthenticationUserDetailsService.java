package quizweb.app.authentic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.instruct.gateway.TwitterAccessTokenGateway;
import quizweb.domain.instruct.gateway.TwitterVerifyCredentialsGateway;
import quizweb.domain.instruct.valueobject.response.TwitterAccessTokenResponse;
import quizweb.domain.instruct.valueobject.response.TwitterVerifyCredentialsResponse;

@Component
public class MyAuthenticationUserDetailsService
        implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Autowired
    TwitterAccessTokenGateway twitterAccessTokenGateway;

    @Autowired
    TwitterVerifyCredentialsGateway twitterVerifyCredentialsGateway;


    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {

        String oauthToken = (String) token.getPrincipal();
        String oauthVerifier = (String) token.getCredentials();

        TwitterAccessTokenResponse twitterAccessTokenResponse = twitterAccessTokenGateway.fetchAPI(oauthToken,
                oauthVerifier);
        
        TwitterVerifyCredentialsResponse twitterVerifyCredentialsResponse = twitterVerifyCredentialsGateway
                .fetchAPI(twitterAccessTokenResponse.getOauthToken(), twitterAccessTokenResponse.getOauthTokenSecret());

        TwitterUser twitterUser = new TwitterUser(twitterVerifyCredentialsResponse);

        return twitterUser;
    }




}
