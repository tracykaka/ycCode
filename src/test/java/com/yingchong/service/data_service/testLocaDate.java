package com.yingchong.service.data_service;

import java.time.LocalDate;

public class testLocaDate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2018, 5, 1);
        for (LocalDate date = today.minusDays(1); date.isAfter(endDate); date = date.minusDays(1))
        {
            System.out.println(date);
        }
    }
}
