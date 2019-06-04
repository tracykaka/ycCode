package com.yingchong.service.data_service;

import com.yingchong.service.data_service.service.AppTypeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testLocaDate {
    public static void main(String[] args) {
        /*LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2018, 5, 1);
        for (LocalDate date = today.minusDays(1); date.isAfter(endDate); date = date.minusDays(1))
        {
            System.out.println(date);
        }*/


        testLocaDate t = new testLocaDate();
        t.forMethod("2019-05-15","2019-05-20");
    }


    public void forMethod(String startDate,String endDate){
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(AppTypeService.dateParttern));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(AppTypeService.dateParttern));
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
        {
            System.out.println(date);
        }
    }
}
