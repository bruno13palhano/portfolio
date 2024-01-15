package com.bruno13palhano.service.impl;

import com.bruno13palhano.User;
import com.bruno13palhano.repository.UserRepository;
import com.bruno13palhano.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.delete(userId);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public Boolean usernameAlreadyExist(String username) {
        return userRepository.usernameAlreadyExist(username);
    }

    @Override
    public Boolean emailAlreadyExist(String email) {
        return userRepository.emailAlreadyExist(email);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public User getById(Integer userId) {
        return userRepository.getById(userId);
    }
}
