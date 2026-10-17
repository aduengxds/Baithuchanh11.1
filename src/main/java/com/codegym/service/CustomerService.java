package com.codegym.service;

import com.codegym.model.Customer;
import java.util.List;

/**
 * Khai báo các nghiệp vụ quản lý khách hàng.
 */
public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(int id, Customer customer);

    void remove(int id);
}