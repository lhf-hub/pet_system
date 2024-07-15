package com.three.server.service;

import com.three.server.DTO.ActivityFilterDTO;
import com.three.server.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityService {
    Activity findById(@Param("id") Integer id);
    List<Activity> findAll();
    int addActivity(Activity activity);
    int updateActivity(Activity activity);
    int deleteActivity(@Param("id") Integer id);
    List<Activity> filterActivity(ActivityFilterDTO activityFilterDTO);
}
