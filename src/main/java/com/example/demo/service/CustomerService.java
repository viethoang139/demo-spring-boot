package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer updateCustomerById(Customer customer, Long id){
        Customer cus = customerRepository.findById(id).get();
        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setEmail(customer.getEmail());
        return customerRepository.save(cus);
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }


}
