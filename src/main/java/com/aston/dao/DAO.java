package com.aston.dao;

import java.util.List;

public interface DAO<T> {
    boolean create(T value);
    List<T> getAll();
    T findById(Long id);
    boolean update(T value);
    boolean delete(T value);
}
