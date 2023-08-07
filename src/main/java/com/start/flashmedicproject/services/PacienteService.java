package com.start.flashmedicproject.services;

import com.start.flashmedicproject.dtos.RegisterPacienteDto;
import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.User;
import com.start.flashmedicproject.repositories.PacienteRepository;
import com.start.flashmedicproject.repositories.UserRepository;
import com.start.flashmedicproject.utilities.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UserRepository userRepository;

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
    public Paciente registerPaciente(@Valid RegisterPacienteDto registerPacienteDto){
        Paciente paciente = new Paciente();
        User user = new User();
        BeanUtils.copyProperties(registerPacienteDto, paciente);
        BeanUtils.copyProperties(registerPacienteDto, user);
        paciente.setDateRegister(LocalDateTime.now());
        User userSaved = userRepository.save(user);
        paciente.setUser(userSaved);

        return pacienteRepository.save(paciente);
    }

    //Atualizando pacientes
    public Paciente updatePaciente(Paciente paciente){
        Optional<Paciente> result = pacienteRepository.findById(paciente.getId());
        Paciente existing = result.get();
        existing.setName(paciente.getName());
        existing.setDataNascimento(paciente.getDataNascimento());
        existing.setAddress(paciente.getAddress());
        existing.setNeighborhood(paciente.getNeighborhood());
        existing.setCep(paciente.getCep());
        existing.setCity(paciente.getCity());
        existing.setState(paciente.getState());
        existing.setCountry(paciente.getCountry());
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

    //Busca usuário para coleta de informações
    public Paciente findPacienteByUser(User user){
        return pacienteRepository.findByUser(user);
    }

    //Método lógico para verificação de número de ficha
    public boolean existsNumberFicha(String fichaAtendimento){
        return pacienteRepository.existsByNumberFicha(fichaAtendimento);
    }

    //Método para gerar a ficha
    public Paciente patchNumberFicha(Paciente paciente){
        String fichaAtendimento = Utils.generateNextFicha();

        while(existsNumberFicha(fichaAtendimento)){
            fichaAtendimento = Utils.generateNextFicha();
        }

        //Atualiza o número da ficha
        paciente.setNumberFicha(fichaAtendimento);
        return pacienteRepository.save(paciente);
    }
}
