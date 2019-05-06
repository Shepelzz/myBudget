package com.myBudget.dao.impl;

import com.myBudget.dao.CategoryDAO;
import com.myBudget.entity.Category;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

@Log4j
@Repository
public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements CategoryDAO {
}
