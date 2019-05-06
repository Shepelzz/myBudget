package com.myBudget.service.impl;

import com.myBudget.dao.CategoryTypeDAO;
import com.myBudget.entity.CategoryType;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.model.CategoryTypeForm;
import com.myBudget.service.CategoryTypeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {
    private CategoryTypeDAO categoryTypeDAO;
    @Autowired
    public CategoryTypeServiceImpl(CategoryTypeDAO categoryTypeDAO) {
        this.categoryTypeDAO = categoryTypeDAO;
    }


    @Override
    public CategoryType save(CategoryTypeForm categoryTypeForm) throws InternalServerError, BadRequestException {
        CategoryType categoryType = new CategoryType();
        categoryType.setId(categoryTypeForm.getId());
        categoryType.setName(categoryTypeForm.getName());
        return categoryTypeDAO.save(categoryType);
    }

    @Override
    public CategoryType update(CategoryTypeForm categoryTypeForm) throws InternalServerError, BadRequestException, NotFoundException {
        CategoryType categoryType = new CategoryType();
        categoryType.setId(categoryTypeForm.getId());
        categoryType.setName(categoryTypeForm.getName());
        return categoryTypeDAO.update(categoryType);
    }

    @Override
    public void delete(int id) throws InternalServerError {
        categoryTypeDAO.delete(id);
    }

    @Override
    public CategoryType findById(int id) throws InternalServerError, NotFoundException {
        return categoryTypeDAO.findById(id);
    }

    @Override
    public List<CategoryType> getAll() throws InternalServerError {
        return categoryTypeDAO.getAll();
    }
}
