package com.bruno13palhano.repository;

import com.bruno13palhano.Project;

import java.util.List;

public interface ProductRepository extends Repository<Project> {
    void insert(T model);
    void delete(T model);
    void deleteById(Integer id);
    void update(T model);
    List<T> getAll();
    T getById(Integer id);
}