package com.fpmislata.MoviesStore.persistence.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    List<T> getAll();
    List<T> getAll(int page, int size);
    Optional<T> findById(Long id);
    long insert(T t);
    void update(T t);
    void delete(Long id);
    int count();
    void save(T t);
}
