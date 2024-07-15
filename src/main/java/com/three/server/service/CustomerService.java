package com.three.server.service;

import com.three.server.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomerService {
    int insertCustomer(Customer customer);
    int deleteCustomerById(Integer id);
    int updateCustomer(Customer customer);
    List<Customer> findAll();
    Customer selectCustomerById(Integer id);
    Customer selectCustomerByUsername(String username);
    List<Customer> selectCustomerByNameAndPhone(String name,String phone);
    String uploadCustomerAvatar(MultipartFile avatar,Integer id);
}
