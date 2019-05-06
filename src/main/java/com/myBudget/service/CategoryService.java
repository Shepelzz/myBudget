package com.myBudget.service;


import com.myBudget.entity.Category;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;

public interface CategoryService {

    Category save(Category category) throws InternalServerError, BadRequestException;
    Category update(Category category) throws InternalServerError, BadRequestException, NotFoundException;
    void delete(Long id) throws InternalServerError;
    Category findById(Long id) throws InternalServerError, NotFoundException;

}
