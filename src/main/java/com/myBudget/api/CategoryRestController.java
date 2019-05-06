package com.myBudget.api;

import com.myBudget.entity.Category;
import com.myBudget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryRestController {
    private CategoryService categoryService;
    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping(path = "/category/save", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> saveMessage(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(path = "/category/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> editMessage(@RequestBody Category category){
        categoryService.update(category);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(path = "/category/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMessage(@RequestParam Long categoryId){
        categoryService.delete(categoryId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(path = "/category/get", method = RequestMethod.GET)
    public ResponseEntity<?> getMessages(@RequestParam Long categoryId){
        return new ResponseEntity<>(categoryService.findById(categoryId), HttpStatus.OK);
    }
}
