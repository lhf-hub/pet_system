package com.three.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubscriptionMapper {
    Boolean isExist(@Param("customerId") Integer customerId, @Param("sellerId") Integer sellerId);
}

