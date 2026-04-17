package com.felipegardin.database;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {

    List<T> getAll();
    Optional<T> findById(ID id);
    Optional<T> getLastRegister();
    Optional<T> add(T t);
}
