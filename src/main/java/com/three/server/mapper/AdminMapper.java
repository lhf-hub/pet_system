package com.three.server.mapper;

import com.three.server.entity.Admin;
import com.three.server.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AdminMapper {
    int add(City city);
    int update(City city);
    int delete(@Param("id") Integer id);
    Admin filterById(Integer id);
}
