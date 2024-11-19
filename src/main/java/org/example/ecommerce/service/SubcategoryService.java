package org.example.ecommerce.service;

import org.example.ecommerce.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.SubcategoryRepository;

import java.util.List;

@Service
public class SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;

    public Subcategory createSubcategory(Subcategory subcategory) {return subcategoryRepository.save(subcategory);}
    public List<Subcategory> getAllSubcategory(){ return subcategoryRepository.findAll();}
    public Subcategory getSubcategoryByID(int id){return subcategoryRepository.findById(id).get();}
    public Subcategory UpdateSubcategory(Subcategory subcategory){return subcategoryRepository.saveAndFlush(subcategory);}
    public void deleteSubcategory(int id){ subcategoryRepository.deleteById( id);}
}
