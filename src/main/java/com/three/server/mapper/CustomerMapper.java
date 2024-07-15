package com.three.server.mapper;

import com.three.server.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {
    int insertCustomer(Customer customer);
    int deleteCustomerById(Integer id);
    int updateCustomer(Customer customer);
    List<Customer> findAll();
    Customer selectCustomerById(Integer id);
    Customer selectCustomerByUsername(String username);
    List<Customer> selectCustomerByNameAndPhone(@Param("name") String name,@Param("phone") String phone);
    int saveCustomerAvatarUrl(String theUrl,Integer id);

    int saveCustomerAvatarUrl(Map<String, Object> params);
}
