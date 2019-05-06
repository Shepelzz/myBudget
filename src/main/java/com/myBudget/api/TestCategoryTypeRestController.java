package com.myBudget.api;

import com.myBudget.entity.CategoryType;
import com.myBudget.model.CategoryTypeForm;
import com.myBudget.service.CategoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestCategoryTypeRestController {
    private CategoryTypeService categoryTypeService;
    @Autowired
    public TestCategoryTypeRestController(CategoryTypeService categoryTypeService) {
        this.categoryTypeService = categoryTypeService;
    }


    @RequestMapping(path = "/category-types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CategoryType> getAllCategoryTypes(){
        return categoryTypeService.getAll();
    }

    @RequestMapping(path = "/category-type/{categoryTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CategoryType getCategoryType(@PathVariable("categoryTypeId") int categoryTypeId){
        return categoryTypeService.findById(categoryTypeId);
    }

    @RequestMapping(path = "/category-type", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CategoryType saveCategoryType(@RequestBody CategoryTypeForm categoryTypeForm){
        return categoryTypeService.save(categoryTypeForm);
    }

    @RequestMapping(path = "/category-type", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryType updateCategoryType(@RequestBody CategoryTypeForm categoryTypeForm){
        return categoryTypeService.update(categoryTypeForm);
    }

    @RequestMapping(path = "/category-type/{categoryTypeId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteCategoryType(@PathVariable("categoryTypeId") int categoryTypeId){
        categoryTypeService.delete(categoryTypeId);
    }
}
