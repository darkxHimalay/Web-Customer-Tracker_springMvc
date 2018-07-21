package org.himalay.springdemo.controller;

import org.himalay.springdemo.entity.Customer;
import org.himalay.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customerList=customerService.getCustomer();
        model.addAttribute("customers",customerList);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
       customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    @RequestMapping(value = "/showFormForUpdate",method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("customerId") int id,Model model){
    Customer customer=customerService.getCustomer(id);
    model.addAttribute("customer",customer);
        return "customer-form";
    }
    @GetMapping(value = "/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id,Model model){
       customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}