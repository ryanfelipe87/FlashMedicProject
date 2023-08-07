package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.Perfil;
import com.start.flashmedicproject.models.User;
import com.start.flashmedicproject.services.PacienteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    @Autowired
    private PacienteService pacienteService;

    //Setar as informações do usuário para exibição no perfil
    @GetMapping("/perfil")
    public String profile(Model model, HttpSession session){
        model.addAttribute("perfil", new Perfil());
        User user = (User) session.getAttribute("user");
        Paciente paciente = pacienteService.findPacienteByUser(user);
        model.addAttribute("paciente", paciente);
        return "perfil";
    }
}
