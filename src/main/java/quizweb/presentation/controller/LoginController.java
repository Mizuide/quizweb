package quizweb.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quizweb.app.servrice.LoginWithTwitterService;

@Controller
public class LoginController {

    @Autowired
    LoginWithTwitterService loginWithTwitterService;

    @GetMapping("/login")
    public String login(@RequestParam(name = "oauth_token") String oAuthToken,
            @RequestParam(name = "oauth_verifier") String oauthVerifier, Model model) {
        loginWithTwitterService.doLogin(oAuthToken, oauthVerifier);
        
        return "login";
    }

}
