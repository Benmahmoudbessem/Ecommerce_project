package org.example.ecommerce.service;

import org.example.ecommerce.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
      CategoryRepository categoryRepository;

    public Category createCategory(Category category) {return categoryRepository.save(category);}
    public List<Category> getAllCategory() { return categoryRepository.findAll();}
    public Category getCategoryByID(int id){return categoryRepository.findById(id).get();}
    public Category UpdateCategory(Category category){return categoryRepository.saveAndFlush(category);}
    public void deleteCategory(int id){ categoryRepository.deleteById(id);}

}