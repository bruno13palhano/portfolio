package com.bruno13palhano;

import java.util.List;

public interface Repository<T> {
    void insert(T model);
    void deleteById(Integer id);
    void update(T model);
    List<T> getAll();
    T getById(Integer id);
}
