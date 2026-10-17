package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Triển khai nghiệp vụ khách hàng bằng Map tĩnh thay cho cơ sở dữ liệu.
 */
public class CustomerServiceImpl implements CustomerService {

    private static final Map<Integer, Customer> customers =
            new LinkedHashMap<>();

    private static final AtomicInteger nextId = new AtomicInteger(6);

    static {
        customers.put(1, new Customer(
                1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(
                2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(
                3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(
                4, "Adam", "adam@codegym.vn", "Beijing"));
        customers.put(5, new Customer(
                5, "Sophia", "sophia@codegym.vn", "Miami"));
    }

    @Override
    public synchronized List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public synchronized Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public synchronized void save(Customer customer) {
        int id = nextId.getAndIncrement();
        customer.setId(id);
        customers.put(id, customer);
    }

    @Override
    public synchronized void update(int id, Customer customer) {
        if (customers.containsKey(id)) {
            customer.setId(id);
            customers.put(id, customer);
        }
    }

    @Override
    public synchronized void remove(int id) {
        customers.remove(id);
    }
}