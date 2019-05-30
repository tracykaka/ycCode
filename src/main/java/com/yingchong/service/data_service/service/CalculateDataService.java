package com.yingchong.service.data_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalculateDataService {

    private static final Logger logger = LoggerFactory.getLogger(CalculateDataService.class);
    @Autowired
    private IndexService indexService;

    @Autowired
    private AppTypeService appTypeService;

    @Autowired
    private ReligionService religionService;

    public void calculDate() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2018, 9, 1);
        for (LocalDate date = today.minusDays(1); date.isBefore(endDate); date = date.minusDays(1))
        {
            logger.info("计算:{}的数据",date);
            this.TimeTask(date.toString());
        }
    }

    public void TimeTask(String date) {
        try {
            //插入流量每日数据
            indexService.insertFluxResult(date);
        } catch (Exception e) {
            logger.error("插入流量每日数据异常",e);
        }

        try {
            //上网时长,每日同步数据
            indexService.insertOnlineTime(date);
        } catch (Exception e) {
            logger.error("上网时长,每日同步数据",e);
        }

        try {
            //应用流量，每日同步数据
            indexService.insertAppFluxSort(date);
        } catch (Exception e) {
            logger.error("应用流量，每日同步数据",e);
        }

        try {
            //网络行为意识分类每日数据
            appTypeService.insertActionType(date);
        } catch (Exception e) {
            logger.error("网络行为意识分类每日数据",e);
        }

        try {
            //插入宗教访问次数结果集 此接口较慢
            religionService.insertReligionTimes(date);
        } catch (Exception e) {
            logger.error("网络行为意识分类每日数据",e);
        }
    }

}
