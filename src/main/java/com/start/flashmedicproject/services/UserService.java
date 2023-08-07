package com.start.flashmedicproject.services;

import com.start.flashmedicproject.models.User;
import com.start.flashmedicproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Busca por email
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
