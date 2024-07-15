package com.three.server.controller;

import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.service.impl.ViewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/view")
public class ViewController {
    private final ViewServiceImpl viewService;

    @GetMapping("/getClassificationPerDay")
    public ApiResponse<List<Map>> getClassificationPerDay() {
        return ApiResponse.success(viewService.getClassificationPerDay());
    }

    @GetMapping("/getClassificationPerDay/{date}/{classification}")
    public ApiResponse<Map> getClassificationPerDay(
            @PathVariable("date") Date date,
            @PathVariable("classification") Integer classification) {
        Map classificationPerDay = viewService.getClassificationPerDay(date, classification);
        if (classificationPerDay == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(classificationPerDay);
    }

    @GetMapping("/getClassificationPerMonth")
    public ApiResponse<List<Map>> getClassificationPerMonth() {
        return ApiResponse.success(viewService.getClassificationPerMonth());
    }

    @GetMapping("/getClassificationPerMonth/{year}/{month}/{classification}")
    public ApiResponse<Map> getClassificationPerMonth(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month,
            @PathVariable("classification") Integer classification) {
        Map classificationPerMonth = viewService.getClassificationPerMonth(year, month, classification);
        if (classificationPerMonth == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(classificationPerMonth);
    }

    @GetMapping("/getClassificationPerYear")
    public ApiResponse<List<Map>> getClassificationPerYear() {
        return ApiResponse.success(viewService.getClassificationPerYear());
    }

    @GetMapping("/getClassificationPerYear/{year}/{classification}")
    public ApiResponse<Map> getClassificationPerYear(
            @PathVariable("year") Integer year,
            @PathVariable("classification") Integer classification) {
        Map classificationPerYear = viewService.getClassificationPerYear(year, classification);
        if (classificationPerYear == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(classificationPerYear);
    }

    @GetMapping("/getMoneyPerDay")
    public ApiResponse<List<Map>> getMoneyPerDay() {
        return ApiResponse.success(viewService.getMoneyPerDay());
    }

    @GetMapping("/getMoneyPerDay/{date}")
    public ApiResponse<Map> getMoneyPerDay(@PathVariable("date") Date date) {
        Map moneyPerDay = viewService.getMoneyPerDay(date);
        if (moneyPerDay == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(moneyPerDay);
    }

    @GetMapping("/getMoneyPerMonth")
    public ApiResponse<List<Map>> getMoneyPerMonth() {
        return ApiResponse.success(viewService.getMoneyPerMonth());
    }

    @GetMapping("/getMoneyPerMonth/{year}/{month}")
    public ApiResponse<Map> getMoneyPerMonth(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month) {
        Map moneyPerMonth = viewService.getMoneyPerMonth(year, month);
        if (moneyPerMonth == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(moneyPerMonth);
    }

    @GetMapping("/getMoneyPerYear")
    public ApiResponse<List<Map>> getMoneyPerYear() {
        return ApiResponse.success(viewService.getMoneyPerYear());
    }

    @GetMapping("/getMoneyPerYear/{year}")
    public ApiResponse<Map> getMoneyPerYear(@PathVariable("year") Integer year) {
        Map moneyPerYear = viewService.getMoneyPerYear(year);
        if (moneyPerYear == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(moneyPerYear);
    }

    @GetMapping("/getSalePerDay")
    public ApiResponse<List<Map>> getSalePerDay() {
        return ApiResponse.success(viewService.getSalePerDay());
    }

    @GetMapping("/getSalePerDay/{date}")
    public ApiResponse<Map> getSalePerDay(@PathVariable("date") Date date) {
        Map salePerDay = viewService.getSalePerDay(date);
        if (salePerDay == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(salePerDay);
    }

    @GetMapping("/getSalePerMonth")
    public ApiResponse<List<Map>> getSalePerMonth() {
        return ApiResponse.success(viewService.getSalePerMonth());
    }

    @GetMapping("/getSalePerMonth/{year}/{month}")
    public ApiResponse<Map> getSalePerMonth(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month) {
        Map salePerMonth = viewService.getSalePerMonth(year, month);
        if (salePerMonth == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(salePerMonth);
    }

    @GetMapping("/getSalePerYear")
    public ApiResponse<List<Map>> getSalePerYear() {
        return ApiResponse.success(viewService.getSalePerYear());
    }

    @GetMapping("/getSalePerYear/{year}")
    public ApiResponse<Map> getSalePerYear(@PathVariable("year") Integer year) {
        Map salePerYear = viewService.getSalePerYear(year);
        if (salePerYear == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(salePerYear);
    }

    @GetMapping("/getSellerClassificationPerDay")
    public ApiResponse<List<Map>> getSellerClassificationPerDay() {
        return ApiResponse.success(viewService.getSellerClassificationPerDay());
    }

    @GetMapping("/getSellerClassificationPerDay/{date}/{seller}/{classification}")
    public ApiResponse<Map> getSellerClassificationPerDay(
            @PathVariable("date") Date date,
            @PathVariable("seller") Integer seller,
            @PathVariable("classification") Integer classification) {
        Map sellerClassificationPerDay = viewService.getSellerClassificationPerDayWithParams(date, seller, classification);
        if (sellerClassificationPerDay == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerClassificationPerDay);
    }

    @GetMapping("/getSellerClassificationPerMonth")
    public ApiResponse<List<Map>> getSellerClassificationPerMonth() {
        return ApiResponse.success(viewService.getSellerClassificationPerMonth());
    }

    @GetMapping("/getSellerClassificationPerMonth/{year}/{month}/{seller}/{classification}")
    public ApiResponse<Map> getSellerClassificationPerMonth(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month,
            @PathVariable("seller") Integer seller,
            @PathVariable("classification") Integer classification) {
        Map sellerClassificationPerMonth = viewService.getSellerClassificationPerMonthWithParams(year, month, seller, classification);
        if (sellerClassificationPerMonth == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerClassificationPerMonth);
    }

    @GetMapping("/getSellerClassificationPerYear")
    public ApiResponse<List<Map>> getSellerClassificationPerYear() {
        return ApiResponse.success(viewService.getSellerClassificationPerYear());
    }

    @GetMapping("/getSellerClassificationPerYear/{year}/{seller}/{classification}")
    public ApiResponse<Map> getSellerClassificationPerYear(
            @PathVariable("year") Integer year,
            @PathVariable("seller") Integer seller,
            @PathVariable("classification") Integer classification) {
        Map sellerClassificationPerYear = viewService.getSellerClassificationPerYearWithParams(year, seller, classification);
        if (sellerClassificationPerYear == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerClassificationPerYear);
    }

    @GetMapping("/getSellerMoneyPerDay")
    public ApiResponse<List<Map>> getSellerMoneyPerDay() {
        return ApiResponse.success(viewService.getSellerMoneyPerDay());
    }

    @GetMapping("/getSellerMoneyPerDay/{date}/{seller}")
    public ApiResponse<Map> getSellerMoneyPerDay(
            @PathVariable("date") Date date,
            @PathVariable("seller") Integer seller) {
        Map sellerMoneyPerDay = viewService.getSellerMoneyPerDayWithParams(date,seller);
        if (sellerMoneyPerDay == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerMoneyPerDay);
    }

    @GetMapping("/getSellerMoneyPerMonth")
    public ApiResponse<List<Map>> getSellerMoneyPerMonth() {
        return ApiResponse.success(viewService.getSellerMoneyPerMonth());
    }

    @GetMapping("/getSellerMoneyPerMonth/{year}/{month}/{seller}")
    public ApiResponse<Map> getSellerMoneyPerMonth(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month,
            @PathVariable("seller") Integer seller) {
        Map sellerMoneyPerMonth = viewService.getSellerMoneyPerMonthWithParams(year, month, seller);
        if (sellerMoneyPerMonth == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerMoneyPerMonth);
    }

    @GetMapping("/getSellerMoneyPerYear")
    public ApiResponse<List<Map>> getSellerMoneyPerYear() {
        return ApiResponse.success(viewService.getSellerMoneyPerYear());
    }

    @GetMapping("/getSellerMoneyPerYear/{year}/{seller}")
    public ApiResponse<Map> getSellerMoneyPerYear(
            @PathVariable("year") Integer year,
            @PathVariable("seller") Integer seller) {
        Map sellerMoneyPerYear = viewService.getSellerMoneyPerYearWithParams(year,seller);
        if (sellerMoneyPerYear == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerMoneyPerYear);
    }

    @GetMapping("/getSellerSalePerDay")
    public ApiResponse<List<Map>> getSellerSalePerDay() {
        return ApiResponse.success(viewService.getSellerSalePerDay());
    }

    @GetMapping("/getSellerSalePerDay/{date}/{seller}")
    public ApiResponse<Map> getSellerSalePerDay(
            @PathVariable("date") Date date,
            @PathVariable("seller") Integer seller) {
        Map sellerSalePerDay = viewService.getSellerSalePerDayWithParams(date, seller);
        if (sellerSalePerDay == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerSalePerDay);
    }

    @GetMapping("/getSellerSalePerMonth")
    public ApiResponse<List<Map>> getSellerSalePerMonth() {
        return ApiResponse.success(viewService.getSellerSalePerMonth());
    }

    @GetMapping("/getSellerSalePerMonth/{year}/{month}/{seller}")
    public ApiResponse<Map> getSellerSalePerMonth(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month,
            @PathVariable("seller") Integer seller) {
        Map sellerSalePerMonth = viewService.getSellerSalePerMonthWithParams(year, month, seller);
        if (sellerSalePerMonth == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerSalePerMonth);
    }

    @GetMapping("/getSellerSalePerYear")
    public ApiResponse<List<Map>> getSellerSalePerYear() {
        return ApiResponse.success(viewService.getSellerSalePerYear());
    }

    @GetMapping("/getSellerSalePerYear/{year}/{seller}")
    public ApiResponse<Map> getSellerSalePerYear(
            @PathVariable("year") Integer year,
            @PathVariable("seller") Integer seller) {
        Map sellerSalePerYear = viewService.getSellerSalePerYearWithParams(year, seller);
        if (sellerSalePerYear == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(sellerSalePerYear);
    }

    @GetMapping("/getTotalCityFlow")
    public ApiResponse<List<Map>> getTotalCity() {
        return ApiResponse.success(viewService.getTotalCity());
    }

    @GetMapping("/getTotalCityFlow/{city}")
    public ApiResponse<Map> getTotalCity(
            @PathVariable("city") Integer city) {
        Map totalCity = viewService.getTotalCityWithParams(city);
        if (totalCity == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(totalCity);
    }

    @GetMapping("/getTotalGoodFlow")
    public ApiResponse<List<Map>> getTotalGoodFlow() {
        return ApiResponse.success(viewService.getTotalGoodFlow());
    }

    @GetMapping("/getTotalGoodFlow/{seller}/{classification}")
    public ApiResponse<Map> getTotalGoodFlow(
            @PathVariable("seller") Integer seller,
            @PathVariable("classification") Integer classification) {
        Map totalGoodFlow = viewService.getTotalGoodFlowWithParams(seller, classification);
        if (totalGoodFlow == null) return ApiResponse.fail(501, "没有对应的销售数据");
        return ApiResponse.success(totalGoodFlow);
    }


    @GetMapping("/getTotalSellerSubscription")
    public ApiResponse<List<Map>> getTotalSellerSubscription() {
        return ApiResponse.success(viewService.getTotalSellerSubscription());
    }

}
