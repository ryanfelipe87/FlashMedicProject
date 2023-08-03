package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Opcao;
import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.User;
import com.start.flashmedicproject.repositories.OpcaoRepository;
import com.start.flashmedicproject.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    OpcaoRepository opcaoRepository;

    @Autowired
    PacienteService pacienteService;

    //Conexão com o form html
    @GetMapping("/formPaciente")
    public String formPaciente(Model model){
        model.addAttribute("paciente", new Paciente());
        return "formPaciente";
    }

    //Cria um novo paciente validando os campos
    @PostMapping("/registerPaciente")
    public String createPaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes, Model model){
        if(result.hasErrors()){
            model.addAttribute("pacientes", paciente);
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "formPaciente";
        }
        pacienteService.addPaciente(paciente);
        attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");

        return "redirect:/login";
    }

    //Endpoint para inserção dos dados no login e acesso a aba de menu
    @PostMapping("/menuAtendimento")
    public ResponseEntity<String> login(Paciente paciente){
        String email = paciente.getEmail();
        String password = paciente.getPassword();

        if (pacienteService.validarUsuario(email, password)){
            return ResponseEntity.ok("Login realizado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Crendenciais inválidas!");
        }
    }

    //Lista todos os pacientes
    @GetMapping("/pacientes/list")
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
    @PutMapping("/pacientes/update/{id}")
    public String updatePaciente(@PathVariable Long id, @ModelAttribute Paciente paciente){
        paciente.setId(id);
        pacienteService.updatePaciente(paciente);
        return "pacientes";
    }

    //Deleta paciente por id
    @DeleteMapping("/pacientes/delete/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteService.deleteById(id);
        return "pacientes";
    }
}
