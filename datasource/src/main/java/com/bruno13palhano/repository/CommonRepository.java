package com.bruno13palhano.repository;

import java.util.List;

public interface CommonRepository<T> {
    void insert(T model);
    void delete(T model);
    void update(T model);
    List<T> getAll();
    T getById(Integer id);
}