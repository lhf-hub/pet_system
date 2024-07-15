package com.three.server.service.impl;

import com.three.server.entity.Customer;
import com.three.server.mapper.CustomerMapper;
import com.three.server.service.CustomerService;
import com.three.server.common.uploadAndGenerateUrl.AliyunOssService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final AliyunOssService aliyunOssService;

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }

    @Override
    public int deleteCustomerById(Integer id) {
        return customerMapper.deleteCustomerById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    @Override
    public Customer selectCustomerById(Integer id) {
        return customerMapper.selectCustomerById(id);
    }

    @Override
    public Customer selectCustomerByUsername(String username) {
        return customerMapper.selectCustomerByUsername(username);
    }

    @Override
    public List<Customer> selectCustomerByNameAndPhone(String name, String phone) {
        return customerMapper.selectCustomerByNameAndPhone(name,phone);
    }

    @Override
    public String uploadCustomerAvatar(MultipartFile avatar, Integer id) {
        if (avatar == null || id == null) {
            throw new IllegalArgumentException("头像和Id必须不为空");
        }
        try {
            String theUrl = aliyunOssService.start(avatar);
            Map<String, Object> params = new HashMap<>();
            params.put("theUrl", theUrl);
            params.put("id", id);
            int res = customerMapper.saveCustomerAvatarUrl(params);
            if (res >= 1) {
                return theUrl;
            }
        } catch (Exception e) {
            // 简单的异常处理，可以改成其他处理方式，比如打印错误信息
            e.printStackTrace();
            throw new RuntimeException("Error uploading customer avatar", e);
        }
        return null;
    }
}
