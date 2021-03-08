package quizweb.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.common.properties.TwitterAPIUrlProperties;

@SpringBootTest
public class TwitterAPIUrlPropertiesTest {

    @Autowired
    TwitterAPIUrlProperties target;

    /**
     * コード値が取得できているか
     */
    @Test
    public void getPropertiesTest() {

        System.out.println(target.getRequestToken());
        // System.out.println(target.getCallbackUrl());

    }

}
