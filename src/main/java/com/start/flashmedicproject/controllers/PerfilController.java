package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.Perfil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String profile(Model model){
        model.addAttribute("perfil", new Perfil());
        model.addAttribute("paciente", new Paciente());
        return "perfil";
    }
}
