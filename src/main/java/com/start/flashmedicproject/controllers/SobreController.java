package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.Sobre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SobreController {

    public String sobre(Model model){
        model.addAttribute("sobre", new Sobre());
        model.addAttribute("paciente", new Paciente());
        return "sobre";
    }
}
