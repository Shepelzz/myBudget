package com.myBudget.dao;


import com.myBudget.entity.AbstractEntity;
import com.myBudget.exception.InternalServerError;

import java.util.List;

public interface AbstractDAO<T extends AbstractEntity> {

    T save(T t) throws InternalServerError;
    T update(T t) throws InternalServerError;
    void delete(int id) throws InternalServerError;
    T findById(int id) throws InternalServerError;
    List<T> getAll() throws InternalServerError;

}
