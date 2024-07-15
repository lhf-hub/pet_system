package com.three.server.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ViewMapper {
    List<Map> getClassificationPerDay();
    List<Map> getClassificationPerMonth();
    List<Map> getClassificationPerYear();
    List<Map> getMoneyPerDay();
    List<Map> getMoneyPerMonth();
    List<Map> getMoneyPerYear();
    List<Map> getSalePerDay();
    List<Map> getSalePerMonth();
    List<Map> getSalePerYear();


    Map getClassificationPerDayWithParams(Map params);
    Map getClassificationPerMonthWithParams(Map params);
    Map getClassificationPerYearWithParams(Map params);
    Map getMoneyPerDayWithParams(Map params);
    Map getMoneyPerMonthWithParams(Map params);
    Map getMoneyPerYearWithParams(Map params);
    Map getSalePerDayWithParams(Map params);
    Map getSalePerMonthWithParams(Map params);
    Map getSalePerYearWithParams(Map params);

    List<Map> getSellerClassificationPerDay();
    List<Map> getSellerClassificationPerMonth();
    List<Map> getSellerClassificationPerYear();
    List<Map> getSellerMoneyPerDay();
    List<Map> getSellerMoneyPerMonth();
    List<Map> getSellerMoneyPerYear();
    List<Map> getSellerSalePerDay();
    List<Map> getSellerSalePerMonth();
    List<Map> getSellerSalePerYear();

    Map getSellerClassificationPerDayWithParams(Map params);
    Map getSellerClassificationPerMonthWithParams(Map params);
    Map getSellerClassificationPerYearWithParams(Map params);
    Map getSellerMoneyPerDayWithParams(Map params);
    Map getSellerMoneyPerMonthWithParams(Map params);
    Map getSellerMoneyPerYearWithParams(Map params);
    Map getSellerSalePerDayWithParams(Map params);
    Map getSellerSalePerMonthWithParams(Map params);
    Map getSellerSalePerYearWithParams(Map params);

    List<Map> getTotalCity();
    Map getTotalCityWithParams(Map params);
    List<Map> getTotalGoodFlow();
    Map getTotalGoodFlowWithParams(Map params);
    List<Map> getTotalSellerSubscription();
}
