package quizweb.domain.instruct.valueobject.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import quizweb.domain.instruct.valueobject.base.ResponseObject;

@JsonIgnoreProperties
public class TwitterVerifyCredentialsResponse extends ResponseObject {
 
    public TwitterVerifyCredentialsResponse(long id, String name, String profile_image_url) {
        this.id = id;
        this.name = name;
        this.profile_image_url = profile_image_url;
    }

    private long id;

    private String name;

    private String profile_image_url;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profile_image_url;
    }
}
