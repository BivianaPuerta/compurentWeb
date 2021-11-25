package com.madreselva.reto1.service;


import java.util.List;
import java.util.Optional;

import com.madreselva.reto1.model.User;
import com.madreselva.reto1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User register(User user) {
        if (user.getId() == null) {
            if (existsEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existsEmail(String email) {
        return userRepository.existsEmail(email);
    }



    public User userAuthentication(String email, String password) {
        Optional<User> usarname = userRepository.userAuthentication(email, password);

        if (usarname.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usarname.get();
        }
    }

}
