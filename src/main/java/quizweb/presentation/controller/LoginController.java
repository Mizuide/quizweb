package quizweb.presentation.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import quizweb.app.authentic.entity.TwitterUser;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        TwitterUser twitterUser = (TwitterUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",twitterUser);
        return "login";
    }

}
