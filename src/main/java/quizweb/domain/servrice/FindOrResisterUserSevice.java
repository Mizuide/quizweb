package quizweb.domain.servrice;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.repository.entity.User;

public interface FindOrResisterUserSevice {

    public User findOrResisterUserByTwitteUser(TwitterUser twitterUser);

}
