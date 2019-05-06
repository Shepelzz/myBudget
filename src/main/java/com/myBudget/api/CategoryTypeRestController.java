package com.myBudget.api;

import com.myBudget.entity.CategoryType;
import com.myBudget.service.CategoryTypeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
public class CategoryTypeRestController {
    private CategoryTypeService categoryTypeService;
    @Autowired
    public CategoryTypeRestController(CategoryTypeService categoryTypeService) {
        this.categoryTypeService = categoryTypeService;
    }


    @RequestMapping(path = "/category-type/save", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> saveMessage(@RequestBody CategoryType categoryType){
//        categoryTypeService.save(categoryType);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(path = "/category-type/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> editMessage(@RequestBody CategoryType categoryType){
//        categoryTypeService.update(categoryType);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(path = "/category-type/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMessage(@RequestParam int categoryTypeId){
        categoryTypeService.delete(categoryTypeId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(path = "/category-type/get", method = RequestMethod.GET)
    public ResponseEntity<?> getMessages(@RequestParam int categoryTypeId){
        return new ResponseEntity<>(categoryTypeService.findById(categoryTypeId), HttpStatus.OK);
    }

}
