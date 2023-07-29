package com.start.flashmedicproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    //Exibir formulário
    @RequestMapping("/")
    public String login(){
        return"login";
    }
}
