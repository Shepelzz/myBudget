package com.myBudget.service.impl;

import com.myBudget.dao.CategoryDAO;
import com.myBudget.entity.Category;
import com.myBudget.entity.CategoryType;
import com.myBudget.exception.BadRequestException;
import com.myBudget.exception.InternalServerError;
import com.myBudget.exception.NotFoundException;
import com.myBudget.model.CategoryForm;
import com.myBudget.service.CategoryService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;
    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    @Override
    public Category save(CategoryForm categoryForm) throws InternalServerError, BadRequestException {
        Category category = new Category();
        category.setName(categoryForm.getName());

        CategoryType categoryType = new CategoryType();
        categoryType.setId(1);
        category.setCategoryType(categoryType);

        return categoryDAO.save(category);
    }

    @Override
    public Category update(CategoryForm categoryForm) throws InternalServerError, BadRequestException, NotFoundException {
        Category category = new Category();
        category.setId(categoryForm.getId());
        category.setName(categoryForm.getName());
        category.setCategoryType(categoryForm.getCategoryType());

        return categoryDAO.update(category);
    }

    @Override
    public void delete(int id) throws InternalServerError {
        categoryDAO.delete(id);
    }

    @Override
    public Category findById(int id) throws InternalServerError, NotFoundException {
        return categoryDAO.findById(id);
    }

    @Override
    public List<Category> getAll() throws InternalServerError {
        return categoryDAO.getAll();
    }
}
