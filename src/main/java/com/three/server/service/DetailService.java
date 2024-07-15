package com.three.server.service;

import com.three.server.entity.Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetailService {
    Detail findById(@Param("id") Integer id);
    List<Detail> findAll();
    int addDetail(Detail detail);
    int updateDetail(Detail detail);
    int deleteDetail(@Param("id") Integer id);
    List<Detail> findByOrderId(Integer orderId);
}
