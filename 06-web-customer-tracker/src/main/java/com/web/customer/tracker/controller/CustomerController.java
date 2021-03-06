package com.web.customer.tracker.controller;

import com.web.customer.tracker.entity.Customer;
import com.web.customer.tracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String listOfCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("add-customer")
    public String showFormForAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("update-customer")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customer-form";
    }

    @GetMapping("delete-customer")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("search")
    public String searchCustomers(@RequestParam("theSearchName") String searchName,
                                  Model theModel) {
        theModel.addAttribute("customers", customerService.searchCustomers(searchName));
        return "list-customers";
    }
}
