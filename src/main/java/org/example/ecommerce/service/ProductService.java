package org.example.ecommerce.service;

import org.example.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {return productRepository.save(product);}
    public List<Product> getAllProduct(){ return productRepository.findAll();}
    public  Product getProductByID(int id){return productRepository.findById(id).get();}
    public Product UpdateProduct(Product product){return productRepository.saveAndFlush(product);}
    public void deleteProduct(int id){ productRepository.deleteById( id);}
}
