package com.myBudget.service;


import com.myBudget.entity.Category;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.model.CategoryForm;

import java.util.List;

public interface CategoryService {

    Category save(CategoryForm categoryForm) throws InternalServerError, BadRequestException;
    Category update(CategoryForm categoryForm) throws InternalServerError, BadRequestException, NotFoundException;
    void delete(int id) throws InternalServerError;
    Category findById(int id) throws InternalServerError, NotFoundException;
    List<Category> getAll() throws InternalServerError;

}
