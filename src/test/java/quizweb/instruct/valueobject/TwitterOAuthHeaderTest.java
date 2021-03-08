package quizweb.instruct.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import quizweb.TestUtil;
import quizweb.common.enums.HttpRequestMethodEnum;
import quizweb.common.properties.TwitterAPITokenProperties;
import quizweb.domain.instruct.valueobject.TwitterOAuthHeader;

@SpringBootTest
@SuppressWarnings("all")
public class TwitterOAuthHeaderTest {

    @SpyBean
    TwitterAPITokenProperties properties;

    TwitterOAuthHeader target;

    @BeforeEach
    public void prepareForEach() {
        doReturn("xvz1evFS4wEEPTGEFPHBog").when(properties).getAPIKey();
        doReturn("kAcSOqF21Fu85e7zjz7ZN2U4ZRhfV3WpwPAoE3Z7kBw").when(properties).getAPIKeySecret();
        target = new TwitterOAuthHeader(properties, HttpRequestMethodEnum.POST,
                "https://api.twitter.com/1.1/statuses/update.json");

    }

    public SortedMap<String, String> createOAuthMap() {
        SortedMap<String, String> param = new TreeMap<>();

        param.put("oauth_consumer_key", "xvz1evFS4wEEPTGEFPHBog");
        param.put("oauth_nonce", "kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg");
        param.put("oauth_signature_method", "HMAC-SHA1");
        param.put("oauth_timestamp", "1318622958");
        param.put("oauth_token", "370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb");
        param.put("oauth_version", "1.0");

        return param;
    }

    public SortedMap<String, String> createParamMap() {

        SortedMap<String, String> paramMap = new TreeMap<>();

        paramMap.put("include_entities", "true");
        paramMap.put("status", "Hello Ladies + Gentlemen, a signed OAuth request!");

        return paramMap;

    }

    public SortedMap<String, String> createParam() {
        
        SortedMap<String, String> oAuthMap = createOAuthMap();
        SortedMap<String, String> paramMap = createParamMap();
        oAuthMap.putAll(paramMap);

        return oAuthMap;

    }


    @Test
    public void collectingParametersTest() {

        Map<String, String> param = createParam();
        Object[] args = { param };
        Class[] arrgsClass = { Map.class };
        String acctual = (String) TestUtil.doPrivateMethod(target, "collectingParameters", args, arrgsClass);
        String expected = "include_entities=true&oauth_consumer_key=xvz1evFS4wEEPTGEFPHBog&oauth_nonce=kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1318622958&oauth_token=370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb&oauth_version=1.0&status=Hello%20Ladies%20%2B%20Gentlemen%2C%20a%20signed%20OAuth%20request%21";
        assertEquals(expected, acctual);
    }

    @Test
    public void creatingSignatureValueTest() {
        String baseURL = "https://api.twitter.com/1.1/statuses/update.json";

        Map<String, String> param = createParam();

        Object[] args = { HttpRequestMethodEnum.POST, baseURL, param };
        Class[] argsClass = { HttpRequestMethodEnum.POST.getClass(), String.class, Map.class };

        String acctual = (String) TestUtil.doPrivateMethod(target, "createSignatureValue", args, argsClass);

        String expected = "POST&https%3A%2F%2Fapi.twitter.com%2F1.1%2Fstatuses%2Fupdate.json&include_entities%3Dtrue%26oauth_consumer_key%3Dxvz1evFS4wEEPTGEFPHBog%26oauth_nonce%3DkYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1318622958%26oauth_token%3D370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb%26oauth_version%3D1.0%26status%3DHello%2520Ladies%2520%252B%2520Gentlemen%252C%2520a%2520signed%2520OAuth%2520request%2521";
        assertEquals(expected, acctual);

    }

    @Test
    public void creatingSignatureKey() {
        String consumerSecret = "kAcSOqF21Fu85e7zjz7ZN2U4ZRhfV3WpwPAoE3Z7kBw";
        String oAuthTokenSecret = "LswwdoUaIvS8ltyTt5jkRh4J50vUPVVHtR2YPi5kE";

        Object[] args = { consumerSecret, oAuthTokenSecret };
        Class[] argsClass = { String.class, String.class };

        String acctual = (String) TestUtil.doPrivateMethod(target, "createSignatureKey", args, argsClass);
        String expected = "kAcSOqF21Fu85e7zjz7ZN2U4ZRhfV3WpwPAoE3Z7kBw&LswwdoUaIvS8ltyTt5jkRh4J50vUPVVHtR2YPi5kE";
        assertEquals(expected, acctual);
    }

    @Test
    public void calculateSignatureTest() {
        String value = "POST&https%3A%2F%2Fapi.twitter.com%2F1.1%2Fstatuses%2Fupdate.json&include_entities%3Dtrue%26oauth_consumer_key%3Dxvz1evFS4wEEPTGEFPHBog%26oauth_nonce%3DkYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1318622958%26oauth_token%3D370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb%26oauth_version%3D1.0%26status%3DHello%2520Ladies%2520%252B%2520Gentlemen%252C%2520a%2520signed%2520OAuth%2520request%2521";
        String key = "kAcSOqF21Fu85e7zjz7ZN2U4ZRhfV3WpwPAoE3Z7kBw&LswwdoUaIvS8ltyTt5jkRh4J50vUPVVHtR2YPi5kE";

        Object[] args = { key, value };
        Class[] argsClass = { String.class, String.class };

        String acctual = (String) TestUtil.doPrivateMethod(target, "calculateSignature", args, argsClass);
        String expected = "hCtSmYh+iHYCEqBWrE7C7hYmtUk=";
        assertEquals(expected, acctual);

    }

    /**
     * 結合テスト
     */
    @Test
    public void toStringTest() {
        TestUtil.setPrivateField(target, "oAuthParam", createOAuthMap());
        target.createSignature(createParamMap(), "LswwdoUaIvS8ltyTt5jkRh4J50vUPVVHtR2YPi5kE");

        String expected = "OAuth oauth_consumer_key=\"xvz1evFS4wEEPTGEFPHBog\", oauth_nonce=\"kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg\", oauth_signature=\"hCtSmYh%2BiHYCEqBWrE7C7hYmtUk%3D\", oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=\"1318622958\", oauth_token=\"370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb\", oauth_version=\"1.0\"";
        String actual = target.toString();

        assertEquals(expected, actual);

    }

}
