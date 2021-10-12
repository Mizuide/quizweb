package quizweb.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${callback_url}")
    private String callbackUrl;

    @Value("${image_thumbnail_path}")
    private String imageThumbnailPath;

    @Value("${image_choice_path}")
    private String imageChoicelPath;
    
    public String getCallbackUrl() {
        return callbackUrl;
    }
    
    public String getImageThumbnailPath(){
        return imageThumbnailPath;
    }

    public String getImageChoicePath(){
        return imageChoicelPath;
    }

}
