package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Provider;
import org.example.ecommerce.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.ecommerce.service.SubcategoryService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;


    @RequestMapping("/addSubcategory")
    public String addSubcategory(Model model){
        Subcategory subcategory = new Subcategory();
        model.addAttribute("Subcategory1",subcategory);
        return "new_subcategory";

    }
    @RequestMapping(value = "/save_subcategory", method = RequestMethod.POST)
    public String saveSubcategory(@ModelAttribute("Subcategory1") Subcategory subcategory){
        subcategoryService.createSubcategory(subcategory);
        return "redirect:/all/subcategory";
    }

    @RequestMapping("/all/subcategory")
    public String list(Model model){
        List<Subcategory> listSubcategory=subcategoryService.getAllSubcategory();
        model.addAttribute("ListSubcategory",listSubcategory);
        return "Liste_subcategory";
    }
    @GetMapping("/subcategory/delete/{id}")
    public String deleteSubcategory(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        subcategoryService.deleteSubcategory(id);
        return "redirect:/all/subcategory";
    }
    @GetMapping("/subcategory/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Subcategory subcategory =  subcategoryService.getSubcategoryByID(id);
        model.addAttribute("subcategory",subcategory);
        return "update_subcategory";
    }
    @PostMapping("/subcategory/update/{id}")
    public String updateSubcategory(@PathVariable("id") int id,Subcategory subcategory ){
        subcategoryService.UpdateSubcategory(subcategory);
        return "redirect:/all/subcategory";
    }
}
