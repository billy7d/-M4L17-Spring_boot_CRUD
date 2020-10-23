package com.example.crud.controller;


import com.example.crud.model.Customer;
import com.example.crud.model.Province;
import com.example.crud.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;


    @GetMapping("")
    public String listProvinces(Model model){
        Iterable<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "province/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("province",new Province());
        return "province/create";
    }

    @PostMapping("/create")
    public String saveProvince(@ModelAttribute("province") Province province, Model model){
        provinceService.save(province);
        model.addAttribute("province", new Province());
        return "redirect:/provinces";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()) {
            model.addAttribute("province", province);

        }
        return "province/edit";
    }

    @PostMapping("/edit")
    public String updateProvince(@ModelAttribute("province") Province province, Model model){
        provinceService.save(province);
        model.addAttribute("province", province);
        return "province/edit";
    }


    @GetMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Integer id){
        provinceService.remove(id);
        return "redirect:/provinces";
    }

}
