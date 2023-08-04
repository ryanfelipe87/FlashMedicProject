package com.start.flashmedicproject.services;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    //Buscando todos os pacientes
    public List<Paciente> findAllPaciente(){
        return (List<Paciente>) pacienteRepository.findAll();
    }

    //Buscando pacientes por id
    public Paciente findPacienteById(Long id){
        Optional<Paciente> result = pacienteRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Paciente();
    }

    //Inserir pacientes
    public Paciente addPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    //Verificação de login do usuário
    public boolean validarUsuario(String email, String password){
        Paciente paciente = pacienteRepository.findByEmail(email);

        return paciente != null && paciente.getPassword().equals(password);
    }

    //Atualizando pacientes
    public Paciente updatePaciente(Paciente paciente){
        Optional<Paciente> result = pacienteRepository.findById(paciente.getId());
        Paciente existing = result.get();
        existing.setName(paciente.getName());
        existing.setNascimento(paciente.getNascimento());
        existing.setAddress(paciente.getAddress());
        existing.setCellPhone(paciente.getCellPhone());
        existing.setCpf(paciente.getCpf());
        existing.setSus(paciente.getSus());
        existing.setBloodType(paciente.getBloodType());
        existing.setUser(paciente.getUser());
        return pacienteRepository.save(existing);
    }

    //Deletando por id
    public void deleteById(Long id){
        pacienteRepository.deleteById(id);
    }
}
