package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Order;
import org.example.ecommerce.entity.Product;
import org.example.ecommerce.entity.Provider;
import org.example.ecommerce.entity.Subcategory;
import org.example.ecommerce.service.OrderService;
import org.example.ecommerce.service.ProviderService;
import org.example.ecommerce.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.ecommerce.service.ProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

@Autowired
    ProviderService providerService;
@Autowired
    SubcategoryService subcategoryService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        List<Provider> providerList=providerService.getAllProvider();
        List<Subcategory> subcategoryList=subcategoryService.getAllSubcategory();


        model.addAttribute("Product1",product);
        model.addAttribute("Provider",providerList);
        model.addAttribute("subcategory",subcategoryList);

        return "new_product";

    }
    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("Product1") Product product){
        productService.createProduct(product);
        return "redirect:/all";
    }
    @RequestMapping("/all")
    public String list(Model model){
        List<Product> listProducts=productService.getAllProduct();
        model.addAttribute("ListProduct",listProducts);
        return "liste_products";
    }
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);
        return "redirect:/all";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Product product= productService.getProductByID(id);
        model.addAttribute("product",product);
        return "update_product";
    }
    @PostMapping("update/{id}")
    public String updateProduct(@PathVariable("id") int id,Product product){
        productService.UpdateProduct(product);
        return "redirect:/all";
    }
}

