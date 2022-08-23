package com.crudCustomer.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {

    private Integer cust_id;
    private String cust_name;
    private String cust_address;

    public Customers() {

    }

    public Customers(Integer cust_id, String cust_name, String cust_address) {
        super();
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_address = cust_address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }


}
