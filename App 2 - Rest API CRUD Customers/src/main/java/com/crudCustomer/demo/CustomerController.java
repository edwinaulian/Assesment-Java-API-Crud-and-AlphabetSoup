package com.crudCustomer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository repo;

    @GetMapping("/customers")
    public List<Customers> list() {
        return service.listAll();
    }

    @GetMapping("/customers/{cust_id}")
    public ResponseEntity<Customers> get(@PathVariable Integer cust_id) {
        try {
            Customers customers =  service.get(cust_id);
            return  new ResponseEntity<Customers>(customers, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return  new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public void add(@RequestBody Customers customers) {
        service.save(customers);
    }

    @PutMapping("/customers/{cust_id}")
    public ResponseEntity<?> update (@RequestBody Customers customers, @PathVariable Integer cust_id) {
       try {
           Optional<Customers> customerData = repo.findById(cust_id);
           Customers exsistCustomers = service.get(cust_id);
           if (customerData.isPresent()) {
                Customers _customer = customerData.get();
                _customer.setCust_name(customers.getCust_name());
                _customer.setCust_address(customers.getCust_address());
                return new ResponseEntity<>(repo.save(_customer), HttpStatus.OK);
           } else {
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
       } catch (NoSuchElementException e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/customers/{cust_id}")
    public void delete(@PathVariable Integer cust_id){
        service.delete(cust_id);
    }




}
