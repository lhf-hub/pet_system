package com.three.server.service.impl;

import com.three.server.DTO.ActivityFilterDTO;
import com.three.server.entity.Activity;
import com.three.server.mapper.ActivityMapper;
import com.three.server.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ActivityServiceImpl implements ActivityService{
    private final ActivityMapper activityMapper;

    @Override
    public Activity findById(Integer id) {
        return activityMapper.findById(id);
    }

    @Override
    public List<Activity> findAll() {
        return activityMapper.findAll();
    }

    @Override
    public int addActivity(Activity activity) {
        return activityMapper.addActivity(activity);
    }

    @Override
    public int updateActivity(Activity activity) {
        return activityMapper.updateActivity(activity);
    }

    @Override
    public int deleteActivity(Integer id) {
        return activityMapper.deleteActivity(id);
    }

    @Override
    public List<Activity> filterActivity(ActivityFilterDTO activityFilterDTO) {
        return activityMapper.filterActivity(activityFilterDTO);
    }
}
