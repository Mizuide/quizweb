package quizweb.instruct.valueobject.response;

import org.junit.jupiter.api.Test;

import quizweb.domain.instruct.valueobject.response.TwitterRequestTokenResponse;

public class TwitterRequestTokenResponseTest {
    @Test
    public void constructerTest(){
        TwitterRequestTokenResponse target = new TwitterRequestTokenResponse(
                "oauth_token=Z6eEdO8MOmk394WozF5oKyuAv855l4Mlqo7hhlSLik&oauth_token_secret=Kd75W4OQfb2oJTV0vzGzeXftVAwgMnEK9MumzYcM&oauth_callback_confirmed=true");
        System.out.println(target.toString());
    }    
}
