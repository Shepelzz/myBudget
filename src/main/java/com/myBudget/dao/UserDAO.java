package com.myBudget.dao;


import com.myBudget.entity.User;
import com.myBudget.exception.InternalServerError;

public interface UserDAO extends AbstractDAO<User> {

    User getUserByEmail(String email) throws InternalServerError;
    User getUserByAuthorization(String email, String password) throws InternalServerError;

}
