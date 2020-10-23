package com.example.crud.controller;

import com.example.crud.model.Customer;
import com.example.crud.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String findAll(Model model ){
        Iterable<Customer> customers =customerService.findAll();
        model.addAttribute("customers",customers);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/create/")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return  "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer);
        }
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.remove(id);
        return "redirect:/customers";
    }


}
