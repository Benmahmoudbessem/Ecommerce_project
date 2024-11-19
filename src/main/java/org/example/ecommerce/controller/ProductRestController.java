package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Product;
import org.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")

public class ProductRestController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return  productService.createProduct(product);
    }

}
