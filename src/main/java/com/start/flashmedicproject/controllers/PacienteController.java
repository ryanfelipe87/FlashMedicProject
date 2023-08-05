package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.GenerateNumber;
import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.repositories.PacienteRepository;
import com.start.flashmedicproject.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Controller
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

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
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        paciente.setDateRegister(timestamp);
        pacienteService.addPaciente(paciente);

        attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");

        return "redirect:/login";
    }

    //Endpoint para validação dos dados no login e acesso a aba de menu
    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute Paciente paciente, Model model) {
        String email = paciente.getEmail();
        String password = paciente.getPassword();

        if (pacienteService.validarUsuario(email, password)) {
            // Redirecionar para a página de menu após o login bem-sucedido
            return "redirect:/menuAtendimento";
        }

        else {
            // Adicionar mensagem de erro ao modelo
            model.addAttribute("error", "Credenciais inválidas!");
            model.addAttribute("pacientes", new Paciente());
            return "login"; // Página de login
        }
    }

    @PostMapping("/ficha")
    public String updateNumberFicha(@RequestParam Long id, @RequestParam int numberFicha, Model model) {
        numberFicha = GenerateNumber.generateNextFicha();

        // Verifica se o paciente existe com o ID fornecido
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com este ID!"));

        // Atualiza o número da ficha
        paciente.setNumberFicha(numberFicha);

        // Salva a ficha atualizada no banco de dados
        pacienteRepository.save(paciente);

        model.addAttribute("numberFicha", numberFicha);
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
