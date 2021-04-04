package quizweb.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import quizweb.domain.servrice.AuthOnTwitterService;

@Controller
public class AuthController {
    @Autowired
    public AuthController(AuthOnTwitterService authOnTwitterService){
        this.authOnTwitterService = authOnTwitterService;
    }

    AuthOnTwitterService authOnTwitterService;
    
    @GetMapping("/doAuth")
    public String authOnTwitter(Model model){
        String authUrl = "redirect:" + authOnTwitterService.generateAuthURL();
        return authUrl;
    }





}
