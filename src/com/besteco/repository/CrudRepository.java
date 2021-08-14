package com.besteco.repository;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(String id);
    void saveToDatabase(T object);
    void updateDatabase(T object);
    void deleteFromDatabase(String id);

}
