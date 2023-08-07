package com.start.flashmedicproject.controllers;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.User;
import com.start.flashmedicproject.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //Conexão de dados com a view
    @GetMapping("/login")
    public String login(final Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    //Faz a validação de usuário
    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute User user, Model model, HttpSession session){

        User userByEmail = userService.findUserByEmail(user.getEmail());

        if (userByEmail != null && userByEmail.getPassword().equals(user.getPassword())){
            model.addAttribute("pacientes", new Paciente());
            session.setAttribute("user", userByEmail);

            //Redirecionar para a página de menu após o login bem-sucedido
            return "redirect:/menuAtendimento";
        } else{
            //Adicionar mensagem de erro ao modelo
            model.addAttribute("error_login", "Credenciais inválidas");
            model.addAttribute("pacientes", new Paciente());
            return "login"; //Página de login
        }
    }
}
