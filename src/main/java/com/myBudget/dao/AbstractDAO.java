package com.myBudget.dao;


import com.myBudget.entity.AbstractEntity;
import com.myBudget.exception.InternalServerError;

public interface AbstractDAO<T extends AbstractEntity> {

    T save(T t) throws InternalServerError;
    T update(T t) throws InternalServerError;
    void delete(Long id) throws InternalServerError;
    T findById(Long id) throws InternalServerError;

}
