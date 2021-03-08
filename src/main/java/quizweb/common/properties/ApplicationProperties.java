package quizweb.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${callback_url}")
    private String callbackUrl;

    
    public String getCallbackUrl() {
        return callbackUrl;
    }
    

}
