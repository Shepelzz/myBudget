package com.myBudget.service.impl;

import com.myBudget.dao.UserDAO;
import com.myBudget.entity.User;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log4j
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User save(User user) throws InternalServerError, BadRequestException {
//        validateUserMainData(user);
        validateEmail(user.getEmail());

        return userDAO.save(user);
    }

    @Override
    public User update(User user) throws InternalServerError, BadRequestException{
        return userDAO.update(user);
    }

    @Override
    public void delete(int id) throws InternalServerError {
        userDAO.delete(id);
    }

    @Override
    public User findById(int id) throws InternalServerError, NotFoundException {
        return userDAO.findById(id);
    }

    @Override
    public List<User> getAll() throws InternalServerError {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public User login(String email, String password) throws InternalServerError, BadRequestException {
        User user = userDAO.getUserByAuthorization(email, password);
        if(user == null) {
            log.warn("Login fail for email "+email);
            throw new BadRequestException("Username or password is incorrect");
        }
        return user;
    }

    private void validateUserMainData(User user) throws BadRequestException{
    }

    private void validateEmail(String email) throws BadRequestException, InternalServerError {
        log.info("Start checking email ["+email+"] for existing in db");
        if(userDAO.getUserByEmail(email) != null) {
            log.warn("There is already registered user with email ["+email+"]");
            throw new BadRequestException("There is already registered user with email ["+email+"]");
        }
    }
}

