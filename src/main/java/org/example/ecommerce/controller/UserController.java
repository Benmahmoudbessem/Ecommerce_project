package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Product;
import org.example.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.ecommerce.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user= new User();
        model.addAttribute("User1",user);
        return "new_user";

    }
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("User1") User user){
        userService.createUser(user);
        return "redirect:/all/user/";
    }


    @RequestMapping("/all/user/")
    public String list(Model model){
        List<User> listUsers=userService.getAllUser();
        model.addAttribute("ListUser",listUsers);
        return "Liste_user";
    }
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        userService.deleteUser(id);
        return "redirect:/all/user/";
    }
    @GetMapping("/user/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        User user = userService.getUserByID(id);
        model.addAttribute("user",user);
        return "update_user";
    }
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") int id,User user ){
        userService.UpdateUser(user);
        return "redirect:/all/user/";
    }
}
