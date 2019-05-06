package com.myBudget.service.impl;

import com.myBudget.dao.CategoryTypeDAO;
import com.myBudget.entity.CategoryType;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.service.CategoryTypeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {
    private CategoryTypeDAO categoryTypeDAO;
    @Autowired
    public CategoryTypeServiceImpl(CategoryTypeDAO categoryTypeDAO) {
        this.categoryTypeDAO = categoryTypeDAO;
    }


    @Override
    public CategoryType save(CategoryType categoryType) throws InternalServerError, BadRequestException {
        return categoryTypeDAO.save(categoryType);
    }

    @Override
    public CategoryType update(CategoryType categoryType) throws InternalServerError, BadRequestException, NotFoundException {
        return categoryTypeDAO.update(categoryType);
    }

    @Override
    public void delete(Long id) throws InternalServerError {
        categoryTypeDAO.delete(id);
    }

    @Override
    public CategoryType findById(Long id) throws InternalServerError, NotFoundException {
        return categoryTypeDAO.findById(id);
    }
}
