package com.myBudget.api;

import com.myBudget.entity.CategoryType;
import com.myBudget.model.CategoryTypeForm;
import com.myBudget.service.CategoryTypeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
public class CategoryTypeRestController {
    private CategoryTypeService categoryTypeService;
    @Autowired
    public CategoryTypeRestController(CategoryTypeService categoryTypeService) {
        this.categoryTypeService = categoryTypeService;
    }


    @RequestMapping(path = "/category-types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CategoryType> getAllCategoryTypes(){

        for(int i = 0; i < 100; i++){
            System.out.println(i);
        }

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
