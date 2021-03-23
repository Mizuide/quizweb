package quizweb.app.servrice;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.repository.entity.User;

public interface FindOrResisterUserSevice {

    public User findOrResisterUserByTwitteUser(TwitterUser twitterUser);

}
