package com.myBudget.dao.impl;

import com.myBudget.dao.UserDAO;
import com.myBudget.entity.User;
import com.myBudget.exception.InternalServerError;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j
@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {
    private static final String SQL_GET_USER_BY_EMAIL = "SELECT u FROM User u WHERE email = :email";
    private static final String SQL_GET_USER_BY_AUTH = "SELECT u FROM User u WHERE email = :email AND password = :password";

    public UserDAOImpl() {
        setClazz(User.class);
    }

    @Override
    public User getUserByEmail(String email) throws InternalServerError {
        try {
            User result = null;
            List<User> userList = entityManager.createQuery(SQL_GET_USER_BY_EMAIL, User.class)
                    .setParameter("email", email)
                    .getResultList();
            if(userList != null && userList.size() > 0)
                result = userList.get(0);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
    }

    @Override
    public User getUserByAuthorization(String email, String password) throws InternalServerError{
        try {
            User result = null;
            List<User> userList = entityManager.createQuery(SQL_GET_USER_BY_AUTH, User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultList();
            if(userList != null && userList.size() > 0)
                result = userList.get(0);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new InternalServerError(e.getMessage(), e.getCause());
        }
    }
}
