package com.myBudget.service.impl;

import com.myBudget.entity.CategoryType;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.service.CategoryTypeService;

public class CategoryTypeServiceImpl implements CategoryTypeService {
    @Override
    public CategoryType save(CategoryType categoryType) throws InternalServerError, BadRequestException {
        return null;
    }

    @Override
    public CategoryType update(CategoryType categoryType) throws InternalServerError, BadRequestException, NotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws InternalServerError {

    }

    @Override
    public CategoryType findById(Long id) throws InternalServerError, NotFoundException {
        return null;
    }
}
