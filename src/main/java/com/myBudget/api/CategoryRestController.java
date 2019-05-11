package com.myBudget.api;

import com.myBudget.entity.Category;
import com.myBudget.model.CategoryForm;
import com.myBudget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryRestController {
    private CategoryService categoryService;
    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping(path = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @RequestMapping(path = "/category/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category getCategory(@PathVariable("categoryId") int categoryId){
        return categoryService.findById(categoryId);
    }

    @RequestMapping(path = "/category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category saveCategory(@RequestBody CategoryForm categoryForm){
        return categoryService.save(categoryForm);
    }

    @RequestMapping(path = "/category", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Category updateCategory(@RequestBody CategoryForm categoryForm){
        return categoryService.update(categoryForm);
    }

    @RequestMapping(path = "/category/{categoryId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteCategory(@PathVariable("categoryId") int categoryId){
        categoryService.delete(categoryId);
    }

}
