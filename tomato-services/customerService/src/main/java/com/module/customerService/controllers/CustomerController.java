package com.module.customerService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.module.customerService.dtos.CustomerDto;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    private List<CustomerDto> customers = Arrays.asList(
            new CustomerDto(1, "Joe Bloggs","joe@gmail.com"),
            new CustomerDto(2, "Jane Doe","jane@gmail.com"));
    @GetMapping("/getCustomers")
    public List<CustomerDto> getAllCustomers() {
        return customers;
    }
    @GetMapping("getCustomer/{id}")
    public CustomerDto getCustomerById(@PathVariable int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
