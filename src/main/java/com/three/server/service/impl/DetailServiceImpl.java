package com.three.server.service.impl;

import com.three.server.entity.Detail;
import com.three.server.mapper.DetailMapper;
import com.three.server.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final DetailMapper detailMapper;
    @Override
    public Detail findById(Integer id) {
        return detailMapper.findById(id);
    }

    @Override
    public List<Detail> findAll() {
        return detailMapper.findAll();
    }

    @Override
    public int addDetail(Detail detail) {
        return detailMapper.addDetail(detail);
    }

    @Override
    public int updateDetail(Detail detail) {
        return detailMapper.updateDetail(detail);
    }

    @Override
    public int deleteDetail(Integer id) {
        return detailMapper.deleteDetail(id);
    }

    @Override
    public List<Detail> findByOrderId(Integer orderId) {
        return detailMapper.findByOrderId(orderId);
    }
}
