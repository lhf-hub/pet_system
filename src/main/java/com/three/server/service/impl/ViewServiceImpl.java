package com.three.server.service.impl;

import com.three.server.mapper.ViewMapper;
import com.three.server.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class ViewServiceImpl implements ViewService {
    private final ViewMapper viewMapper;
    @Override
    public List<Map> getClassificationPerDay() {
        List<Map> views = viewMapper.getClassificationPerDay();
        return views;
    }

    @Override
    public Map getClassificationPerDay(Date date, Integer classification) {
        Map<String,Object> params = new HashMap<>();
        params.put("date",date);
        params.put("classification",classification);
        return viewMapper.getClassificationPerDayWithParams(params);
    }

    @Override
    public List<Map> getClassificationPerMonth() {
        List<Map> views = viewMapper.getClassificationPerMonth();
        return views;
    }

    public Map getClassificationPerMonth(Integer year, Integer month, Integer classification) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        params.put("classification",classification);
        Map view = viewMapper.getClassificationPerMonthWithParams(params);
        System.out.println(view);
        return view;
    }


    @Override
    public List<Map> getClassificationPerYear() {
        return viewMapper.getClassificationPerYear();
    }

    @Override
    public Map getClassificationPerYear(Integer year, Integer classification) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("classification",classification);
        Map view = viewMapper.getClassificationPerYearWithParams(params);
        return view;
    }

    @Override
    public List<Map> getMoneyPerDay() {
        return viewMapper.getMoneyPerDay();
    }

    @Override
    public Map getMoneyPerDay(Date date) {
        Map<String,Date> params = new HashMap<>();
        params.put("date",date);
        return viewMapper.getMoneyPerDayWithParams(params);
    }

    @Override
    public List<Map> getMoneyPerMonth() {
        return viewMapper.getMoneyPerMonth();
    }

    @Override
    public Map getMoneyPerMonth(Integer year, Integer month) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        return viewMapper.getMoneyPerMonthWithParams(params);
    }

    @Override
    public List<Map> getMoneyPerYear() {
        return viewMapper.getMoneyPerYear();
    }

    @Override
    public Map getMoneyPerYear(Integer year) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        return viewMapper.getMoneyPerYearWithParams(params);
    }

    @Override
    public List<Map> getSalePerDay() {
        return viewMapper.getSalePerDay();
    }

    @Override
    public Map getSalePerDay(Date date) {
        Map<String,Date> params = new HashMap<>();
        params.put("date",date);
        return viewMapper.getSalePerDayWithParams(params);
    }

    @Override
    public List<Map> getSalePerMonth() {
        return viewMapper.getSalePerMonth();
    }

    @Override
    public Map getSalePerMonth(Integer year, Integer month) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        return viewMapper.getSalePerMonthWithParams(params);
    }

    @Override
    public List<Map> getSalePerYear() {
        return viewMapper.getSalePerYear();
    }

    @Override
    public Map getSalePerYear(Integer year) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        return viewMapper.getSalePerYearWithParams(params);
    }

    @Override
    public List<Map> getSellerClassificationPerDay() {
        return viewMapper.getSellerClassificationPerDay();
    }

    @Override
    public List<Map> getSellerClassificationPerMonth() {
        return viewMapper.getSellerClassificationPerMonth();
    }

    @Override
    public List<Map> getSellerClassificationPerYear() {
        return viewMapper.getSellerClassificationPerYear();
    }

    @Override
    public List<Map> getSellerMoneyPerDay() {
        return viewMapper.getSellerMoneyPerDay();
    }

    @Override
    public List<Map> getSellerMoneyPerMonth() {
        return viewMapper.getSellerMoneyPerMonth();
    }

    @Override
    public List<Map> getSellerMoneyPerYear() {
        return viewMapper.getSellerMoneyPerYear();
    }

    @Override
    public List<Map> getSellerSalePerDay() {
        return viewMapper.getSellerSalePerDay();
    }

    @Override
    public List<Map> getSellerSalePerMonth() {
        return viewMapper.getSellerSalePerMonth();
    }

    @Override
    public List<Map> getSellerSalePerYear() {
        return viewMapper.getSellerSalePerYear();
    }

    @Override
    public Map getSellerClassificationPerDayWithParams(Date date, int seller, int classification) {
        Map<String,Object> params = new HashMap<>();
        params.put("date",date);
        params.put("seller",seller);
        params.put("classification",classification);
        return viewMapper.getSellerClassificationPerDayWithParams(params);
    }

    @Override
    public Map getSellerClassificationPerMonthWithParams(int year, int month, int seller, int classification) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        params.put("seller",seller);
        params.put("classification",classification);
        return viewMapper.getSellerClassificationPerMonthWithParams(params);
    }

    @Override
    public Map getSellerClassificationPerYearWithParams(int year, int seller, int classification) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("seller",seller);
        params.put("classification",classification);
        return viewMapper.getSellerClassificationPerYearWithParams(params);
    }

    @Override
    public Map getSellerMoneyPerDayWithParams(Date date, int seller) {
        Map<String,Object> params = new HashMap<>();
        params.put("date",date);
        params.put("seller",seller);
        return viewMapper.getSellerMoneyPerDayWithParams(params);
    }

    @Override
    public Map getSellerMoneyPerMonthWithParams(int year, int month, int seller) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        params.put("seller",seller);
        return viewMapper.getSellerMoneyPerMonthWithParams(params);
    }

    @Override
    public Map getSellerMoneyPerYearWithParams(int year, int seller) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("seller",seller);
        return viewMapper.getSellerMoneyPerYearWithParams(params);
    }

    @Override
    public Map getSellerSalePerDayWithParams(Date date, int seller) {
        Map<String,Object> params = new HashMap<>();
        params.put("date",date);
        params.put("seller",seller);
        return viewMapper.getSellerSalePerDayWithParams(params);
    }

    @Override
    public Map getSellerSalePerMonthWithParams(int year, int month, int seller) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        params.put("seller",seller);
        return viewMapper.getSellerSalePerMonthWithParams(params);
    }

    @Override
    public Map getSellerSalePerYearWithParams(int year, int seller) {
        Map<String,Integer> params = new HashMap<>();
        params.put("year",year);
        params.put("seller",seller);
        return viewMapper.getSellerSalePerYearWithParams(params);
    }


    @Override
    public List<Map> getTotalCity() {
        return viewMapper.getTotalCity();
    }

    @Override
    public Map getTotalCityWithParams(Integer city) {
        Map<String,Integer> params = new HashMap<>();
        params.put("city",city);
        return viewMapper.getTotalCityWithParams(params);
    }

    @Override
    public List<Map> getTotalGoodFlow() {
        return viewMapper.getTotalGoodFlow();
    }

    @Override
    public Map getTotalGoodFlowWithParams(Integer seller, Integer classification) {
        Map<String,Integer> params = new HashMap<>();
        params.put("seller",seller);
        params.put("classification",classification);
        return viewMapper.getTotalGoodFlowWithParams(params);
    }

    @Override
    public List<Map> getTotalSellerSubscription() {
        return viewMapper.getTotalSellerSubscription();
    }

}
