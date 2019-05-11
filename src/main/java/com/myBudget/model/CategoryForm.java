package com.myBudget.model;

import com.myBudget.dao.CategoryDAO;
import com.myBudget.dao.CategoryTypeDAO;
import com.myBudget.entity.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter @Setter
public class CategoryForm {
    private int id;
    private String name;
    private CategoryType categoryType;


}
