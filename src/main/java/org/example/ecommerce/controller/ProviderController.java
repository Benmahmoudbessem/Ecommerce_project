package org.example.ecommerce.controller;

import org.example.ecommerce.entity.Product;
import org.example.ecommerce.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.ecommerce.service.ProviderService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    ProviderService providerService;


    @RequestMapping("/addProvider")
    public String addProvider(Model model){
        Provider provider = new Provider();
        model.addAttribute("Provider1",provider);
        return "new_provider";

    }
    @RequestMapping(value = "/save_provider", method = RequestMethod.POST)
    public String saveProvider(@ModelAttribute("Provider1") Provider provider){
        providerService.createProvider(provider);
        return "redirect:/all/provider/";
    }

    @RequestMapping("/all/provider/")
    public String list(Model model){
        List<Provider> listProvider=providerService.getAllProvider();
        model.addAttribute("ListProvider",listProvider);
        return "Liste_provider";
    }
    @GetMapping("/provider/delete/{id}")
    public String deleteProvider(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        providerService.deleteProvider(id);
        return "redirect:/all/provider/";
    }
    @GetMapping("/provider/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Provider provider= (Provider) providerService.getProviderByID(id);
        model.addAttribute("provider",provider);
        return "update_provider";
    }
    @PostMapping("/provider/update/{id}")
    public String updateProvider(@PathVariable("id") int id,Provider provider){
        providerService.UpdateProvider(provider);
        return "redirect:/all/provider/";
    }
}
