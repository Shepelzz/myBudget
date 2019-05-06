package com.myBudget.service;


import com.myBudget.entity.CategoryType;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;

public interface CategoryTypeService {

    CategoryType save(CategoryType categoryType) throws InternalServerError, BadRequestException;
    CategoryType update(CategoryType categoryType) throws InternalServerError, BadRequestException, NotFoundException;
    void delete(Long id) throws InternalServerError;
    CategoryType findById(Long id) throws InternalServerError, NotFoundException;

}
