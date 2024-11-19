package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Category;
import org.example.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.ecommerce.service.CategoryService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/addCategory")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("Category1",category);
        return "new_category";

    }
    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("Category1") Category category){
        categoryService.createCategory(category);
        return "redirect:/all/category";
    }
    @RequestMapping("/all/category")
    public String list(Model model){
        List<Category> listCategory=categoryService.getAllCategory();
        model.addAttribute("ListCategory",listCategory);
        return "Liste_category";
    }
    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        categoryService.deleteCategory(id);
        return "redirect:/all/category";
    }
    @GetMapping("/category/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Category category= categoryService.getCategoryByID(id);
        model.addAttribute("category",category);
        return "update_category";
    }
    @PostMapping("/category/update/{id}")
    public String updateCategory(@PathVariable("id") int id,Category category ){
        categoryService.UpdateCategory(category);
        return "redirect:/all/category";
    }
}
