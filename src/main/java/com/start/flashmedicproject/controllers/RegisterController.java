package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.dtos.RegisterPacienteDto;
import com.start.flashmedicproject.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private PacienteService pacienteService;

    //Faz a conexão de dados do servidor para exibição
    @GetMapping("/formPaciente")
    public String formPaciente(Model model){
        model.addAttribute("registerPacienteDto", new RegisterPacienteDto());
        return "formPaciente";
    }

    //Registra um novo usuário
    @PostMapping("/registerPaciente")
    public String createPaciente(@Valid RegisterPacienteDto registerPacienteDto, BindingResult result, RedirectAttributes attributes, Model model){
        if(result.hasErrors()){
            model.addAttribute("registerPacienteDto", new RegisterPacienteDto());
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "formPaciente";
        }

        pacienteService.registerPaciente(registerPacienteDto);

        model.addAttribute("success_register", "Paciente cadastrado com sucesso!");
        return "redirect:/login";
    }
}
