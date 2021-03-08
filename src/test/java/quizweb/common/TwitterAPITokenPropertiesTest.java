package quizweb.common;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.common.properties.TwitterAPITokenProperties;

@SpringBootTest
public class TwitterAPITokenPropertiesTest {
   
    @Autowired
    TwitterAPITokenProperties target;

    /**
    * コード値が取得できているか
    */
@Test
public void getPropertiesTest(){


    assertNotNull(target.getAPIKey());
    assertNotNull(target.getAPIKeySecret());
    System.out.println(target.getAPIKey());
    System.out.println(target.getAPIKeySecret());


}

}
