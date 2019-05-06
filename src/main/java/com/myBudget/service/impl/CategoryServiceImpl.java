package com.myBudget.service.impl;

import com.myBudget.entity.Category;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public Category save(Category category) throws InternalServerError, BadRequestException {
        return null;
    }

    @Override
    public Category update(Category category) throws InternalServerError, BadRequestException, NotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws InternalServerError {

    }

    @Override
    public Category findById(Long id) throws InternalServerError, NotFoundException {
        return null;
    }
}
