package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Subcategory;
import org.example.ecommerce.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subcategory")
public class SubcategoryRestController {
    @Autowired
    SubcategoryService subcategoryService;
    @PostMapping("/save")
    public Subcategory saveSubcategory(@RequestBody Subcategory subcategory){
        return subcategoryService.createSubcategory(subcategory);
    }
}
