package com.three.server.service.impl;

import com.three.server.entity.City;
import com.three.server.mapper.CityMapper;
import com.three.server.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CityServiceImpl implements CityService {
    private final CityMapper cityMapper;
    @Override
    public City findById(Integer id) {
        return cityMapper.findById(id);
    }

    @Override
    public List<City> findAll() {
        return cityMapper.findAll();
    }

    @Override
    public int addCity(City city) {
        return cityMapper.addCity(city);
    }

    @Override
    public int updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    @Override
    public int deleteCity(Integer id) {
        return cityMapper.deleteCity(id);
    }

    @Override
    public List<City> filterByName(String name) {
        return cityMapper.filterByName(name);
    }
}
