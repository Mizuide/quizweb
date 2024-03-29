package quizweb.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.repository.entity.User;
import quizweb.domain.servrice.FindOrResisterUserService;

@Controller
public class LoginController {

    FindOrResisterUserService findOrResisterUserSevice;

    @Autowired
    public LoginController(FindOrResisterUserService findOrResisterUserSevice) {
        this.findOrResisterUserSevice = findOrResisterUserSevice;
    }

    @GetMapping("/login")
    @ResponseBody
    public User login(Model model) {
        TwitterUser twitterUser = (TwitterUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = findOrResisterUserSevice.findOrResisterUserByTwitteUser(twitterUser);

        return user;
    }

}
