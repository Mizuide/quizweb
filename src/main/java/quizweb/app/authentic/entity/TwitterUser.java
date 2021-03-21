package quizweb.app.authentic.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import quizweb.domain.instruct.valueobject.response.TwitterVerifyCredentialsResponse;

/**
 * SpringSecurityのユーザ詳細クラスを継承。 現段階(第1要件)ではtwitter認証のみなのでユーザー名およびユーザーIDのみを定義する。
 * 各種アカウントロックなどは別途検討
 */
public class TwitterUser implements UserDetails {

    public TwitterUser(TwitterVerifyCredentialsResponse twitterVerifyCredentialsResponse) {
        this.username = twitterVerifyCredentialsResponse.getName();
        this.userId = twitterVerifyCredentialsResponse.getId();
        this.imageUrl = twitterVerifyCredentialsResponse.getProfileImageUrl();
    }

    private static final long serialVersionUID = 1L;

    private String username;

    private String imageUrl;

    private long userId;

    public String getImageUrl() {
        return imageUrl;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 使用しない
        return null;
    }

    @Override
    public String getPassword() {
        // 使用しない
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 使用しない
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 使用しない
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 使用しない
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 使用しない
        return true;
    }

}
