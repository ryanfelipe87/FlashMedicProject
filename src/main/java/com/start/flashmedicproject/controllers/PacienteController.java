package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.User;
import com.start.flashmedicproject.services.PacienteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    //Endpoint para setar o número da ficha na tabela paciente quando o mesmo for gerado
    @GetMapping("/ficha")
    public String updateNumberFicha(Model model, HttpSession session){
        //Salva a ficha atualizada no banco de dados
        User user = (User) session.getAttribute("user");
        Paciente pacienteSaved = pacienteService.findPacienteByUser(user);
        Paciente paciente = pacienteService.patchNumberFicha(pacienteSaved);

        model.addAttribute("numberFicha", paciente.getNumberFicha());
        return "ficha";
    }

    //Lista todos os pacientes
    @GetMapping("/perfil/list")
    public ModelAndView findAll(){
        //Renderiza para a página de index onde aparecem os dados da lista
        ModelAndView mv = new ModelAndView("login");

        //Busca dos pacientes no banco
        Iterable<Paciente> pacientes = pacienteService.findAllPaciente();
        mv.addObject("pacientes", pacientes);
        return mv;
    }

    //Edita paciente por id
    @GetMapping("/perfil/edit/{id}")
    public String EditPaciente(@PathVariable Long id, Model model) {
        Optional<Paciente> result = Optional.ofNullable(pacienteService.findPacienteById(id));
        if (result.isPresent()) {
            model.addAttribute("paciente", result.get());
            return "EditPaciente";
        } else {
            return "perfil";
        }
    }
    //Atualiza dados do paciente
    @PutMapping("/perfil/update/{id}")
    public String updatePaciente(@PathVariable Long id, @ModelAttribute Paciente paciente){
        paciente.setId(id);
        pacienteService.updatePaciente(paciente);
        return "perfil";
    }

    //Deleta paciente por id
    @DeleteMapping("/perfil/delete/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteService.deleteById(id);
        return "perfil";
    }
}
