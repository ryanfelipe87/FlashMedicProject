package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    //Exibe um novo formulário
    @GetMapping("/registerPaciente")
    public String form(){
        return "flash/formPaciente";
    }

    //Cria um novo paciente validando os campos
    @PostMapping("/registerPaciente")
    public String createPaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/registerPaciente";
        }
        pacienteService.addPaciente(paciente);
        attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");
        return "redirect:/registerPaciente";
    }

    //Lista todos os pacientes
    @GetMapping("/pacientes")
    public ModelAndView findAll(){
        //Renderiza para a página de index onde aparecem os dados da lista
        ModelAndView mv = new ModelAndView("login");

        //Busca dos pacientes no banco
        Iterable<Paciente> pacientes = pacienteService.findAllPaciente();
        mv.addObject("pacientes", pacientes);
        return mv;
    }

    //Edita paciente por id
    @GetMapping("/pacientes/edit/{id}")
    public String EditPaciente(@PathVariable Long id, Model model) {
        Optional<Paciente> result = Optional.ofNullable(pacienteService.findPacienteById(id));
        if (result.isPresent()) {
            model.addAttribute("paciente", result.get());
            return "EditPaciente";
        } else {
            return "pacientes";
        }
    }
    //Atualiza dados do paciente
    @PostMapping("/pacientes/edit/{id}")
    public String updatePaciente(@PathVariable Long id, @ModelAttribute Paciente paciente){
        paciente.setId(id);
        pacienteService.updatePaciente(paciente);
        return "pacientes";
    }

    //Deleta paciente por id
    @DeleteMapping("pacientes/delete/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteService.deleteById(id);
        return "pacientes";
    }
}
