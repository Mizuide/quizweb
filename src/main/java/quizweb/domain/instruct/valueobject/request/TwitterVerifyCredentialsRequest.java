package quizweb.domain.instruct.valueobject.request;

import java.util.Map.Entry;

import org.springframework.http.RequestEntity;

import quizweb.common.enums.HttpRequestMethodEnum;
import quizweb.common.enums.OAuthAttrsEnum;
import quizweb.common.properties.TwitterAPITokenProperties;
import quizweb.common.properties.TwitterAPIUrlProperties;
import quizweb.domain.instruct.valueobject.TwitterOAuthHeader;
import quizweb.domain.instruct.valueobject.base.RequestObject;

public class TwitterVerifyCredentialsRequest extends RequestObject {
    private TwitterOAuthHeader twitterOAuthHeader;
    private RequestEntity<Void> requestEntity;

    public TwitterVerifyCredentialsRequest(TwitterAPITokenProperties twitterAPITokenProperties,
            TwitterAPIUrlProperties twitterAPIUrlProperties, String oauthToken, String oauthSecretToken) {
        this.httpMethod = HttpRequestMethodEnum.GET;
        this.url = twitterAPIUrlProperties.getVerifyCredentials();

        createOAuthHeader(twitterAPITokenProperties, oauthToken, oauthSecretToken);

        createRequestEntity();
    }

    
    public void setParamIncludeEntities(String includeEntities) {
        param.put("include_entities", includeEntities);
    }
    
    public void setParamSkipStatus(String skipStatus) {
        param.put("skip_status", skipStatus);
    }
    
    public void setParamIncludeEmail(String includeEmail){
        param.put("include_email", includeEmail);
    }
    
    private void createOAuthHeader(TwitterAPITokenProperties twitterAPITokenProperties, String oauthToken,
    String oAuthTokenSecret) {
        twitterOAuthHeader = new TwitterOAuthHeader(twitterAPITokenProperties, this.httpMethod, this.url); 
        twitterOAuthHeader.addOauthParametor(OAuthAttrsEnum.oauth_token, oauthToken);
        twitterOAuthHeader.createSignature(param, oAuthTokenSecret);
    }
    
    private void createRequestEntity() {
        StringBuilder urlBuilder = new StringBuilder(url);
        for(Entry<String,String> e :param.entrySet()){
            urlBuilder.append("?"+e.getKey()+"="+e.getValue());
        }
        requestEntity = RequestEntity.get(url).header("Authorization", twitterOAuthHeader.toString()).build();

    }

    public RequestEntity<Void> getRequetEntity(){
        return requestEntity;
    }
}
