package com.myBudget.service.impl;

import com.myBudget.dao.CategoryDAO;
import com.myBudget.entity.Category;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.service.CategoryService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;
    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    @Override
    public Category save(Category category) throws InternalServerError, BadRequestException {
        return categoryDAO.save(category);
    }

    @Override
    public Category update(Category category) throws InternalServerError, BadRequestException, NotFoundException {
        return categoryDAO.update(category);
    }

    @Override
    public void delete(Long id) throws InternalServerError {
        categoryDAO.delete(id);
    }

    @Override
    public Category findById(Long id) throws InternalServerError, NotFoundException {
        return categoryDAO.findById(id);
    }
}
