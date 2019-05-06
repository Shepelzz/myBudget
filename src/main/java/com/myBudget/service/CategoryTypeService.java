package com.myBudget.service;


import com.myBudget.entity.CategoryType;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.model.CategoryTypeForm;

import java.util.List;

public interface CategoryTypeService {

    CategoryType save(CategoryTypeForm categoryTypeForm) throws InternalServerError, BadRequestException;
    CategoryType update(CategoryTypeForm categoryTypeForm) throws InternalServerError, BadRequestException, NotFoundException;
    void delete(int id) throws InternalServerError;
    CategoryType findById(int id) throws InternalServerError, NotFoundException;
    List<CategoryType> getAll() throws InternalServerError;

}
