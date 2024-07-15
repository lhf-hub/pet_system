package com.three.server.service;

import com.three.server.DTO.OrderDetailsDTO;
import com.three.server.entity.Order;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> findAll();
    Order findById(Integer id);
    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(Integer id);
    OrderDetailsDTO findOrderAndDetailsById(Integer id);
    List<OrderDetailsDTO> findByTime(Map<String, Timestamp> timeScope);
}
