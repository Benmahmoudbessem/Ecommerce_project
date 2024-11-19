package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Category;
import org.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

}
