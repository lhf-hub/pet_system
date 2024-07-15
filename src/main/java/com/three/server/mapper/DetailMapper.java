package com.three.server.mapper;

import com.three.server.entity.Detail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DetailMapper {
    Detail findById(@Param("id") Integer id);
    List<Detail> findAll();
    int addDetail(Detail detail);
    int updateDetail(Detail detail);
    int deleteDetail(@Param("id") Integer id);
    List<Detail> findByOrderId(Integer orderId);
}
