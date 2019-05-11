package com.myBudget.service;


import com.myBudget.entity.User;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.model.RegisterForm;

import java.util.List;

public interface UserService {

    User save(RegisterForm registerForm) throws InternalServerError, BadRequestException;
    User update(User user) throws InternalServerError, BadRequestException, NotFoundException;
    void delete(int id) throws InternalServerError;
    User findById(int id) throws InternalServerError, NotFoundException;
    List<User> getAll() throws InternalServerError;

    User login(String email, String password) throws InternalServerError, BadRequestException;

}
