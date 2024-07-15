package com.three.server.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface ViewService {
    List<Map> getClassificationPerDay();
    List<Map> getClassificationPerMonth();
    List<Map> getClassificationPerYear();
    List<Map> getMoneyPerDay();
    List<Map> getMoneyPerMonth();
    List<Map> getMoneyPerYear();
    List<Map> getSalePerDay();
    List<Map> getSalePerMonth();
    List<Map> getSalePerYear();
    Map getClassificationPerDay(Date date, Integer classification);
    Map getClassificationPerMonth(Integer year,Integer month,Integer classification);
    Map getClassificationPerYear(Integer year,Integer classification);
    Map getMoneyPerDay(Date date);
    Map getMoneyPerMonth(Integer year,Integer month);
    Map getMoneyPerYear(Integer year);
    Map getSalePerDay(Date date);
    Map getSalePerMonth(Integer year,Integer month);
    Map getSalePerYear(Integer year);

    List<Map> getSellerClassificationPerDay();
    List<Map> getSellerClassificationPerMonth();
    List<Map> getSellerClassificationPerYear();
    List<Map> getSellerMoneyPerDay();
    List<Map> getSellerMoneyPerMonth();
    List<Map> getSellerMoneyPerYear();
    List<Map> getSellerSalePerDay();
    List<Map> getSellerSalePerMonth();
    List<Map> getSellerSalePerYear();

    Map getSellerClassificationPerDayWithParams(Date date, int seller,int classification);
    Map getSellerClassificationPerMonthWithParams(int year,int day,int seller,int classification);
    Map getSellerClassificationPerYearWithParams(int year,int seller,int classification);
    Map getSellerMoneyPerDayWithParams(Date date, int seller);
    Map getSellerMoneyPerMonthWithParams(int year,int month,int seller);
    Map getSellerMoneyPerYearWithParams(int year,int seller);
    Map getSellerSalePerDayWithParams(Date date, int seller);
    Map getSellerSalePerMonthWithParams(int year,int month,int seller);
    Map getSellerSalePerYearWithParams(int year,int seller);

    List<Map> getTotalCity();
    Map getTotalCityWithParams(Integer city);
    List<Map> getTotalGoodFlow();
    Map getTotalGoodFlowWithParams(Integer seller, Integer classification);
    List<Map> getTotalSellerSubscription();
}
