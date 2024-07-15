package com.three.server.controller;

import com.auth0.jwt.JWT;
import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.entity.Customer;
import com.three.server.entity.User;
import com.three.server.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;
    // 增加顾客
    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody Customer customer) {
        int effNum = customerService.insertCustomer(customer);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "顾客增加失败");
    }

    // 更新顾客信息
    @PostMapping("/update")
    public ApiResponse<Void> update(@RequestBody Customer customer) {
        int effNum = customerService.updateCustomer(customer);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "顾客增加失败");
    }

    // 删除顾客
    @GetMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable Integer id) {
        int effNum = customerService.deleteCustomerById(id);
        System.out.println(effNum);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "顾客删除失败");
    }

    // 查找所有顾客
    @GetMapping("/findAll")
    public ApiResponse<List<Customer>> findAll() {
        return ApiResponse.success(customerService.findAll());
    }

    // 根据用户名查找顾客
    @GetMapping("/findByUsername/{username}")
    public ApiResponse<Customer> findByUsername(@PathVariable String username) {
        System.out.println(username);
        if (customerService.selectCustomerByUsername(username) == null)
            return ApiResponse.fail(501,"没有对应的顾客");
        return ApiResponse.success(customerService.selectCustomerByUsername(username));
    }

    // 根据用户Id查找顾客
    @GetMapping("/findById/{id}")
    public ApiResponse<Customer> findById(@PathVariable Integer id) {
        if (customerService.selectCustomerById(id) == null)
            return ApiResponse.fail(501,"没有对应的顾客");
        return ApiResponse.success(customerService.selectCustomerById(id));
    }


    // 多条件查询客户信息接口
    @GetMapping("/filter")
    public ApiResponse<List<Customer>> filter(@RequestParam(required = false) String name,
                                              @RequestParam(required = false) String phone) {
        return ApiResponse.success(customerService.selectCustomerByNameAndPhone(name, phone));
    }

    // 上传顾客头像
    @PostMapping("/uploadAvatar")
        public ApiResponse<String> uploadAvatar(@RequestBody MultipartFile avatar,HttpServletRequest request){
        if (request.getHeader("token").isEmpty()) return ApiResponse.fail(501,"身份验证失败");
        String id = String.valueOf(JWT.decode(request.getHeader("token")).getClaim("id"));
        System.out.println("controller:"+id);
        String res = customerService.uploadCustomerAvatar(avatar, Integer.valueOf(id.replaceAll("\"", "")));
        return res != null ? ApiResponse.success(res) : ApiResponse.fail(501,"头像保存失败");
    }
}
