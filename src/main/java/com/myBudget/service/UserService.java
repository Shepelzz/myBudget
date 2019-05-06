package com.myBudget.service;


import com.myBudget.entity.User;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;

public interface UserService {

    User save(User user) throws InternalServerError, BadRequestException;
    User update(User user) throws InternalServerError, BadRequestException, NotFoundException;
    void delete(Long id) throws InternalServerError;
    User findById(Long id) throws InternalServerError, NotFoundException;

    User login(String email, String password) throws InternalServerError, BadRequestException;

}
