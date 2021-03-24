package quizweb.domain.servrice.impl;

import org.springframework.beans.factory.annotation.Autowired;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.repository.entity.User;
import quizweb.domain.repository.mapper.UserMapper;
import quizweb.domain.servrice.FindOrResisterUserSevice;

public class FindOrResisterUserSeviceimpl implements FindOrResisterUserSevice {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findOrResisterUserByTwitteUser(TwitterUser twitterUser) {
        User user = userMapper.find(twitterUser.getUserId());
        if(user == null){
            user = new User();
            user.setId(twitterUser.getUserId());
            user.setName(twitterUser.getUsername());
            user.setImageUrl(twitterUser.getImageUrl());
            
            userMapper.insert(user);

        }


        return user;
    }

}
