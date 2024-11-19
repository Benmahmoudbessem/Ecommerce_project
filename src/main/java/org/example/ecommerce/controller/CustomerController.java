package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Customer;
import org.example.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.ecommerce.service.CustomerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping("/addCustomer")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("Customer1",customer);
        return "new_customer";

    }
    @RequestMapping(value = "/save_customer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("Customer1") Customer customer){
        customerService.createCustomer(customer);
        return "redirect:/all/customer/";
    }

    @RequestMapping("/all/customer/")
    public String list(Model model){
        List<Customer> listCustomer=customerService.getAllCustomer();
        model.addAttribute("ListCustomer",listCustomer);
        return "Liste_customer";
    }
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        customerService.deleteCustomer(id);
        return "redirect:/all/customer/";
    }
    @GetMapping("/customer/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Customer customer = customerService.getCustomerByID(id);
        model.addAttribute("customer",customer);
        return "update_customer";
    }
    @PostMapping("/update/customer/{id}")
    public String updateCustomer(@PathVariable("id") int id,Customer customer){
        customerService.UpdateCustomer(customer);
        return "redirect:/all/customer/";
    }
}
