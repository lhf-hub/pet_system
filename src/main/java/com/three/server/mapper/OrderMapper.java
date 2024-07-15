package com.three.server.mapper;

import com.three.server.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    List<Order> findAll();
    Order findById(Integer id);
    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(Integer id);
    List<Order> findByTime(Map<String, Timestamp> params);
}
