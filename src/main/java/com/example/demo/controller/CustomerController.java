package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(service.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer, @PathVariable Long id){
        return ResponseEntity.ok(service.updateCustomerById(customer, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Long id){
        service.deleteCustomerById(id);
        return ResponseEntity.ok("Delete customer successfully");
    }



}
