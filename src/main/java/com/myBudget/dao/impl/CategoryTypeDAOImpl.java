package com.myBudget.dao.impl;

import com.myBudget.dao.CategoryTypeDAO;
import com.myBudget.entity.CategoryType;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

@Log4j
@Repository
public class CategoryTypeDAOImpl extends AbstractDAOImpl<CategoryType> implements CategoryTypeDAO {

    public CategoryTypeDAOImpl() {
        setClazz(CategoryType.class);
    }

}
