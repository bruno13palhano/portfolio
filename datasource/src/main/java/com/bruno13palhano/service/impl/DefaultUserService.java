package com.bruno13palhano.service.impl;

import com.bruno13palhano.User;
import com.bruno13palhano.repository.UserRepository;
import com.bruno13palhano.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User model) {
        userRepository.insert(model);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User model) {
        userRepository.update(model);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }
}
