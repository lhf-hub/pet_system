package com.three.server.controller;

import com.three.server.DTO.OrderDetailsDTO;
import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.entity.Order;
import com.three.server.service.impl.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    // 增加订单
    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody Order order) {
        int effNum = orderService.addOrder(order);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "订单增加失败");
    }

    // 更新订单信息
    @PostMapping("/update")
    public ApiResponse<Void> update(@RequestBody Order order) {
        int effNum = orderService.updateOrder(order);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "订单增加失败");
    }

    // 删除订单
    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable Integer id) {
        int effNum = orderService.deleteOrder(id);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "订单删除失败");
    }

    // 查找所有订单及明细信息
    @GetMapping("/findAll")
    public ApiResponse<List<Order>> findAll() {
        return ApiResponse.success(orderService.findAll());
    }

    // 查找订单
    @GetMapping("/findById/{id}")
    public ApiResponse<Order> findById(@PathVariable Integer id) {
        return ApiResponse.success(orderService.findById(id));
    }

    // 查找订单及其明细信息
    @GetMapping("/findOrderAndDetailsById/{id}")
    public ApiResponse<OrderDetailsDTO> findOrderAndDetailsById(@PathVariable Integer id) {
        return ApiResponse.success(orderService.findOrderAndDetailsById(id));
    }

    @PostMapping("/findByTime")
    public ApiResponse<List<OrderDetailsDTO>> findByTime(@RequestBody Map<String, Timestamp> timeScope){
        return ApiResponse.success(orderService.findByTime(timeScope));
    }
}
