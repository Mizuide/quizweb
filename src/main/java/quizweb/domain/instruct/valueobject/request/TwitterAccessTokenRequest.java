package quizweb.domain.instruct.valueobject.request;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import quizweb.common.enums.HttpRequestMethodEnum;
import quizweb.common.enums.OAuthAttrsEnum;
import quizweb.common.properties.TwitterAPITokenProperties;
import quizweb.common.properties.TwitterAPIUrlProperties;
import quizweb.domain.instruct.valueobject.TwitterOAuthHeader;
import quizweb.domain.instruct.valueobject.base.RequestObject;

public class TwitterAccessTokenRequest extends RequestObject {
    private TwitterOAuthHeader twitterOAuthHeader;
    private RequestEntity<MultiValueMap<String, String>> requestEntity;

    public TwitterAccessTokenRequest(TwitterAPITokenProperties twitterAPITokenProperties,
            TwitterAPIUrlProperties twitterAPIUrlProperties, String oauthToken, String oauthVerifier) {
        this.httpMethod = HttpRequestMethodEnum.POST;
        this.url = twitterAPIUrlProperties.getAccessToken();
        setParamOauthVerifier(oauthVerifier);
        createOAuthHeader(twitterAPITokenProperties, oauthToken);
        createRequestEntity();
    }

    private void setParamOauthVerifier(String oauthVerifier){
        param.put("oauth_verifier", oauthVerifier);
    }

    private void createOAuthHeader(TwitterAPITokenProperties twitterAPITokenProperties, String oauthToken) {
        twitterOAuthHeader = new TwitterOAuthHeader(twitterAPITokenProperties, this.httpMethod, this.url);
        twitterOAuthHeader.addOauthParametor(OAuthAttrsEnum.oauth_token, oauthToken);
        twitterOAuthHeader.createSignature(param, "");
    }

    private void createRequestEntity() {
        MultiValueMap<String,String> reqParam = new LinkedMultiValueMap<>();

        param.entrySet().forEach(e -> reqParam.add(e.getKey(), e.getValue()));
        requestEntity = RequestEntity.post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header("Authorization", twitterOAuthHeader.toString()).body(reqParam);
    }

    public RequestEntity<MultiValueMap<String, String>> getRequetEntity() {
        return requestEntity;
    }

}
