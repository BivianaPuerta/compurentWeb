package com.madreselva.reto1.repository;

import java.util.List;
import java.util.Optional;

import com.madreselva.reto1.model.User;
import com.madreselva.reto1.repository.crudRepository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public boolean existsEmail(String email) {
        Optional<User> usarname = userCrudRepository.findByEmail(email);
        return !usarname.isEmpty();
    }

    public Optional<User> userAuthentication (String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
