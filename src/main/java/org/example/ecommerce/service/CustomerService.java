package org.example.ecommerce.service;

import org.example.ecommerce.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {return customerRepository.save(customer);}
    public List<Customer> getAllCustomer(){ return customerRepository.findAll();}
    public Customer getCustomerByID(int id){return customerRepository.findById(id).get();}
    public Customer UpdateCustomer(Customer customer){return customerRepository.saveAndFlush(customer);}
    public void deleteCustomer(int id){ customerRepository.deleteById( id);}
}
