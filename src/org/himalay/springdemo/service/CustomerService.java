package org.himalay.springdemo.service;

import org.himalay.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomer();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);

}
