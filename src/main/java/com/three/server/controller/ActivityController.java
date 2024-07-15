package com.three.server.controller;

import com.three.server.DTO.ActivityFilterDTO;
import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.entity.Activity;
import com.three.server.entity.Customer;
import com.three.server.service.impl.ActivityServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityServiceImpl activityService;
    // 增加活动
    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody Activity activity) {
        int effNum = activityService.addActivity(activity);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "活动增加失败");
    }

    // 更新活动信息
    @PostMapping("/update")
    public ApiResponse<Void> update(@RequestBody Activity activity) {
        int effNum = activityService.updateActivity(activity);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "活动更新失败");
    }

    // 删除活动
    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> delete(@PathVariable Integer id) {
        int effNum = activityService.deleteActivity(id);
        return effNum >= 1 ? ApiResponse.success() : ApiResponse.fail(501, "活动删除失败");
    }

    // 查找所有活动
    @GetMapping("/findAll")
    public ApiResponse<List<Activity>> findAll() {
        return ApiResponse.success(activityService.findAll());
    }

    // 多条件查询客户信息接口
    @PostMapping("/filter")
    public ApiResponse<List<Activity>> filter(@RequestBody ActivityFilterDTO activityFilterDTO) {
        return ApiResponse.success(activityService.filterActivity(activityFilterDTO));
    }

}
