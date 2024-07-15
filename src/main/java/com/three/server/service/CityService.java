package com.three.server.service;

import com.three.server.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {
    City findById(@Param("id") Integer id);
    List<City> findAll();
    int addCity(City city);
    int updateCity(City city);
    int deleteCity(@Param("id") Integer id);
    List<City> filterByName(String name);
}
