package com.crudCustomer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customers> listAll() {
        return repo.findAll();
    }

    public void save(Customers customer) {
        repo.save(customer);
    }

    public Customers get(Integer cust_id) {
        return repo.findById(cust_id).get();
    }

    public void delete(Integer cust_id) {
        repo.deleteById(cust_id);
    }

}
