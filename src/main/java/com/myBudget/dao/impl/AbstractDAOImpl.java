package com.myBudget.dao.impl;


import com.myBudget.dao.AbstractDAO;
import com.myBudget.entity.AbstractEntity;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public abstract class AbstractDAOImpl<T extends AbstractEntity> implements AbstractDAO<T> {
    private Class<T> clazz;
    private String SQL_DELETE_BY_ID;

    @PersistenceContext
    EntityManager entityManager;

    final void setClazz( Class<T> clazzToSet ){
        this.clazz = clazzToSet;
        this.SQL_DELETE_BY_ID = "DELETE FROM "+clazz.getSimpleName()+" t WHERE t.id = :id";
    }

    @Override
    @Transactional
    public T save(T t) throws InternalServerError {
        try {
            entityManager.persist(t);
            log.info("New "+clazz.getSimpleName()+" saved with id "+t.getId());

            return t;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
    }

    @Override
    @Transactional
    public T update(T t) throws InternalServerError {
        try {
            entityManager.merge(t);
            log.info("Entity "+clazz.getSimpleName()+" with id "+t.getId()+" was updated");

            return t;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
    }

    @Override
    @Transactional
    public void delete(int id) throws InternalServerError{
        int res;
        try {
            res = entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("id", id).executeUpdate();
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
        if (res == 0) {
            log.warn("Entity "+clazz.getSimpleName() + " with id: " + id + " was not deleted");
            throw new InternalServerError("Entity "+clazz.getSimpleName() + " with id: " + id + " was not deleted");
        } else
            log.info("Entity "+clazz.getSimpleName() + " with id: " + id + " was deleted");
    }


    @Override
    public T findById(int id) throws InternalServerError{
        T t = null;
        try {
            t = entityManager.find(clazz, id);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
        if(t == null) {
            log.warn("Entity "+clazz.getSimpleName()+" with id " + id + " was not found");
            throw new NotFoundException("Entity "+clazz.getSimpleName()+" with id " + id + " was not found");
        }
        return t;
    }

    @Override
    public List<T> getAll() throws InternalServerError {
        List<T> result = new ArrayList<>();
        try{
            result = entityManager.createQuery("Select t from " + clazz.getSimpleName() + " t").getResultList();
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
        return result;
    }
}