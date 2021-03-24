package quizweb.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import quizweb.app.authentic.entity.TwitterUser;
import quizweb.domain.repository.entity.User;
import quizweb.domain.servrice.FindOrResisterUserSevice;

@Controller
public class LoginController {

    FindOrResisterUserSevice findOrResisterUserSevice;

    @Autowired
    public LoginController(FindOrResisterUserSevice findOrResisterUserSevice) {
        this.findOrResisterUserSevice = findOrResisterUserSevice;
    }

    @GetMapping("/login")
    public String login(Model model) {
        TwitterUser twitterUser = (TwitterUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = findOrResisterUserSevice.findOrResisterUserByTwitteUser(twitterUser);

        model.addAttribute("user", user);
        return "login";
    }

}
