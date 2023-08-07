package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menuAtendimento")
    public String menu(Model model){
        model.addAttribute("pacientes", new Paciente());
        return "menuAtendimento";
    }
}
