package com.bruno13palhano.service;

import java.util.List;

public interface Service<T> {
    void insert(T model);
    void deleteById(Integer id);
    void update(T model);
    List<T> getAll();
    T getById(Integer id);
}
