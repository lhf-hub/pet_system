package com.three.server.mapper;

import com.three.server.DTO.ActivityFilterDTO;
import com.three.server.entity.Activity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActivityMapper {

    Activity findById(@Param("id") Integer id);
    List<Activity> findAll();
    int addActivity(Activity activity);
    int updateActivity(Activity activity);
    int deleteActivity(@Param("id") Integer id);
    List<Activity> filterActivity(ActivityFilterDTO activityFilterDTO);
}
