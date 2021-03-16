package it.academy.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private static final Logger log =
            LoggerFactory.getLogger(HomeController.class.getName());

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/")
    public String checkLogin(){

        return "redirect:/document/all/";
    }

}
