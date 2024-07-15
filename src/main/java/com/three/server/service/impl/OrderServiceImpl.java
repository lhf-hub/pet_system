package com.three.server.service.impl;

import com.three.server.DTO.OrderDetailsDTO;
import com.three.server.entity.Detail;
import com.three.server.entity.Order;
import com.three.server.exception.InvalidTimeRangeException;
import com.three.server.mapper.DetailMapper;
import com.three.server.mapper.OrderMapper;
import com.three.server.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final DetailMapper detailMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.findById(id);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public OrderDetailsDTO findOrderAndDetailsById(Integer id) {
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
        Order order = orderMapper.findById(id);
        orderDetailsDTO.setOrder(order);
        List<Detail> details = detailMapper.findByOrderId(id);
        orderDetailsDTO.setDetails(details);
        return orderDetailsDTO;
    }

    @Override
    public List<OrderDetailsDTO> findByTime(Map<String, Timestamp> timeScope) {
        Timestamp startTime = timeScope.get("startTime");
        Timestamp endTime = timeScope.get("endTime");
        if (startTime != null && endTime != null && startTime.after(endTime)) {
            throw new InvalidTimeRangeException("开始时间不能在结束时间之后.");
        }
        List<Order> orders = orderMapper.findByTime(timeScope);
        List<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>();
        orders.forEach(order -> {
            orderDetailsDTOS.add(findOrderAndDetailsById(order.getId()));
        });
        return orderDetailsDTOS;
    }
}
