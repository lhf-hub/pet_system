package com.three.server.controller;

import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.entity.City;
import com.three.server.service.impl.CityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityServiceImpl cityService;

    // 增加城市
    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody City city) {
        int effNum = cityService.addCity(city);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "城市增加失败");
    }

    // 更新城市信息
    @PostMapping("/update")
    public ApiResponse<Void> update(@RequestBody City city) {
        int effNum = cityService.updateCity(city);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "城市更新失败");
    }

    // 删除城市
    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable Integer id) {
        int effNum = cityService.deleteCity(id);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "城市删除失败");
    }

    // 查找所有城市
    @GetMapping("/findAll")
    public ApiResponse<List<City>> findAll() {
        return ApiResponse.success(cityService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ApiResponse<City> findById(@PathVariable Integer id) {
        if (cityService.findById(id) == null) return ApiResponse.fail(501,"找不到对应的城市");
        return ApiResponse.success(cityService.findById(id));
    }

    // 多条件查询客户信息接口
    @GetMapping("/filterByName/{name}")
    public ApiResponse<List<City>> filterByName(@PathVariable("name") String name) {
        return ApiResponse.success(cityService.filterByName(name));
    }
}
