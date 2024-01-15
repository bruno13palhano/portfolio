package com.bruno13palhano;

public interface UserData<T extends User> {
    void insert(T user);
    void update(T user);
    void delete(Long userId);
    T getByUsername(String username);
    Boolean usernameAlreadyExist(String username);
    Boolean emailAlreadyExist(String email);
    T getByEmail(String email);
    T getById(Long userId);
}